package dlib.tests;

import java.io.IOException;

import dlib.net.ClientHandler;
import dlib.net.LanClient;
import dlib.net.LanServer;
import dlib.net.ServerHandler;

public class LanClientTest
{
	LanClient client;
	
	public LanClientTest()
	{
		
		try
		{
			client = new LanClient( "localhost", 32487, new LCTHandler() );
		} catch (IOException e)
		{
			System.out.println( "Coult not connect" );
			e.printStackTrace();
		}
	}
	
	public void go()
	{
		client.send( new String( "sup" ) );
		
	}
	
	public class LCTHandler implements ClientHandler
	{

		public void handle( LanClient c, Object o )
		{
			System.out.println( "Client:" + (String)o ); 
			c.send( new String( "Hey I'm replying" ) );
		}
		
	}
	
	public static void main( String[] args )
	{
		LanClientTest lc = new LanClientTest();
		lc.go();
	}
}