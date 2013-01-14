package com.phyloa.dlib.dui;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;


public class AWTComponentEventMapper implements KeyListener, MouseListener, MouseMotionListener, DEventMapper
{
	ArrayList<DKeyListener> keyListeners = new ArrayList<DKeyListener>();
	ArrayList<DMouseListener> mouseListeners = new ArrayList<DMouseListener>();
	
	public void register( Component c )
	{
		c.addMouseListener( this );
		c.addMouseMotionListener( this );
		c.addKeyListener( this );
	}
	
	public void addDKeyListener( DKeyListener l )
	{
		keyListeners.add( l );
	}
	
	public void addDMouseListener( DMouseListener l )
	{
		mouseListeners.add( l );
	}
	
	private static DKeyEvent createFromKeyEvent( KeyEvent e )
	{
		DKeyEvent dke = new DKeyEvent();
		dke.isActionKey = e.isActionKey();
		dke.keyCode = e.getKeyCode();
		dke.keyChar = e.getKeyChar();
		return dke;
	}
	
	private static DMouseEvent createFromMouseEvent( MouseEvent e )
	{
		DMouseEvent dme = new DMouseEvent();
		dme.x = e.getX();
		dme.y = e.getY();
		dme.button = e.getButton();
		return dme;
	}
	
	@Override
	public void keyPressed( KeyEvent e )
	{
		DKeyEvent dke = createFromKeyEvent( e );
		for( DKeyListener l : keyListeners )
		{
			l.keyPressed( dke );
		}
	}

	@Override
	public void keyReleased( KeyEvent e )
	{
		DKeyEvent dke = createFromKeyEvent( e );
		for( DKeyListener l : keyListeners )
		{
			l.keyReleased( dke );
		}
	}

	@Override
	public void keyTyped( KeyEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged( MouseEvent e )
	{
		DMouseEvent dme = createFromMouseEvent( e );
		for( DMouseListener l : mouseListeners )
		{
			l.mouseDragged( dme );
		}
	}

	@Override
	public void mouseMoved( MouseEvent e )
	{
		DMouseEvent dme = createFromMouseEvent( e );
		for( DMouseListener l : mouseListeners )
		{
			l.mouseMoved( dme );
		}
	}

	@Override
	public void mouseClicked( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered( MouseEvent e )
	{
		DMouseEvent dme = createFromMouseEvent( e );
		for( DMouseListener l : mouseListeners )
		{
			l.mouseEntered( dme );
		}
	}

	@Override
	public void mouseExited( MouseEvent e )
	{
		DMouseEvent dme = createFromMouseEvent( e );
		for( DMouseListener l : mouseListeners )
		{
			l.mouseExited( dme );
		}
	}

	@Override
	public void mousePressed( MouseEvent e )
	{
		DMouseEvent dme = createFromMouseEvent( e );
		for( DMouseListener l : mouseListeners )
		{
			l.mousePressed( dme );
		}
	}

	@Override
	public void mouseReleased( MouseEvent e )
	{
		DMouseEvent dme = createFromMouseEvent( e );
		for( DMouseListener l : mouseListeners )
		{
			l.mouseReleased( dme );
		}
	}
	
}