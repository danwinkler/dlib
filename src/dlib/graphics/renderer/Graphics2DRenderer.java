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

public abstract class Graphics2DRenderer implements Renderer
{	
	JFrame container;
	JPanel panel;
	Canvas canvas;
	
	Graphics2D g;
	BufferStrategy bs;
	
	//Drawing vars
	long frameTime = 1000000000 / 30; //30 frames per second
	Stack<AffineTransform> mat = new Stack<AffineTransform>();
	Color fill = new Color( 255, 255, 255, 0 );
	Color stroke = new Color( 0, 0, 0 );
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
		container.setResizable(false);
		container.setVisible(true);
		
		canvas.requestFocus();
		
		canvas.createBufferStrategy( 2 );
		bs = canvas.getBufferStrategy();
	}
	
	public void size( int x, int y )
	{
		canvas.setBounds( 0, 0, x, y );
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

	public void ellipse( float x, float y, float width, float height )
	{
		pushMatrix();
		translate( -width/2, -height/2 );
		g.setColor( fill );
		g.fillOval( (int)x, (int)y, (int)width, (int)height );
		g.setColor( stroke );
		g.drawOval( (int)x, (int)y, (int)width, (int)height );
		popMatrix();
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

}
