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
import com.phyloa.dlib.util.DKeyHandler;
import com.phyloa.dlib.util.MouseHandler;

public class DUI implements DMouseListener, DKeyListener
{
	DEventMapper dem;
	DKeyHandler k;
	MouseHandler m;
	ArrayList<DUIListener> listeners = new ArrayList<DUIListener>();
	
	DUIElement focus = null;
	DUIElement hover = null;
	
	DUIElement rootPane = new DPanel( 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE );
	
	public DUI( DEventMapper dem )
	{
		this.dem = dem;
		dem.addDKeyListener( this );
		dem.addDMouseListener( this );
		//k = DKeyHandler.get( c );
		//m = MouseHandler.get( c );
	}
	
	public DUI( DEventMapper dem, int x, int y, int width, int height )
	{
		this( dem );
		rootPane = new DPanel( x, y, width, height );
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

	public void mouseMoved( DMouseEvent e )
	{
		rootPane.mouseMoved( e );
		rootPane.handleChildrenMouseMoved( e );
	}

	public void mousePressed( DMouseEvent e )
	{
		rootPane.mousePressed( e );
		rootPane.handleChildrenMousePressed( e );
	}

	public void mouseReleased( DMouseEvent e )
	{
		rootPane.mouseReleased( e );
		rootPane.handleChildrenMouseReleased( e );
	}

	@Override
	public void keyPressed( DKeyEvent dke )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased( DKeyEvent dke )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered( DMouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited( DMouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged( DMouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}
}
