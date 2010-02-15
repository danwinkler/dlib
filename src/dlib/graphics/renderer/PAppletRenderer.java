package dlib.graphics.renderer;

import java.awt.Image;
import java.util.HashMap;

import dlib.graphics.Renderer;
import dlib.math.FVec;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

@SuppressWarnings("serial")
public abstract class PAppletRenderer extends PApplet implements Renderer
{
	private HashMap<Image, PImage> imageMap = new HashMap<Image,PImage>();
	
	public void begin()
	{
		main( new String[] { this.getClass().getCanonicalName() } );
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
	
	public void drawImage( Image im, float x, float y )
	{
		PImage pimg = imageMap.get( im );
		if( pimg != null )
			image( pimg, x, y );
		else
		{
			pimg = new PImage( im );
			imageMap.put( im, pimg );
			image( pimg, x, y );
		}
	}
	
	public void setup()
	{
		initialize();
		this.ellipseMode( PConstants.CORNER );
	}
	
	public void draw()
	{
		update();
	}

	public abstract void initialize();

	public abstract void update();
}
