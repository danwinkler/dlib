package com.phyloa.dlib.dui;

import java.util.ArrayList;

import com.phyloa.dlib.renderer.Renderer;

public abstract class DUIElement implements DKeyListener, DMouseListener
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
	
	public void handleChildrenMouseMoved( DMouseEvent e )
	{
		int xx = e.x - this.x;
		int yy = e.y - this.y;
		for( int i = 0; i < children.size(); i++ )
		{
			DUIElement el = children.get( i );
			boolean inside = el.isInside( xx, yy );
			if( inside || el.isInside )
			{
				el.isInside = inside;
				el.mouseMoved( e );
				el.handleChildrenMouseMoved( e );
			}
		}
	}
	
	public void handleChildrenMousePressed( DMouseEvent e )
	{
		int xx = e.x - this.x;
		int yy = e.y - this.y;
		for( int i = 0; i < children.size(); i++ )
		{
			DUIElement el = children.get( i );
			if( el.isInside( xx, yy ) )
			{
				el.mousePressed( e );
				el.handleChildrenMousePressed( e );
			}
		}
	}
	
	public void handleChildrenMouseReleased( DMouseEvent e )
	{
		int xx = e.x - this.x;
		int yy = e.y - this.y;
		for( int i = 0; i < children.size(); i++ )
		{
			DUIElement el = children.get( i );
			if( el.isInside( xx, yy ) )
			{
				el.mouseReleased( e );
				el.handleChildrenMouseReleased( e );
			}
		}
	}

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
