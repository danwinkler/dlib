package dlib.tests;

import javax.vecmath.Point3f;

import dlib.DMath;
import dlib.graphics.renderer.Graphics2DRenderer;
import dlib.graphics.renderer.PAppletRenderer;
import dlib.graphics.renderer.RayTracer;
import dlib.util.DGraphics;

public class RayTracerTest extends Graphics2DRenderer
{
	RayTracer rt;
	
	public void initialize() 
	{
		size( 800, 600 );
		frameRate( 1 );
		
		rt = new RayTracer( 800, 600 );
		rt.fill( DGraphics.rgb(0, 255, 0) );
		for( int i = 0; i < 10; i++ )
		{
			rt.pushMatrix();
			rt.translate( DMath.randomf( -100, 100 ), DMath.randomf( -100, 100 ), DMath.randomf( 900, 1100 ) );
			rt.fill( DMath.randomf() * 255, DMath.randomf() * 255, DMath.randomf() * 255 );
			rt.box( 50, 50, 50 );
			rt.popMatrix();
		}
		rt.begin();
		
		
	}

	public void update() 
	{
		drawImage( rt.getImage(), 0, 0 );
	}
	
	public static void main( String[] args )
	{
		RayTracerTest t = new RayTracerTest();
		t.begin();
	}
	
}
