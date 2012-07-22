package com.phyloa.dlib.dui;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.vecmath.Vector2f;

import com.phyloa.dlib.renderer.Renderer;

public class DTextBox extends DUIElement implements KeyListener
{
	Color bgColor = new Color( 128, 128, 255 );
	Color borderColor = new Color( 32, 32, 128 );
	
	String text = "";
	
	boolean hasFocus = false;
	
	DUI ui;
	
	int cursorBlink = 0;
	
	int cursorLocation = 0;
	
	int blinkRate = 30;
	
	public DTextBox( DUI ui, int x, int y, int width, int height )
	{
		super( x, y, width, height );
		this.ui = ui;
		ui.c.addKeyListener( this );
	}
	
	public void render( Renderer r )
	{
		r.pushMatrix();
			r.translate( x, y );
			r.color( bgColor.getRGB() );
			r.fillRect( 0, 0, width-1, height-1 );
			r.color( borderColor.getRGB() );
			r.drawRect( 0, 0, width-1, height-1 );
			if( text != null )
			{
				Vector2f fontSize = r.getStringSize( text );
				float strX = (width / 2) - (float)(fontSize.x / 2);
				float strY = (height / 2) - (float)(fontSize.y / 2);
				r.text( text, 3, strY );
			}
		r.popMatrix();
	}

	public void update( DUI ui )
	{
		if( isInside( ui.m.x, ui.m.y ) )
		{
			if( !hasFocus )
			{
				ui.setFocus( this );
				hasFocus = true;
			}
		}
	}

	public void keyPressed( KeyEvent e )
	{
		if( ui.focus == this )
		{
			int keyCode = e.getKeyCode();
			if( keyCode == KeyEvent.VK_BACK_SPACE )
			{
				if( text != null )
				{
					if( text.length() > 0 )
					{
						text = text.substring( 0, text.length()-1 );
					}
				}
			}
			else if( keyCode == KeyEvent.VK_SHIFT || keyCode == KeyEvent.VK_CONTROL || keyCode == KeyEvent.VK_ALT )
			{
				
			}
			else if( !e.isActionKey() )
			{
				text += e.getKeyChar();
			}
		}
	}

	public void keyReleased( KeyEvent e )
	{
		
	}

	public void keyTyped( KeyEvent e )
	{
		
	}

	public Color getBgColor()
	{
		return bgColor;
	}

	public Color getBorderColor()
	{
		return borderColor;
	}

	public String getText()
	{
		return text;
	}

	public void setBgColor( Color bgColor )
	{
		this.bgColor = bgColor;
	}

	public void setBorderColor( Color borderColor )
	{
		this.borderColor = borderColor;
	}

	public void setText( String text )
	{
		this.text = text;
	}

	@Override
	public void mouseClicked( int x, int y )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered( int x, int y )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited( int x, int y )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed( int x, int y )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased( int x, int y )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved( int x, int y )
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged( int x, int y )
	{
		// TODO Auto-generated method stub
		
	}
}
