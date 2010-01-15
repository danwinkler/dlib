package dlib.net;

import java.io.IOException;
import java.io.Serializable;
import java.net.ServerSocket;
import java.util.ArrayList;

public class LanServer
{
	ServerHandler handler;
	
	ArrayList<LanServerThread> clients = new ArrayList<LanServerThread>();
	
    public LanServer( ServerHandler handler ) 
    {
    	this.handler = handler;
    }
    
    public void begin( int port ) throws IOException
    {
        ServerSocket serverSocket = null;
        boolean listening = true;
        System.out.println( "S1" );
        serverSocket = new ServerSocket( port );
        System.out.println( "S2" );
        while (listening)
        {
        	System.out.println( "S3" );
        	LanServerThread n = new LanServerThread( this, serverSocket.accept() );
        	System.out.println( "S4" );
        	System.out.println( "S5" );
        	clients.add( n );
        	System.out.println( "S6" );
        	n.start();
        	System.out.println( "S7" );
        }

        serverSocket.close();
    }
    
    public void sendToAll( Serializable s )
    {
    	//Is this safe (concurrent) or should I use an Iterator? Should I synchronize?
    	for( int i = 0; i < clients.size(); i++ )
    	{
    		clients.get(i).send( s );
    	}
    }
}

