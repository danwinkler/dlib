package dlib.net;

/**
 * A new LanServer must be passed an object implementing ServerHandler.
 * @author Dan Winkler
 *
 */
public interface ServerHandler
{
	public Object handle( LanServer s, Object o );
}
