package com.phyloa.dlib.dui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.vecmath.Vector2f;

import com.phyloa.dlib.renderer.Renderer2D;

public class DText extends DUIElement
{
	String text;
	Font font;
	Color color = Color.black;
	
	public DText( String text, int x, int y )
	{
		super( x, y, 0, 0 );
		this.text = text;
	}

	public void render( Renderer2D r )
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
	public void mousePressed( DMouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased( DMouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved( DMouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged( DMouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}
}
