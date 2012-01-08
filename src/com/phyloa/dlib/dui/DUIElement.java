package com.phyloa.dlib.dui;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import com.phyloa.dlib.renderer.Renderer;

public abstract class DUIElement implements MouseListener, MouseMotionListener, KeyListener
{
	int x, y, width, height;
	String name;
	
	boolean visible = true;
	DUI ui;
	
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
}
