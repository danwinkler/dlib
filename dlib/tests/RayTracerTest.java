package dlib.tests;

import javax.vecmath.Point3f;

import dlib.graphics.renderer.Graphics2DRenderer;
import dlib.graphics.renderer.PAppletRenderer;
import dlib.graphics.renderer.RayTracer;
import dlib.util.DGraphics;
import dlib.util.DMath;

public class RayTracerTest extends Graphics2DRenderer
{
	RayTracer rt;
	
	public void initialize() 
	{
		size( 800, 600 );
		frameRate( 1 );
		rt = new RayTracer( 100, 100 );
		rt.addLight( 0, 0, 50 );
		rt.fill( DGraphics.rgb(255, 255, 255) );
		rt.box( 600, 600, 1800);
		int boxsize = 25;
		for( int i = 0; i < 100; i++ )
		{
			rt.pushMatrix();
			rt.translate( DMath.randomf( -200/boxsize, 200/boxsize )*boxsize, DMath.randomf( -200/boxsize, 200/boxsize )*boxsize, DMath.randomf( 400/boxsize, 800/boxsize )*boxsize );
			rt.fill( DMath.randomf() * 255, DMath.randomf() * 255, DMath.randomf() * 255 );
			rt.box( 25, 25, 25 );
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
