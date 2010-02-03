package dlib.game.tilemap;

import javax.vecmath.Point3f;

import dlib.graphics.Renderable;

public class Tile
{
	public Point3f bounds;
	public Renderable r;
	
	public Tile()
	{
		bounds = new Point3f();
	}
	
	public Tile( float x, float y )
	{
		bounds = new Point3f( x, y, 0 );
	}
	
	public Tile( float x, float y, float z )
	{
		bounds = new Point3f( x, y, z );
	}
}
