package dlib.game.tilemap;

import dlib.graphics.Renderable;
import dlib.math.FVec;
import dlib.math.FVec2;
import dlib.math.FVec3;

public class Tile
{
	public FVec bounds;
	public Renderable r;
	
	public Tile()
	{
		bounds = new FVec2();
	}
	
	public Tile( float x, float y )
	{
		bounds = new FVec2( x, y );
	}
	
	public Tile( float x, float y, float z )
	{
		bounds = new FVec3( x, y, z );
	}
}
