package dlib.tests;

import dlib.game.tilemap.Tile;
import dlib.game.tilemap.Tilebank;
import dlib.game.tilemap.Tilemap;
import dlib.graphics.Renderable;
import dlib.graphics.Renderer;
import dlib.graphics.renderer.PAppletRenderer;
import dlib.math.FVec2;

public class TilemapTest extends PAppletRenderer
{
	Tilemap tm;
	
	public void setup()
	{
		size( 800, 600 );
		tm = new Tilemap( 20, 20 );
		tm.addTile( "cooltile", new CoolTile( 20, 20 ) );
		tm.fill( "cooltile");
	}
	
	public void draw()
	{
		tm.render( this );
	}
	
	public static void main( String[] args )
	{
		PAppletRenderer.main( new String[] { "dlib.tests.TilemapTest" } );
	}
	
	public class CoolTile extends Tile
	{
		public CoolTile( float x, float y )
		{
			super( x, y ); 
			r = new Renderable() {
				public void render( Renderer r ) {
					r.ellipse( 0, 0, bounds.x, bounds.y );
				}
			};
		}
	}
}
