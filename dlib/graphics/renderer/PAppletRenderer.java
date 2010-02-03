package dlib.graphics.renderer;

import java.awt.Image;
import java.util.HashMap;

import dlib.graphics.Renderer;
import dlib.math.FVec;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

@SuppressWarnings("serial")
public class PAppletRenderer extends PApplet implements Renderer
{
	private HashMap<Image, PImage> imageMap = new HashMap<Image,PImage>();
	
	public void start( Renderer r )
	{
		main( new String[] { r.getClass().getCanonicalName() } );
	}
	
	public void beginShape( ShapeType type )
	{
		if( type == ShapeType.POINTS )
			beginShape( POINTS );
		else if( type == ShapeType.LINES )
			beginShape( LINES );
		else if( type == ShapeType.LINE_STRIP )
			beginShape();
		else if( type == ShapeType.TRIANGLES )
			beginShape( TRIANGLES );
		else if( type == ShapeType.TRIANGLE_STRIP )
			beginShape( TRIANGLE_STRIP );
		else if( type == ShapeType.TRIANGLE_FAN )
			beginShape( TRIANGLE_FAN );
		else if( type == ShapeType.QUADS )
			beginShape( QUADS );
		else if( type == ShapeType.QUAD_STRIP )
			beginShape( QUAD_STRIP );
	}

	public void texture( Image img )
	{
		//Caches the PImage in a HashMap so a new PImage isn't created every time texture is called.
		PImage pimg = imageMap.get( img );
		if( pimg != null )
			texture( pimg );
		else
		{
			pimg = new PImage( img );
			imageMap.put( img, pimg );
			texture( pimg );
		}
		
	}
}
