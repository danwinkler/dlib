package dlib.graphics.renderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dlib.graphics.RenderUpdate;
import dlib.graphics.Renderer;
import dlib.util.DGraphics;

public class Graphics2DRenderer implements Renderer
{
	RenderUpdate ru;
	
	JFrame container;
	JPanel panel;
	Canvas canvas;
	
	Graphics2D g;
	BufferStrategy bs;
	
	//Drawing vars
	long frameTime = 1000000 / 30; //30 frames per second
	Stack<AffineTransform> mat = new Stack<AffineTransform>();
	Color fill = new Color( 255, 255, 255, 0 );
	Color stroke = new Color( 0, 0, 0 );
	//End Draw vars
	
	public Graphics2DRenderer( String title, int width, int height, RenderUpdate ru )
	{
		this.ru = ru;
		
		container = new JFrame( title );
		panel = (JPanel) container.getContentPane();
		panel.setPreferredSize( new Dimension( width, height ) );
		panel.setLayout(null);
		canvas = new Canvas();
		
		canvas.setBounds(0,0,width,height);
		panel.add( canvas );
		
		container.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		container.setLocation( 50, 50 );
		
		container.pack();
		container.setResizable(false);
		container.setVisible(true);
		
		canvas.requestFocus();
		
		canvas.createBufferStrategy( 2 );
		bs = canvas.getBufferStrategy();
	}
	
	public void start()
	{
		ru.setup();
		while( true )
		{
			long startTime = System.nanoTime();
			g = (Graphics2D) bs.getDrawGraphics();
			mat.clear();
			mat.push( g.getTransform() );
			ru.draw();
			
			g.dispose();
			bs.show();
			try { Thread.sleep( Math.max( (frameTime - (System.nanoTime() - startTime)) / 1000, 0 ) ); } catch (InterruptedException e) {}
		}
	}
	
	public void beginShape( ShapeType type )
	{
		
	}

	public void box( float width, float height, float length )
	{
		
	}

	public void ellipse( float x, float y, float width, float height )
	{
		
	}

	public void endShape()
	{	
		
	}

	public void fill( int c )
	{
		fill = new Color( c, true ); 
	}

	public void fill( float r, float g, float b )
	{
		fill( DGraphics.rgba( (int)r, (int)g, (int)b, 255 ) );
	}

	public void fill( float r, float g, float b, float a )
	{
		fill( DGraphics.rgba( (int)r, (int)g, (int)b, (int)a ) );
	}

	public void line( float x1, float y1, float x2, float y2 )
	{
				
	}

	public void line( float x1, float y1, float z1, float x2, float y2, float z2 )
	{
		
	}

	public void popMatrix()
	{
		try
		{
			g.setTransform( mat.pop() );
		}
		catch( EmptyStackException e )
		{
			System.err.println( "Stack is empty" );
		}
	}

	public void pushMatrix()
	{
		mat.push( g.getTransform() );
	}

	public void rect( float x, float y, float width, float height )
	{
		g.setColor( fill );
		g.fillRect( (int)x, (int)y, (int)width, (int)height );
		g.setColor( stroke );
		g.drawRect( (int)x, (int)y, (int)width, (int)height );
	}

	public void rotate( float angle, float vx, float vy, float vz )
	{
		g.rotate( angle );
	}

	public void scale( float x, float y )
	{
		g.scale( x, y );
	}

	public void scale( float x, float y, float z )
	{
		g.scale( x, y );
	}

	public void stroke( int c )
	{
		stroke = new Color( c, true ); 
	}

	public void stroke( float r, float g, float b )
	{
		stroke( DGraphics.rgba( (int)r, (int)g, (int)b, 255 ) );
	}

	public void stroke( float r, float g, float b, float a )
	{
		stroke( DGraphics.rgba( (int)r, (int)g, (int)b, (int)a ) );
	}
	
	public void text( String text, float x, float y )
	{	
		g.setColor( stroke );
		g.drawString( text, x, y );
	}

	public void texture( Image img )
	{	
		
	}

	public void translate( float x, float y )
	{	
		g.translate( x, y );
	}

	public void translate( float x, float y, float z )
	{	
		g.translate( x, y );
	}

	public void vertex( float x, float y )
	{	
		
	}

	public void vertex( float x, float y, float z )
	{
		
		
	}

}
