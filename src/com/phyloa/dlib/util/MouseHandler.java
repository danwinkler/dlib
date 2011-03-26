package com.phyloa.dlib.util;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener
{
	static HashMap<Component, MouseHandler> mouseHandlers = new HashMap<Component, MouseHandler>();
	
	public int x;
	public int y;
	public boolean clicked = false;
	public boolean rightClicked = false;
	public boolean inside = true;
	
	private MouseHandler( Component c )
	{
		c.addMouseListener( this );
		c.addMouseMotionListener( this );
		c.addMouseWheelListener( this );
	}
	
	public static MouseHandler get( Component c )
	{
		MouseHandler m = mouseHandlers.get( c );
		if( m == null )
		{
			m = new MouseHandler( c );
			mouseHandlers.put( c, m );
		}
		return m;
	}

	public void mouseClicked( MouseEvent e )
	{
		
	}

	public void mouseEntered( MouseEvent e )
	{
		inside = true;
	}

	public void mouseExited( MouseEvent e )
	{
		inside = false;
	}

	public void mousePressed( MouseEvent e )
	{
		if( e.getButton() == MouseEvent.BUTTON1 )
		{
			clicked = true;
		}
		else if( e.getButton() == MouseEvent.BUTTON3 )
		{
			rightClicked = true;
		}
	}

	public void mouseReleased( MouseEvent e )
	{
		if( e.getButton() == MouseEvent.BUTTON1 )
		{
			clicked = false;
		}
		else if( e.getButton() == MouseEvent.BUTTON3 )
		{
			rightClicked = false;
		}
	}

	public void mouseDragged( MouseEvent e )
	{
		x = e.getX();
		y = e.getY();
	}

	public void mouseMoved( MouseEvent e )
	{
		x = e.getX();
		y = e.getY();
	}

	public void mouseWheelMoved( MouseWheelEvent e )
	{
	
	}
}
