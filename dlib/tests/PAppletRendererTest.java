package dlib.tests;

import dlib.graphics.renderer.PAppletRenderer;

public class PAppletRendererTest extends PAppletRenderer
{
	public void setup()
	{
		size( 800, 600 );
		(new RenderableTest()).render(this);
	}
	
	public void draw()
	{
		
	}
	
	public static void main( String[] args )
	{
		PAppletRenderer.main( new String[] { "dlib.tests.PAppletRendererTest" } );
	}
}
