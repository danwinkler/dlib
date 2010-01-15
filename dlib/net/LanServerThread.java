package dlib.net;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * LanServerThread handles an individual client for the main server. It alerts the server when a message is received,
 * and allows messages to be sent back to the client.
 * @author Dan Winkler
 *
 */
public class LanServerThread extends Thread 
{
    private Socket socket = null;
    
    LanServer serv;
    
    long timeOut;
    
    ConcurrentLinkedQueue<Serializable> toSend = new ConcurrentLinkedQueue<Serializable>(); 

    public LanServerThread(LanServer serv, Socket socket) 
    {
		super( "LanServerThread" );
		this.serv = serv;
		this.socket = socket;
		timeOut = System.currentTimeMillis();
    }

    public void run() 
    {
		try {
		    ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
		    ObjectInputStream in = new ObjectInputStream( socket.getInputStream() );
		    
		    while( !timedOut() )
		    {
		    	Object oin;
		    	if( (oin = in.readObject() ) != null )
		    	{
		    		System.out.println( "serv rec" );
		    		serv.handler.handle( serv, oin );
		    	}
		    	Object oout = toSend.poll();
		    	if( oout != null )
		    	{
		    		out.writeObject( oout );
		    	}
		    }
		    serv.clients.remove( this );
		} 
		catch( IOException e ) 
		{
		    e.printStackTrace();
		    serv.clients.remove( this );
		} 
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
			serv.clients.remove( this );
		}
    }
    
    public boolean timedOut()
    {
    	boolean b = System.currentTimeMillis() - timeOut > 10000;
    	timeOut = System.currentTimeMillis();
    	return b;
    }
    
    public void send( Serializable s )
    {
    	toSend.add( s );
    }
}

