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
		synchronized( d )
		{
			d.dsh = this;
			d.gc = e;
			d.onActivate( e, this );
		}
	}
	
	public DScreen<E, F> get( String s )
	{
		return screens.get( s );
	}
	
	public void update( E e, int delta )
	{
		synchronized( d )
		{
			if( d != null )
				d.update( e, delta );
		}
	}
	
	public void render( E e, F f )
	{
		synchronized( d )
		{
			if( d != null )
				d.render( e, f );
		}
	}

	public void message( String string, Object o )
	{
		get( string ).message( o );
	}
}
