package dlib.graphics.renderer;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import dlib.graphics.Renderer;
import dlib.graphics.Transformable;
import dlib.graphics.Renderer.ShapeType;
import dlib.math.Rayf;
import dlib.math.Trianglef;

public class RayTracer extends Transformable implements Renderer
{
	ArrayList<Trianglef> tris = new ArrayList<Trianglef>();
	ArrayList<Point3f> vertexBuffer = new ArrayList<Point3f>();
	
	ShapeType mode;
	BufferedImage im;
	int width;
	int height;
	
	Point3f cameraLoc = new Point3f( 0, 0, -100 );
	Point3f cameraLook = new Point3f();
	float viewAngleY = 30.f;
	float viewAngleX;
	float lift = (float) Math.tan( Math.toRadians( viewAngleY ) );
	float breadth = (float) Math.tan( Math.toRadians( viewAngleX ) );
	
	public RayTracer( int x, int y )
	{
		this.width = x;
		this.height = y;

		viewAngleX = (viewAngleY/y) * x;
		
		lift = (float) Math.tan( Math.toRadians( viewAngleY ) );
		breadth = (float) Math.tan( Math.toRadians( viewAngleX ) );
		
		im = new BufferedImage( x, y, BufferedImage.TYPE_INT_ARGB );
	}
	
	public void begin()
	{
		for( int x = 0; x < width; x++ )
		{
			for( int y = 0; y < height; y++ )
			{
				Rayf ray = new Rayf( cameraLoc, getLookVector( x, y ) );
				im.setRGB( x, y, trace( ray ) );
			}
		}
	}
	
	public int trace( Rayf ray )
	{
		
	}
	
	public Vector3f getLookVector( int x, int y )
	{
		float xNorm = (float)x / (float)width;
		float yNorm = (float)y / (float)height;
		Vector3f vec = new Vector3f( (lift * xNorm) - (lift/2), (breadth * yNorm) - (breadth/2), 1 );
		return vec;
	}
	
	public BufferedImage getImage()
	{
		return im;
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

	public void initialize()
	{
		
		
	}
	
	public void size( int x, int y )
	{
		
	}
	
	public void texture( Image img )
	{	
		
	}
	
	public void update()
	{
			
	}
	
	public void ellipse( float x, float y, float width, float height ){}
	public void frameRate( float r ){}
	public void line( float x1, float y1, float x2, float y2 ){}
	public void line( float x1, float y1, float z1, float x2, float y2, float z2 ){}
	public void stroke( int c ){}
	public void stroke( float r, float g, float b ){}
	public void stroke( float r, float g, float b, float a ){}
	public void text( String text, float x, float y ){}
	public void rect( float x, float y, float width, float height ){}
}
