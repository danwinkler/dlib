package dlib.net;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentLinkedQueue;

public class LanServer
{
	ServerHandler sh;
	ListenerThread lt;
	Thread thread;
	
	public LanServer( int port, ServerHandler sh ) throws IOException
	{
		this.sh = sh;
		lt = new ListenerThread( port, sh );
	}
	
	public void start()
	{
		thread = new Thread( lt );
	}
	
	public void stop()
	{
		lt.stop();
	}
	
	public class ListenerThread implements Runnable
	{
		ArrayList<CommThread> cts = new ArrayList<CommThread>();
		ServerSocket s;
		
		ServerHandler serverHandler;
		
		boolean running = true;
		
		public ListenerThread( int port, ServerHandler serverHandler ) throws IOException
		{
			this.serverHandler = serverHandler;
			s = new ServerSocket( port );
		}
		
		public void run()
		{
			Socket incomingConnection;
			while( running )
			{
				try
				{
					if( (incomingConnection = s.accept()) != null )
					{
						CommThread c = new CommThread( incomingConnection, this, serverHandler );
						cts.add( c );
						(new Thread( c )).start();
					}
				} 
				catch (IOException e)
				{
					//TODO handle somehow. maybe with a log or some sort of notification system. can't throw
				}
			}
		}
		
		public void stop()
		{
			running = false;
		}
		
		public void remove( CommThread ct )
		{
			cts.remove( ct );
		}
	}
	
	public class CommThread implements Runnable
	{
		Socket s;
		ListenerThread lt;
		ServerHandler serverHandler;
		ConcurrentLinkedQueue<Serializable> toSend = new ConcurrentLinkedQueue<Serializable>();
		
		boolean running = true;
		
		public CommThread( Socket s, ListenerThread lt, ServerHandler serverHandler )
		{
			this.s = s;
			this.lt = lt;
			this.serverHandler = serverHandler;
		}
		
		public void run()
		{
			ObjectOutputStream out = null;
			ObjectInputStream in = null;
			try
			{
				out = new ObjectOutputStream( s.getOutputStream() );
				in = new ObjectInputStream( s.getInputStream() );
			} catch( IOException e )
			{
				running = false;
				//TODO Handle somehow...notify something....
			}
			
			
			while( running )
			{
				try
				{
					if( in.available() > 0 )
					{
						Object o = in.readObject(); //ALL EXCEPTIONS ARE FATAL TO STREAM. WHAT DO I DO
						if( o != null )
							serverHandler.handle( (Serializable) o );
					}
				} catch (IOException e)
				{
					//TODO handle this somehow.
				} catch (ClassNotFoundException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		public void stop()
		{
			running = false;
			lt.remove( this );
		}
	}
	
}
