package com.phyloa.dlib.dui;

import java.awt.Color;
import java.awt.Font;

import javax.vecmath.Vector2f;

import com.phyloa.dlib.renderer.Renderer;

public class DButton extends DUIElement
{
	public static final int RELEASED = 0;
	public static final int HOVER = 1;
	public static final int PRESSED = 2;
	int state = 0; //0 = released, 1 = hover, 2 = pressed
	
	String text;
	
	Color borderColor = new Color( 32, 32, 128 );
	Color releaseColor = new Color( 128, 128, 255 );
	Color hoverColor = new Color( 180, 180, 255 );
	Color pressedColor = new Color( 64, 64, 255 );
	Color textColor = new Color( 0, 0, 0 );
	
	public DButton( String text, int x, int y, int width, int height )
	{
		super( x, y, width, height );
		this.text = text;
		this.name = text;
	}

	public void render( Renderer r ) 
	{
		r.pushMatrix();
		
		Vector2f fontSize = r.getStringSize( text );
		float strX = (width / 2) - (float)(fontSize.x / 2);
		float strY = (height / 2) - (float)(fontSize.y / 2);
		r.translate( x, y );
		int red = 0, blue = 0, green = 0, alpha = 0;
		switch( state )
		{
		case RELEASED:
			red = releaseColor.getRed();
			green = releaseColor.getGreen();
			blue = releaseColor.getBlue();
			alpha = releaseColor.getAlpha();
			break;
		case HOVER:
			red = hoverColor.getRed();
			green = hoverColor.getGreen();
			blue = hoverColor.getBlue();
			alpha = hoverColor.getAlpha();
			break;
		case PRESSED:
			red = pressedColor.getRed();
			green = pressedColor.getGreen();
			blue = pressedColor.getBlue();
			alpha = pressedColor.getAlpha();
			break;
		}
		r.color( red, green, blue, alpha );
		r.fillRect( 0, 0, width-1, height-1 );
		r.color( borderColor.getRed(), borderColor.getGreen(), borderColor.getBlue(), borderColor.getAlpha() );
		r.drawRect( 0, 0, width-1, height-1 );
		r.text( text, strX, strY );
		
		r.popMatrix();
	}
	
	public void update( DUI ui ) 
	{
		if( isInside( ui.m.x, ui.m.y ) )
		{
			if( ui.m.clicked )
			{
				if( state != PRESSED )
				{
					ui.event( new DUIEvent( this ) );
					ui.setFocus( this );
				}
				state = PRESSED;
				
			}
			else
			{
				state = HOVER;
			}
		}
		else
		{
			state = RELEASED;
		}
	}

	public void setText( String text )
	{
		this.text = text;
	}

	public void setBorderColor( Color borderColor )
	{
		this.borderColor = borderColor;
	}

	public void setReleaseColor( Color releaseColor )
	{
		this.releaseColor = releaseColor;
	}

	public void setHoverColor( Color hoverColor )
	{
		this.hoverColor = hoverColor;
	}

	public void setPressedColor( Color pressedColor )
	{
		this.pressedColor = pressedColor;
	}

	public void setTextColor( Color textColor )
	{
		this.textColor = textColor;
	}

	public int getState()
	{
		return state;
	}

	public String getText()
	{
		return text;
	}

	public Color getBorderColor()
	{
		return borderColor;
	}

	public Color getReleaseColor()
	{
		return releaseColor;
	}

	public Color getHoverColor()
	{
		return hoverColor;
	}

	public Color getPressedColor()
	{
		return pressedColor;
	}

	public Color getTextColor()
	{
		return textColor;
	}
}
