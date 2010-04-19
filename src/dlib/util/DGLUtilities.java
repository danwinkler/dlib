package dlib.util;

import javax.media.opengl.GL;

public class DGLUtilities 
{
	public static void box( GL gl )
	{
		gl.glBegin( GL.GL_QUADS );
		//FRONT FACE
		gl.glVertex3f( -1, -1, -1 );
		gl.glVertex3f( 1, -1, -1 );
		gl.glVertex3f( 1, 1, -1 );
		gl.glVertex3f( -1, 1, -1 );
		
		//BACK FACE
		gl.glVertex3f( -1, -1, 1 );
		gl.glVertex3f( 1, -1, 1 );
		gl.glVertex3f( 1, 1, 1 );
		gl.glVertex3f( -1, 1, 1 );
		
		//TOP
		gl.glVertex3f( -1, 1, -1 );
		gl.glVertex3f( 1, 1, -1 );
		gl.glVertex3f( 1, 1, 1 );
		gl.glVertex3f( -1, 1, 1 );
		
		//BOTTOM
		gl.glVertex3f( -1, -1, -1 );
		gl.glVertex3f( 1, -1, -1 );
		gl.glVertex3f( 1, -1, 1 );
		gl.glVertex3f( -1, -1, 1 );
		
		//RIGHT
		gl.glVertex3f( 1, -1, -1 );
		gl.glVertex3f( 1, -1, 1 );
		gl.glVertex3f( 1, 1, 1 );
		gl.glVertex3f( 1, 1, -1 );
		
		//LEFT
		gl.glVertex3f( -1, -1, -1 );
		gl.glVertex3f( -1, -1, 1 );
		gl.glVertex3f( -1, 1, 1 );
		gl.glVertex3f( -1, 1, -1 );
		gl.glEnd();
	}
	
	public static void box( GL gl, int draw )
	{
		gl.glBegin( draw );
		//FRONT FACE
		gl.glVertex3f( -1, -1, -1 );
		gl.glVertex3f( 1, -1, -1 );
		gl.glVertex3f( 1, 1, -1 );
		gl.glVertex3f( -1, 1, -1 );
		gl.glEnd();
		
		gl.glBegin( draw );
		//BACK FACE
		gl.glVertex3f( -1, -1, 1 );
		gl.glVertex3f( 1, -1, 1 );
		gl.glVertex3f( 1, 1, 1 );
		gl.glVertex3f( -1, 1, 1 );
		gl.glEnd();

		gl.glBegin( draw );
		//TOP
		gl.glVertex3f( -1, 1, -1 );
		gl.glVertex3f( 1, 1, -1 );
		gl.glVertex3f( 1, 1, 1 );
		gl.glVertex3f( -1, 1, 1 );
		gl.glEnd();

		gl.glBegin( draw );
		//BOTTOM
		gl.glVertex3f( -1, -1, -1 );
		gl.glVertex3f( 1, -1, -1 );
		gl.glVertex3f( 1, -1, 1 );
		gl.glVertex3f( -1, -1, 1 );
		gl.glEnd();

		gl.glBegin( draw );
		//RIGHT
		gl.glVertex3f( 1, -1, -1 );
		gl.glVertex3f( 1, -1, 1 );
		gl.glVertex3f( 1, 1, 1 );
		gl.glVertex3f( 1, 1, -1 );
		gl.glEnd();

		gl.glBegin( draw );
		//LEFT
		gl.glVertex3f( -1, -1, -1 );
		gl.glVertex3f( -1, -1, 1 );
		gl.glVertex3f( -1, 1, 1 );
		gl.glVertex3f( -1, 1, -1 );
		gl.glEnd();

	}
}
