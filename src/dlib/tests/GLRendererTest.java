package dlib.tests;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import dlib.graphics.renderer.GLRenderer;
import dlib.util.DGLUtilities;

public class GLRendererTest extends GLRenderer
{
	public void initialize()
	{
		perspective();
		lookAt( 0, 0, 5, 0, 0, -10, 0, 1, 0 );
		
	}
	
	public void update()
	{
		
	}
	
	float r = 0.f;
	
	public void render() 
	{
		g.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );
		g.glEnable( GL.GL_DEPTH_TEST );
		
		
		r += 1f;
		pushMatrix();
			translate( 0, 0, 0 );
			scale( .5f, .5f, .5f );
			fill( 255, 0, 0 );
			rotateX( r );
			rotateY( r );
			rotateZ( r );
			box( 1, 1, 1 );
		popMatrix();
	}
	
	
	
	public static void main( String[] args )
	{
		GLRendererTest g = new GLRendererTest();
		g.begin();
	}
	
}
