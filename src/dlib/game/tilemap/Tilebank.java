package dlib.game.tilemap;

import java.util.HashMap;

public class Tilebank
{
	HashMap<String, Tile> bank = new HashMap<String, Tile>();
	
	public void add( String string, Tile tile )
	{
		bank.put( string, tile );
	}
	
	public Tile get( String string )
	{
		return bank.get( string );
	}
}
