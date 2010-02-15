package dlib.game.tilemap;

import javax.vecmath.Point2f;
import javax.vecmath.Point3f;

import dlib.graphics.Renderer;
import dlib.math.FVec;

public class Tilemap
{
	Point3f tileSize;
	Tile[][] tiles;
	Tilebank tb = new Tilebank();
	
	boolean finished = false;
	
	public Tilemap( int x, int y )
	{
		tiles = new Tile[x][y];
	}
	
	public void fill( String tileName )
	{
		Tile tile = tb.get( tileName );
		tileSize = tile.bounds;
		for( int xx = 0; xx < tiles.length; xx++ )
		{
			for( int yy = 0; yy < tiles[0].length; yy++ )
			{
					tiles[xx][yy] = tile;
			}
		}
		finished = true;
	}
	
	public void addTile( String s, Tile t )
	{
		tb.add( s, t );
	}
	
	public void render( Renderer r )
	{
		if( finished )
		{
			r.pushMatrix();
			for( int x = 0; x < tiles.length; x++ )
			{
				r.pushMatrix();
				for( int y = 0; y < tiles[0].length; y++ )
				{
					tiles[x][y].r.render( r );
					r.translate( 0, tileSize.y );
				}
				r.popMatrix();
				r.translate( tileSize.x, 0 );
			}
			r.popMatrix();
		}
	}
}
