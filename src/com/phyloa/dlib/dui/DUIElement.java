package com.phyloa.dlib.dui;

import com.phyloa.dlib.renderer.Renderer;

public abstract class DUIElement
{
	int x, y, width, height;
	String name;
	
	boolean visible = true;
	
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
}
