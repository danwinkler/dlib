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

import com.phyloa.dlib.renderer.Renderer;
import com.phyloa.dlib.util.KeyHandler;
import com.phyloa.dlib.util.MouseHandler;

public class DUI implements MouseListener, MouseMotionListener, KeyListener
{
	Component c;
	KeyHandler k;
	MouseHandler m;
	ArrayList<DUIListener> listeners = new ArrayList<DUIListener>();
	
	DUIElement focus = null;
	DUIElement hover = null;
	
	DUIElement rootPane = new DPane( 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE );
	
	public DUI( Component c )
	{
		this.c = c;
		c.addMouseListener( this );
		c.addMouseMotionListener( this );
		c.addKeyListener( this );
		k = KeyHandler.get( c );
		m = MouseHandler.get( c );
	}
	
	public DUI( Component c, int x, int y, int width, int height )
	{
		this( c );
		rootPane = new DPane( x, y, width, height );
	}
	
	public void update()
	{
		rootPane.update( this );
		rootPane.updateChildren( this );
	}
	
	public void render( Renderer r )
	{
		rootPane.render( r );
		rootPane.renderChildren( r );
	}
	
	public void addDUIListener( DUIListener l )
	{
		listeners.add( l );
	}
	
	public void add( DUIElement e )
	{
		rootPane.add( e );
		e.setUI( this );
	}
	
	public void event( DUIEvent e )
	{
		for( DUIListener l : listeners )
		{
			l.event( e );
		}
	}

	public DUIElement getFocus()
	{
		return focus;
	}

	public void setFocus( DUIElement focus )
	{
		this.focus = focus;
	}

	public void keyPressed( KeyEvent arg0 )
	{
		
	}

	@Override
	public void keyReleased( KeyEvent arg0 )
	{
		// TODO Auto-generated method stub
		
	}

	public void keyTyped( KeyEvent arg0 )
	{
		
	}

	public void mouseDragged( MouseEvent arg0 )
	{
		
	}

	public void mouseMoved( MouseEvent e )
	{
		rootPane.mouseMoved( e.getX(), e.getY() );
		rootPane.handleChildrenMouseMoved( e.getX(), e.getY() );
	}

	public void mouseClicked( MouseEvent arg0 )
	{
		
	}

	public void mouseEntered( MouseEvent arg0 )
	{
		
	}

	public void mouseExited( MouseEvent arg0 )
	{
		
	}

	public void mousePressed( MouseEvent e )
	{
		rootPane.mousePressed( e.getX(), e.getY() );
		rootPane.handleChildrenMousePressed( e.getX(), e.getY() );
	}

	public void mouseReleased( MouseEvent e )
	{
		rootPane.mouseReleased( e.getX(), e.getY() );
		rootPane.handleChildrenMouseReleased( e.getX(), e.getY() );
	}
}
