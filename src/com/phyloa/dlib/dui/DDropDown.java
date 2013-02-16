package com.phyloa.dlib.dui;

import java.util.ArrayList;

import javax.vecmath.Vector2f;

import com.phyloa.dlib.renderer.Renderer2D;

public class DDropDown extends DUIElement
{
	ArrayList<String> items = new ArrayList<String>();
	
	int selected = 0;
	
	boolean expanded = false;
	
	public DDropDown( int x, int y, int width, int height )
	{
		super( x, y, width, height );
	}
	
	public void addItems( String... items )
	{
		for( String s : items )
		{
			this.items.add( s );
		}
	}
	
	public void render( Renderer2D r )
	{
		if( items.size() == 0 )
		{
			r.color( ui.theme.backgroundColor );
			r.fillRect( x, y, width, height );
			r.color(  ui.theme.borderColor );
			r.drawRect( x, y, width, height );
			return;
		}
		
		r.pushMatrix();
		r.translate( x, y );
		
		Vector2f stringSize = r.getStringSize( items.get( selected ) );
		if( expanded )
		{
			float expandedHeight = Math.max( height, (stringSize.y+10) * items.size() + 10 );
			
			r.color( ui.theme.backgroundColor );
			r.fillRect( 0, 0, width, expandedHeight );
			r.color(  ui.theme.borderColor );
			r.drawRect( 0, 0, width, expandedHeight );
			for( int i = 0; i < items.size(); i++ )
			{
				r.text( items.get( i ), 10, (stringSize.y+10) * i + 10 );
			}
			
		}
		else
		{
			r.color( ui.theme.backgroundColor );
			r.fillRect( 0, 0, width, height );
			r.color( ui.theme.borderColor );
			r.drawRect( 0, 0, width, height );
			
			r.text( items.get( selected ), 10, height/2 - stringSize.y/2 );
			
			
			r.line( width-height, 0, width-height, height );
			float w2 = width - height/2;
			float h2 = height/2;
			r.line( w2 - 5, h2 - 5, w2 + 5, h2 - 5 );
			r.line( w2, h2 + 5, w2 + 5, h2 - 5 );
			r.line( w2, h2 + 5, w2 - 5, h2 - 5 );
			
		}
		
		r.popMatrix();
	}

	public void update( DUI ui )
	{
		
	}

	public void keyPressed( DKeyEvent dke )
	{
		
	}

	public void keyReleased( DKeyEvent dke )
	{
		
	}

	public void mouseEntered( DMouseEvent e )
	{
		
	}

	public void mouseExited( DMouseEvent e )
	{
		
	}

	public void mousePressed( DMouseEvent e )
	{
		
	}

	public void mouseReleased( DMouseEvent e )
	{
		
	}

	public void mouseMoved( DMouseEvent e )
	{
		
	}

	public void mouseDragged( DMouseEvent e )
	{
		
	}

	public void mouseWheel( DMouseEvent dme )
	{
		
	}
}
