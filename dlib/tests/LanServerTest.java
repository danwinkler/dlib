package dlib.tests;

import java.io.IOException;

import dlib.net.LanServer;
import dlib.net.ServerHandler;

public class LanServerTest
{
	LanServer server;
	
	public LanServerTest()
	{
		
		server = new LanServer( new LSTHandler() );
	}
	
	public void go()
	{
		try
		{
			server.begin( 32487 );
			
			while( true )
			{
				Thread.sleep( 1000 );
				server.sendToAll( "Hello out There!" );
			}
		} catch (IOException e)
		{
			System.out.println( "Could not start server" );
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public class LSTHandler implements ServerHandler
	{

		public void handle( LanServer s, Object o )
		{
			System.out.println( "Server:" + (String)o ); 
			s.sendToAll( "Hey I'm replying" );
		}
		
	}
	
	public static void main( String[] args )
	{
		LanServerTest ls = new LanServerTest();
		ls.go();
	}
}
