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
	ArrayList<DUIElement> elements = new ArrayList<DUIElement>();
	Component c;
	KeyHandler k;
	MouseHandler m;
	ArrayList<DUIListener> listeners = new ArrayList<DUIListener>();
	
	DUIElement focus = null;
	
	public DUI( Component c )
	{
		this.c = c;
		c.addMouseListener( this );
		c.addMouseMotionListener( this );
		c.addKeyListener( this );
		k = KeyHandler.get( c );
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

	public boolean isHover()
	{
		for( int i = 0; i < elements.size(); i++ )
		{
			if( elements.get( i ).isInside( m.x, m.y ) )
			{
				return true;
			}
		}
		return false;
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
		for( int i = 0; i < elements.size(); i++ )
		{
			elements.get( i ).mouseMoved( e );
		}
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
		for( int i = 0; i < elements.size(); i++ )
		{
			elements.get( i ).mousePressed( e );
		}
	}

	public void mouseReleased( MouseEvent e )
	{
		for( int i = 0; i < elements.size(); i++ )
		{
			elements.get( i ).mouseReleased( e );
		}
	}
}
