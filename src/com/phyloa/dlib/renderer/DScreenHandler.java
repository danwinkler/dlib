package com.phyloa.dlib.renderer;

import java.util.HashMap;

public class DScreenHandler<E, F>
{
	HashMap<String, DScreen<E, F>> screens = new HashMap<String, DScreen<E, F>>();
	
	DScreen<E, F> d = null;
	
	public void register( String s, DScreen<E, F> d )
	{
		screens.put( s, d );
	}
	
	public void activate( String s, E e )
	{
		if( d != null )
		{
			d.onExit();
		}
		d = screens.get( s );
		d.onActivate( e, this );
	}
	
	public DScreen<E, F> get( String s )
	{
		return screens.get( s );
	}
	
	public void update( E e, int delta )
	{
		if( d != null )
			d.update( e, delta );
	}
	
	public void render( E e, F f )
	{
		if( d != null )
			d.render( e, f );
	}
}
