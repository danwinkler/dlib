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

        serverSocket = new ServerSocket( port );

        while (listening)
        {
        	LanServerThread n = new LanServerThread(this, serverSocket.accept() );
        	clients.add( n );
        	n.start();
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

