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
    	System.out.println( "1" );
		try {
		    ObjectOutputStream out = new ObjectOutputStream( socket.getOutputStream() );
		    ObjectInputStream in = new ObjectInputStream( socket.getInputStream() );
		    System.out.println( "2" );
		    while( !timedOut() )
		    {
		    	System.out.println( "3" );
		    	Object oin;
		    	if( (oin = in.readObject() ) != null )
		    	{
		    		System.out.println( oin );
		    		System.out.println( "4" );
		    		serv.handler.handle( serv, oin );
		    	}
		    	Object oout = toSend.poll();
		    	if( oout != null )
		    	{
		    		out.writeObject( oout );
		    		System.out.println( "5" );
		    	}
		    }
		    serv.clients.remove( this );
		} 
		catch( IOException e ) 
		{
		    e.printStackTrace();
		    serv.clients.remove( this );
		    System.out.println( "6" );
		} 
		catch( ClassNotFoundException e )
		{
			e.printStackTrace();
			serv.clients.remove( this );
			System.out.println( "7" );
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

