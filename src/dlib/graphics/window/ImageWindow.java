package dlib.graphics.window;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageWindow 
{
	JFrame container;
	JPanel panel;
	Canvas canvas;
	
	Graphics2D g;
	BufferStrategy bs;
	
	long frameTime = 1000000000 / 30; //30 frames per second
	
	Image im;
	
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
	
	public void begin()
	{
		new Thread( new ImageWindowThread() ).start();
	}
	
	public void setFrameRate( int frameRate )
	{
		frameTime = (long) (1000000000 / frameRate);
	}
	
	public void setImage( Image im )
	{
		this.im = im;
	}
	
	public class ImageWindowThread implements Runnable
	{
		public void run() 
		{
			while( true )
			{
				long startTime = System.nanoTime();
				g = (Graphics2D) bs.getDrawGraphics();
				if( im != null )
					g.drawImage( im, 0, 0, null );
				
				g.dispose();
				bs.show();
				try { Thread.sleep( Math.max( (frameTime - (System.nanoTime() - startTime)) / 1000000, 0 ) ); } catch (InterruptedException e) {}
			}
		}
	}
}
