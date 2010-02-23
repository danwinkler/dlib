package dlib.graphics.window;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;

import dlib.util.DGraphics;

public class ImageWindow 
{
	JFrame container;
	JPanel panel;
	Canvas canvas;
	
	Graphics2D g;
	BufferStrategy bs;
	
	public ImageWindow()
	{	
		container = new JFrame( "ImageWindow" );
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
	
	public void setTitle( String str )
	{
		container.setTitle( str );
	}
	
	public void draw( BufferedImage b )
	{
		g = (Graphics2D) bs.getDrawGraphics();
		if( b != null )
			g.drawImage( b, 0, 0, null );
		g.dispose();
		bs.show();
	}
}
