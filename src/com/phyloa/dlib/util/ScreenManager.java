package com.phyloa.dlib.util;

import java.util.HashMap;

public class ScreenManager<E>
{
	HashMap<String, Screen<E>> screens = new HashMap<String, Screen<E>>();
	
	Screen<E> current = null;
	
	public void setScreen( String screenName )
	{
		current = screens.get( screenName );
		current.getFocus();
	}
	
	public void addScreen( String name, Screen<E> s )
	{
		screens.put( name, s );
	}
	
	public Screen<E> getCurrentScreen()
	{
		return current;
	}
	
	public void render( E context )
	{
		if( current != null )
		{
			current.render( context );
		}
	}
	
	public void update( float delta, E r )
	{
		if( current != null )
		{
			current.update( delta, r );
		}
	}
}
