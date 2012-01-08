package com.phyloa.dlib.dui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.vecmath.Vector2f;

import com.phyloa.dlib.renderer.Renderer;

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

	@Override
	public void mouseClicked( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved( MouseEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed( KeyEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased( KeyEvent e )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped( KeyEvent e )
	{
		// TODO Auto-generated method stub
		
	}
}
