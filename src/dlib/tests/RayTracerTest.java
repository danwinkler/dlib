package dlib.tests;

import javax.vecmath.Point3f;

import dlib.graphics.irenderer.RayTracer;
import dlib.graphics.renderer.Graphics2DRenderer;
import dlib.graphics.renderer.PAppletRenderer;
import dlib.util.DGraphics;
import dlib.util.DMath;

public class RayTracerTest extends Graphics2DRenderer
{
	RayTracer rt;
	
	public void initialize() 
	{
		size( 1920, 1080 );
		frameRate( 1 );
		rt = new RayTracer( 1920, 1080 );
		rt.addLight( 0, 0, 50 );
		int boxsize = 25;
		for( int i = 0; i < 100; i++ )
		{
			rt.pushMatrix();
			rt.translate( DMath.randomf( -200/boxsize, 200/boxsize )*boxsize, DMath.randomf( -200/boxsize, 200/boxsize )*boxsize, DMath.randomf( 400/boxsize, 800/boxsize )*boxsize );
			rt.fill( DMath.randomf() * 255, DMath.randomf() * 255, DMath.randomf() * 255 );
			rt.box( 25, 25, 25 );
			rt.popMatrix();
		}
		rt.translate( 0, 0, 3200 );
		rt.rotateY( (float) (Math.PI / 4.f) );
		rt.fill( DGraphics.rgb(255, 255, 255) );
		rt.box( 600, 600, 1800);
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
