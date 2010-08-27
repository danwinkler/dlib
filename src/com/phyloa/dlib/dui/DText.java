package com.phyloa.dlib.dui;

import java.awt.Color;
import java.awt.Font;

import javax.vecmath.Vector2f;

import com.phyloa.dlib.renderer.Renderer;

public class DText extends DUIElement
{
	String text;
	Font font;
	Color color = Color.black;
	
	public DText( String text, int x, int y )
	{
		this.x = x;
		this.y = y;
		this.text = text;
	}

	public void render( Renderer r )
	{
		if( font != null )
		{
			
		}
		r.color( color.getRGB() );
		Vector2f size = r.getStringSize( text );
		r.text( text, x, y + size.y );
	}

	public void update( DUI ui )
	{
		
	}

	public String getText()
	{
		return text;
	}

	public Font getFont()
	{
		return font;
	}

	public Color getColor()
	{
		return color;
	}

	public void setText( String text )
	{
		this.text = text;
	}

	public void setFont( Font font )
	{
		this.font = font;
	}

	public void setColor( Color color )
	{
		this.color = color;
	}
}
