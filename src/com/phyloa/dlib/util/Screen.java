package com.phyloa.dlib.util;

public interface Screen<E>
{
	
	public void getFocus();
	/**
	 * 
	 * @param r The graphics Context.
	 */
	public void render( E r );
	
	/**
	 * 
	 * @param delta Time since last frame in seconds
	 * @param r 
	 */
	public void update( float delta, E r );
}
