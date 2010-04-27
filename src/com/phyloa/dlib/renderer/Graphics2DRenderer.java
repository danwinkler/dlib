package com.phyloa.dlib.renderer;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferStrategy;
import java.util.EmptyStackException;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public abstract class Graphics2DRenderer implements Renderer 
{
	JFrame container;
	JPanel panel;
	Canvas canvas;

	public Graphics2D g;
	BufferStrategy bs;

	public KeyHandler k;

	//Drawing vars
	long frameTime = 1000000000 / 30; //30 frames per second
	Stack<AffineTransform> mat = new Stack<AffineTransform>();
	//End Draw vars

	public Graphics2DRenderer()
	{
		container = new JFrame( "Graphics2DRenderer Window" );
		panel = (JPanel) container.getContentPane();
		panel.setPreferredSize( new Dimension( 50, 50 ) );
		panel.setLayout(null);
		canvas = new Canvas();
	
		canvas.setBounds(0,0,50,50);
		panel.add( canvas );
	
		container.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
	
		container.setLocation( 50, 50 );
	
		container.pack();
		container.setResizable( true );
		container.setVisible( true );
	
		canvas.requestFocus();
	
		canvas.createBufferStrategy( 2 );
		bs = canvas.getBufferStrategy();
	
		k = new KeyHandler( canvas );
	}

	public void size( int x, int y )
	{
		canvas.setBounds( 0, 0, x, y );
		canvas.setSize( x, y );
		panel.setPreferredSize( new Dimension( x, y ) );
		container.setSize( x, y );
		container.pack();
	}

	public void begin()
	{
		initialize();
		while( true )
		{
			long startTime = System.nanoTime();
			g = (Graphics2D) bs.getDrawGraphics();
			mat.clear();
			mat.push( g.getTransform() );
			update();
		
			g.dispose();
			bs.show();
			try { Thread.sleep( Math.max( (frameTime - (System.nanoTime() - startTime)) / 1000000, 0 ) ); } catch (InterruptedException e) {}
		}
	}

	public void beginShape( ShapeType type )
	{

	}

	public void box( float width, float height, float length )
	{

	}

	public void fillOval( float x, float y, float width, float height )
	{
		g.fillOval( (int)x, (int)y, (int)width, (int)height );
	}
	
	public void drawOval( float x, float y, float width, float height )
	{
		g.drawOval( (int)x, (int)y, (int)width, (int)height );
	}

	public void endShape()
	{

	}

	public void color( int c )
	{
		g.setColor( new Color( c ) );
	}

	public void color( float r, float g, float b )
	{
		this.g.setColor( new Color( (int)r, (int)g, (int)b ) );
	}

	public void color( float r, float g, float b, float a )
	{
		this.g.setColor( new Color( (int)r, (int)g, (int)b, (int)a ) );
	}

	public void line( float x1, float y1, float x2, float y2 )
	{
		g.drawLine( (int)x1, (int)y1, (int)x2, (int)y2 );
	}

	public void line( float x1, float y1, float z1, float x2, float y2, float z2 )
	{
		g.drawLine( (int)x1, (int)y1, (int)x2, (int)y2 );
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

	public void drawRect( float x, float y, float width, float height )
	{
		g.drawRect( (int)x, (int)y, (int)width, (int)height );
	}
	
	public void fillRect( float x, float y, float width, float height )
	{
		g.fillRect( (int)x, (int)y, (int)width, (int)height );
	}

	public void rotate( float angle, float vx, float vy, float vz )
	{
		g.rotate( angle );
	}
	
	public void scale( float s )
	{
		g.scale( s, s );
	}

	public void scale( float x, float y )
	{
		g.scale( x, y );
	}

	public void scale( float x, float y, float z )
	{
		g.scale( x, y );
	}

	public void text( String text, float x, float y )
	{
		g.drawString( text, x, y );
	}

	public void drawImage( Image im, float x, float y )
	{
		g.drawImage( im, (int)x, (int)y, null );
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

	public void rotateX( float angle ){}
	public void rotateY( float angle ){}
	public void rotateZ( float angle ){}

	public void rotate( float angle )
	{
		g.rotate( angle );
	}

	public void frameRate( float r )
	{
		frameTime = (long) (1000000000 / r);
	}

	public abstract void initialize();

	public abstract void update();

	public void addKeyListener( KeyListener listener )
	{
		canvas.addKeyListener( listener );
	}

	public int getWidth()
	{
		return canvas.getWidth();
	}

	public int getHeight()
	{
		return canvas.getHeight();
	}

	public void textureCoords( float u, float v ) 
	{
		
	}

}