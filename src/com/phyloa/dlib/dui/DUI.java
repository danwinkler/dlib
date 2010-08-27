package com.phyloa.dlib.dui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.ArrayList;

import com.phyloa.dlib.renderer.KeyHandler;
import com.phyloa.dlib.renderer.MouseHandler;
import com.phyloa.dlib.renderer.Renderer;

public class DUI implements KeyListener, MouseWheelListener, MouseMotionListener, MouseListener
{
	ArrayList<DUIElement> elements = new ArrayList<DUIElement>();
	KeyHandler k;
	MouseHandler m;
	
	ArrayList<DUIListener> listeners = new ArrayList<DUIListener>();
	
	public DUI( Component c )
	{
		c.addMouseListener( this );
		c.addMouseMotionListener( this );
		c.addMouseWheelListener( this );
		c.addKeyListener( this );
		m = MouseHandler.get( c );
	}
	
	public void update()
	{
		for( int i = 0; i < elements.size(); i++ )
		{
			elements.get( i ).update( this );
		}
	}
	
	public void render( Renderer r )
	{
		for( int i = 0; i < elements.size(); i++ )
		{
			elements.get( i ).render( r );
		}
	}
	
	public void addDUIListener( DUIListener l )
	{
		listeners.add( l );
	}
	
	public void add( DUIElement e )
	{
		elements.add( e );
	}
	
	public void event( DUIEvent e )
	{
		for( DUIListener l : listeners )
		{
			l.event( e );
		}
	}

	public void keyPressed(KeyEvent e) 
	{
		
	}


	public void keyReleased( KeyEvent e ) 
	{
	
	}


	public void keyTyped( KeyEvent e )
	{	
		
	}


	public void mouseWheelMoved( MouseWheelEvent e ) 
	{
			
	}


	public void mouseDragged( MouseEvent e ) 
	{
		
	}


	public void mouseMoved( MouseEvent e ) 
	{
		
	}


	public void mouseClicked( MouseEvent e )
	{
		
	}


	public void mouseEntered( MouseEvent e ) {	
		
	}


	public void mouseExited( MouseEvent e ) {
			
	}


	public void mousePressed( MouseEvent e ) {	
		
	}


	public void mouseReleased( MouseEvent e ) {
		
	}
}
