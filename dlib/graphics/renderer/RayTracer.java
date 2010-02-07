package dlib.graphics.renderer;

import java.awt.Image;
import java.util.ArrayList;

import dlib.graphics.Renderer;
import dlib.graphics.Transformable;
import dlib.graphics.Renderer.ShapeType;
import dlib.math.Trianglef;

public class RayTracer extends Transformable implements Renderer
{
	ArrayList<Trianglef> tris = new ArrayList<Trianglef>();
	
	public void begin()
	{
		
	}
	
	
	public void vertex( float x, float y )
	{
		
		
	}

	
	public void vertex( float x, float y, float z )
	{
		
		
	}

	
	public void beginShape( ShapeType type )
	{
		
	}

	
	public void box( float width, float height, float length )
	{
		
	}

	
	public void ellipse( float x, float y, float width, float height )
	{
		
	}

	
	public void endShape()
	{
		
		
	}

	
	public void fill( int c )
	{
		
		
	}

	
	public void fill( float r, float g, float b )
	{
		
		
	}

	
	public void fill( float r, float g, float b, float a )
	{
		
		
	}

	
	public void frameRate( float r )
	{
		
		
	}

	
	public void initialize()
	{
		
		
	}

	
	public void line( float x1, float y1, float x2, float y2 )
	{
		
		
	}

	
	public void line( float x1, float y1, float z1, float x2, float y2, float z2 )
	{
		
		
	}
	
	public void rect( float x, float y, float width, float height )
	{
		
		
	}

	
	public void rotate( float angle, float vx, float vy, float vz )
	{
		
		
	}

	
	public void scale( float x, float y )
	{
		
		
	}

	public void size( int x, int y )
	{
		
		
	}

	
	public void stroke( int c )
	{
		
		
	}

	
	public void stroke( float r, float g, float b )
	{
		
		
	}

	
	public void stroke( float r, float g, float b, float a )
	{
		
		
	}

	
	public void text( String text, float x, float y )
	{
		
		
	}

	
	public void texture( Image img )
	{
		
		
	}
	
	public void update()
	{
		
		
	}
}
