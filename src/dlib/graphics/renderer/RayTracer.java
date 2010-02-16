package dlib.graphics.renderer;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import dlib.graphics.Renderer;
import dlib.graphics.Transformable;
import dlib.graphics.Renderer.ShapeType;
import dlib.math.Intersection;
import dlib.math.Rayf;
import dlib.math.Trianglef;
import dlib.util.DGeom;
import dlib.util.DGraphics;

public class RayTracer extends Transformable implements Renderer
{
	ArrayList<Trianglef> tris = new ArrayList<Trianglef>();
	ArrayList<Point3f> vertexBuffer = new ArrayList<Point3f>();
	ArrayList<Point3f> lights = new ArrayList<Point3f>();
	
	ShapeType mode;
	BufferedImage im;
	int width;
	int height;
	
	int color;
	
	int backgroundColor = DGraphics.rgb( 0, 0, 0 );
	
	Point3f cameraLoc = new Point3f( 0, 0, 0 );
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
		int threadnum = 8;
		for( threadnum = 8; threadnum <= width; threadnum++ )
		{
			if( width % threadnum == 0 )
				break;
		}
		int chunkwidth = width/threadnum;
		for( int i = 0; i < threadnum; i++ )
		{
			TracerThread t = new TracerThread( i*chunkwidth, chunkwidth );
			new Thread( t ).start();
		}
	}
	
	public class TracerThread implements Runnable
	{
		int x1;
		int x2;
		public TracerThread()
		{
			
		}
		
		public TracerThread( int i, int j ) 
		{
			x1 = i;
			x2 = j;
		}

		public void run() 
		{
			for( int i = x1; i < x1+x2; i++ )
			{
				for( int y = 0; y < height; y++ )
				{
					Rayf ray = new Rayf( cameraLoc, getLookVector( i, y ) );
					int col = trace( ray );
					synchronized( im )
					{
						im.setRGB( i, y,  col );
					}
				}
			}
			
		}
		
		public int trace( Rayf ray )
		{
			//For all triangles
			Intersection point = collideWithObject( ray );
			if( point != null )
			{
				//If object is found
				int col = point.getGeom().getColor(0,0);
				for( int i = 0; i < lights.size(); i++ )
				{
					Vector3f lightVec = new Vector3f();
					lightVec.sub( lights.get(i) );
					Intersection light = collideWithObject( new Rayf( point.getLoc(), lightVec ) );
					if( light == null )
						col = DGraphics.brighten( col );
					else 
						col = DGraphics.darken( col );
				}
				return col;
			}
			else 
				return backgroundColor;
		}
	}
	
	public Intersection collideWithObject( Rayf ray )
	{
		Intersection point = null;
		for( int i = 0; i < tris.size(); i++ )
		{
			Intersection temp = DGeom.rayTriangleIntersect( ray, tris.get(i) );
			if( point != null && temp != null )
			{
				if( temp.getDist() < point.getDist() )
					point = temp;
			}
			else if( point == null )
				point = temp;
		}
		return point;
	}
	
	public Vector3f getLookVector( int x, int y )
	{
		float xNorm = (float)x / (float)width;
		float yNorm = (float)y / (float)height;
		Vector3f vec = new Vector3f( (breadth * xNorm) - (breadth/2), (lift * yNorm) - (lift/2), 1 );
		return vec;
	}
	
	public BufferedImage getImage()
	{
		return im;
	}
	
	public void vertex( float x, float y )
	{
		Point3f v = new Point3f( x, y, 0 );
		transform( v );
		vertexBuffer.add( v );
	}
	
	public void vertex( float x, float y, float z )
	{
		Point3f v = new Point3f( x, y, z );
		transform( v );
		vertexBuffer.add( v );
	}

	public void beginShape( ShapeType type )
	{
		this.mode = type;
		vertexBuffer.clear();
	}

	public void box( float width, float height, float length )
	{
		beginShape( ShapeType.QUADS );
		float x2 = width/2;
		float y2 = height/2;
		float z2 = length/2;
		//TOP
		vertex( x2, y2, z2 );
		vertex( x2, -y2, z2 );
		vertex( -x2, -y2, z2 );
		vertex( -x2, y2, z2 );
		//BOTTOM
		vertex( x2, y2, -z2 );
		vertex( x2, -y2, -z2 );
		vertex( -x2, -y2, -z2 );
		vertex( -x2, y2, -z2 );
		//FRONT
		vertex( x2, y2, z2 );
		vertex( x2, y2, -z2 );
		vertex( -x2, y2, -z2 );
		vertex( -x2, y2, z2 );
		//BACK
		vertex( x2, -y2, z2 );
		vertex( x2, -y2, -z2 );
		vertex( -x2, -y2, -z2 );
		vertex( -x2, -y2, z2 );
		//LEFT
		vertex( x2, y2, z2 );
		vertex( x2, y2, -z2 );
		vertex( x2, -y2, -z2 );
		vertex( x2, -y2, z2 );
		//RIGHT
		vertex( -x2, y2, z2 );
		vertex( -x2, y2, -z2 );
		vertex( -x2, -y2, -z2 );
		vertex( -x2, -y2, z2 );
		endShape();
	}

	public void endShape()
	{
		switch( mode )
		{
		case TRIANGLES:
			for( int i = 0; i < vertexBuffer.size(); i += 3 )
			{
				tris.add( new Trianglef( vertexBuffer.get(i), vertexBuffer.get(i+1), vertexBuffer.get(i+2), color ) );
			}
		break;
		case QUADS:
			for( int i = 0; i < vertexBuffer.size(); i += 4 )
			{
				tris.add( new Trianglef( vertexBuffer.get(i), vertexBuffer.get(i+1), vertexBuffer.get(i+2), color ) );
				tris.add( new Trianglef( vertexBuffer.get(i), vertexBuffer.get(i+3), vertexBuffer.get(i+2), color ) );
			}
		break;
		}
		
		vertexBuffer.clear();
	}
	
	public void addTriangle( Point3f p1, Point3f p2, Point3f p3 )
	{
		tris.add( new Trianglef( p1, p2, p3 ) );
	}
	
	public void addTriangle( float x1, float y1, float z1, float x2, float y2, float z2, float x3, float y3, float z3 )
	{
		tris.add( new Trianglef( new Point3f( x1, y1, z1 ),  new Point3f( x2, y2, z2 ),  new Point3f( x3, y3, z3 ) ) );
	}
	
	public void addLight( float x, float y, float z )
	{
		Point3f v = new Point3f( x, y, z );
		transform( v );
		lights.add( v );
	}
	
	public void clear()
	{
		tris.clear();
	}
	
	public void fill( int c )
	{
		color = c;
	}

	
	public void fill( float r, float g, float b )
	{
		color = DGraphics.rgb( (int)r, (int)g, (int)b );
	}

	
	public void fill( float r, float g, float b, float a )
	{
		color = DGraphics.rgba( (int)r, (int)g, (int)b, (int)a );
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
	public void drawImage( Image im, float x, float y ){}
	public void rotate( float angle ) {}
}
