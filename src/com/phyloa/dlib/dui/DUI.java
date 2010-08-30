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

public class DUI
{
	ArrayList<DUIElement> elements = new ArrayList<DUIElement>();
	KeyHandler k;
	MouseHandler m;
	Component c;
	
	ArrayList<DUIListener> listeners = new ArrayList<DUIListener>();
	
	DUIElement focus = null;
	
	public DUI( Component c )
	{
		this.c = c;
		m = MouseHandler.get( c );
		k = KeyHandler.get( c );
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

	public DUIElement getFocus()
	{
		return focus;
	}

	public void setFocus( DUIElement focus )
	{
		this.focus = focus;
	}
}
