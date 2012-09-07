package com.phyloa.dlib.renderer;

import java.util.HashMap;

public class DScreenHandler<E>
{
	HashMap<String, DScreen<E>> screens = new HashMap<String, DScreen<E>>();
	
	DScreen<E> d = null;
	
	public void register( String s, DScreen<E> d )
	{
		screens.put( s, d );
		if( this.d == null )
		{
			this.d = d;
		}
	}
	
	public void activate( String s )
	{
		d = screens.get( s );
	}
	
	public DScreen<E> get( String s )
	{
		return screens.get( s );
	}
	
	public void update( E e )
	{
		if( d != null )
			d.update( e );
	}
}
