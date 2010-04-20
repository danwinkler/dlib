package dlib.tests;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.GL;
import javax.media.opengl.glu.GLU;

import dlib.graphics.renderer.GLRenderer;
import dlib.util.DGLUtilities;
import dlib.util.DTimer;

public class GLRendererTest extends GLRenderer implements KeyListener
{
	DTimer timer = new DTimer( 30 );
	int land = 25;
	
	int x = 0; 
	int y = 0;
	float heading;
	
	public void initialize()
	{
		
		g.glNewList( land, GL.GL_COMPILE );
		for( int x = 0; x < 100; x++ )
		{
			for( int y = 0; y < 100; y++ )
			{
				beginShape( ShapeType.LINE_STRIP );
				vertex( x, y, func( x, y ) );
				vertex( x+1, y, func( x+1, y ) );
				vertex( x+1, y+1, func( x+1, y+1 ) );
				vertex( x, y+1, func( x, y+1 ) );
				endShape();
			}
		}
		g.glEndList();
	}
	
	public void update()
	{
		timer.update();
	}
	
	float r = 0.f;
	
	public void render() 
	{
		g.glLoadIdentity();
		perspective();
		setFarClip( 500 );
		lookAt( 0, 0, 5, 10, 10, 5, 0, 0, 1 );
		
		g.glClear( GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT );
		g.glEnable( GL.GL_DEPTH_TEST );
		r += timer.getChange()/(float)DTimer.nanoSeconds;
		/*
		pushMatrix();
			translate( 0, 0, 0 );
			scale( .5f, .5f, .5f );
			fill( r%255, (r+100)%255, (r+200)%255 );
			rotateX( r );
			rotateY( r );
			rotateZ( r );
			box( 1, 1, 1 );
		popMatrix();
		*/
		translate( -r, -r, 0 );
		fill( 0, 255, 0 );
		g.glCallList( land );
	}
	
	public static float func( float x, float y )
	{
		return (float)(Math.sin( x*.5f ) + Math.cos( y*.25f ));
	}
	
	public static void main( String[] args )
	{
		GLRendererTest g = new GLRendererTest();
		g.begin();
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	
}
