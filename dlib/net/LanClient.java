package dlib.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LanClient
{
	ConcurrentLinkedQueue<Serializable> toSend = new ConcurrentLinkedQueue<Serializable>(); 
	
	LanClientThread thread;
	
	ClientHandler handler;
	
	public LanClient( String host, int port, ClientHandler handler ) throws IOException
	{
		thread = new LanClientThread( this, host, port );
		this.handler = handler;
	}
	
	public void start()
	{
		
	}
	
	public void send( Serializable s )
    {
    	toSend.add( s );
    }
	
	public class LanClientThread extends Thread
	{
		Socket socket;
		
		LanClient c;
		
		ObjectOutputStream out;
		ObjectInputStream in;
		
		long timeOut;
		
		public LanClientThread( LanClient c, String host, int port ) throws IOException
		{
			super( "LanClientThread" );
			this.c = c;
			socket = new Socket( host, port );
			out = new ObjectOutputStream( socket.getOutputStream() );
			in = new ObjectInputStream( socket.getInputStream() );
			timeOut = System.currentTimeMillis();
		}
		
		public void run()
		{
			while( !timedOut() )
		    {
		    	Object oin;
		    	try
		    	{
			    	if( (oin = in.readObject() ) != null )
			    	{
			    		c.handler.handle( c, oin );
			    	}
			    	Object oout = toSend.poll();
			    	if( oout != null )
			    	{
			    		out.writeObject( oout );
			    	}
		    	}
		    	catch( IOException e )
		    	{
		    		break;
		    	}
		    	catch( ClassNotFoundException e )
				{
					break;
				}
		    }
		}
		
		public boolean timedOut()
	    {
	    	boolean b = System.currentTimeMillis() - timeOut > 10000;
	    	timeOut = System.currentTimeMillis();
	    	return b;
	    }
		    
	}
}
