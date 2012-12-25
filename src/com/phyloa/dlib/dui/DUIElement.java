package com.phyloa.dlib.dui;

import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import com.phyloa.dlib.renderer.Renderer;

public abstract class DUIElement implements KeyListener
{
	int x, y, width, height;
	String name;
	
	boolean visible = true;
	DUI ui;
	
	ArrayList<DUIElement> children = new ArrayList<DUIElement>();
	
	boolean isInside = false;
	
	public DUIElement( int x, int y, int width, int height )
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public abstract void render( Renderer r );
	public abstract void update( DUI ui );
	
	public String getName() 
	{
		return name;
	}
	
	public void setName( String name ) 
	{
		this.name = name;
	}
	
	public void setLocation( int x, int y )
	{
		this.x = x;
		this.y = y;
	}
	
	public void setSize( int width, int height )
	{
		this.width = width;
		this.height = height;
	}
	
	public boolean isVisible()
	{
		return visible;
	}
	
	public void setVisible( boolean visible )
	{
		this.visible = visible;
	}
	
	public boolean isInside( int mx, int my )
	{
		return mx >= x && my >= y && mx <= x + width && my <= y + height; 
	}
	
	public void setUI( DUI ui )
	{
		this.ui = ui;
	}
	
	public void handleChildrenMouseMoved( int x, int y )
	{
		int xx = x - this.x;
		int yy = y - this.y;
		for( int i = 0; i < children.size(); i++ )
		{
			DUIElement el = children.get( i );
			boolean inside = el.isInside( xx, yy );
			if( inside || el.isInside )
			{
				el.isInside = inside;
				el.mouseMoved( xx, yy );
				el.handleChildrenMouseMoved( xx, yy );
			}
		}
	}
	
	public void handleChildrenMousePressed( int x, int y )
	{
		int xx = x - this.x;
		int yy = y - this.y;
		for( int i = 0; i < children.size(); i++ )
		{
			DUIElement el = children.get( i );
			if( el.isInside( xx, yy ) )
			{
				el.mousePressed( xx, yy );
				el.handleChildrenMousePressed( xx, yy );
			}
		}
	}
	
	public void handleChildrenMouseReleased( int x, int y )
	{
		int xx = x - this.x;
		int yy = y - this.y;
		for( int i = 0; i < children.size(); i++ )
		{
			DUIElement el = children.get( i );
			if( el.isInside( xx, yy ) )
			{
				el.mouseReleased( xx, yy );
				el.handleChildrenMouseReleased( xx, yy );
			}
		}
	}

	public abstract void mouseClicked( int x, int y );

	public abstract void mouseEntered( int x, int y );
	
	public abstract void mouseExited( int x, int y );

	public abstract void mousePressed( int x, int y );

	public abstract void mouseReleased( int x, int y );
	
	public abstract void mouseMoved( int x, int y );
	
	public abstract void mouseDragged( int x, int y );

	public void add( DUIElement e )
	{
		children.add( e );
	}

	public void updateChildren( DUI dui )
	{
		for( int i = 0; i < children.size(); i++ )
		{
			children.get( i ).update( dui );
			children.get( i ).updateChildren( dui );
		}
	}
	
	public void renderChildren( Renderer r )
	{
		if( visible )
		{
			for( int i = 0; i < children.size(); i++ )
			{
				children.get( i ).render( r );
				children.get( i ).renderChildren( r );
			}
		}
	}
}
