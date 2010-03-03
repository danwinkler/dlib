package dlib.tests;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import dlib.graphics.RenderUpdate;
import dlib.graphics.renderer.Graphics2DRenderer;

public class Graphics2DRendererTest extends Graphics2DRenderer implements KeyListener
{
	public void update()
	{
		fill( 255, 255, 255 );
		rect( 0, 0, 800, 600 );
		stroke( 255.f, 0.f, 0.f );
		rect( 50, 50, 700, 500 );
		stroke( 0, 0, 255, 128 );
		text( "Test", 100, 100 );
		stroke( 0, 255, 0, 128 );
		text( "Dans", 100, 100 );
		
		if( k.a )
			rect( 300, 300, 20, 20 );
	}

	public void initialize()
	{
		size( 800, 600 );
		addKeyListener( this );
	}
	
	public static void main( String[] args )
	{
		Graphics2DRendererTest r = new Graphics2DRendererTest();
		r.begin();
	}

	public void keyPressed(KeyEvent e) 
	{
		System.out.println( e );
		
	}

	public void keyReleased(KeyEvent e) 
	{
		System.out.println( e );
		
	}
	
	public void keyTyped(KeyEvent e) 
	{
		System.out.println( e );
		
	}
}
