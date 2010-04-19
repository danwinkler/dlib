package dlib.tests;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import dlib.graphics.renderer.GLRenderer;
import dlib.util.DGLUtilities;

public class GLRendererTest extends GLRenderer
{
	GLU glu;
	public void initialize()
	{
		glu = new GLU();
		glu.gluPerspective( 30, 800/600, 1, 100 );
		glu.gluLookAt( 0, 0, 5, 0, 0, -10, 0, 1, 0 );
		
	}
	
	public void update()
	{
		
	}
	
	float r = 0.f;
	
	public void render() 
	{
		GL gl = getGL();
		gl.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );
		gl.glEnable( GL.GL_DEPTH_TEST );
		
		
		r += 1f;
		gl.glPushMatrix();
			gl.glTranslatef( 0, 0, 0 );
			gl.glScalef( .1f, .1f, .1f );
			gl.glColor3f( 1f, 0f, 0 );
			gl.glRotatef( r, 0, 0, 1 );
			gl.glRotatef( r, 0, 1, 0 );
			gl.glRotatef( r, 1, 0, 0 );
		gl.glPopMatrix();
	}
	
	
	
	public static void main( String[] args )
	{
		GLRendererTest g = new GLRendererTest();
		g.begin();
	}
	
}
