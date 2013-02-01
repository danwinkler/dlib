package com.phyloa.dlib.dui;

import java.awt.Color;
import java.util.ArrayList;

import com.phyloa.dlib.renderer.Renderer2D;
import com.phyloa.dlib.util.DMath;

public class DLinePlot extends DUIElement
{
	ArrayList<Color> colors = new ArrayList<Color>();
	ArrayList<float[]> values = new ArrayList<float[]>();
	float maxValue = 0;
	
	public DLinePlot( int width, int height )
	{
		super( 0, 0, width, height );
	}
	
	public DLinePlot( int x, int y, int width, int height )
	{
		super( x, y, width, height );
	}

	public void render( Renderer2D g )
	{
		g.setLineWidth( 3 );
		
		g.pushMatrix();
		g.translate( x, y );
		g.color( Color.white );
		g.line( 0, 0, 0, height );
		g.line( 0, height, width, height );
		float yScale = height / maxValue;
		for( int i = 0; i < colors.size(); i++ )
		{
			g.color(  colors.get( i ) );
			float[] vals = values.get( i );
			float xScale = width / (vals.length-1);
			for( int j = 0; j < vals.length-1; j++ )
			{
				g.line( j*xScale, height - vals[j] * yScale, (j+1)*xScale, height - vals[j+1] * yScale );
			}
		}
		g.popMatrix();
	}

	public void update( DUI ui )
	{
		
	}
	
	public void addLine( float[] arr, Color c )
	{
		colors.add( c );
		values.add( arr );
		float max = DMath.maxf( arr );
		if( max > maxValue )
			maxValue = max;
	}
	
	public void addLine( int[] arr, Color c )
	{
		float[] v = new float[arr.length];
		for( int i = 0; i < v.length; i++ )
		{
			v[i] = arr[i];
		}
		addLine( v, c );
	}
	
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

	@Override
	public void mouseWheel( DMouseEvent dme )
	{
		// TODO Auto-generated method stub
		
	}
}
