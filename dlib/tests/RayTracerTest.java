package dlib.tests;

import javax.vecmath.Point3f;

import dlib.DMath;
import dlib.graphics.renderer.Graphics2DRenderer;
import dlib.graphics.renderer.PAppletRenderer;
import dlib.graphics.renderer.RayTracer;
import dlib.util.DGraphics;

public class RayTracerTest extends PAppletRenderer
{
	RayTracer rt;
	
	public void initialize() 
	{
		rt = new RayTracer( 800, 600 );
		rt.fill( DGraphics.rgb(0, 255, 0) );
		rt.box( 50, 50, 50 );
		rt.begin();
		
		size( 800, 600 );
		frameRate( 1 );
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
