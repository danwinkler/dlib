package com.phyloa.dlib.util;

public class DMath
{
	/**
	 * Returns a random float from 0 to 1. Casts Math.random() to a float.
	 * 
	 * @return the random float from 0 to 1
	 */
	public static float randomf()
	{
		return (float)Math.random();
	}
	
	/**
	 * Returns a random float from min to max
	 * 
	 * @param min
	 *            the minimum possible random number
	 * @param max
	 *            the maximum possible random number
	 * @return the random number.
	 */
	public static float randomf( float min, float max )
	{
		float r = (float)Math.random();
		return r * (max - min) + min;
	}
	
	/**
	 * Returns the maximum int of all the values passed.
	 * 
	 * @param c
	 *            the ints to find the max of
	 * @return the maximum int
	 */
	public static int max( int... c )
	{
		int max = Integer.MIN_VALUE;
		for( int i = 0; i < c.length; i++ )
		{
			max = max > c[i] ? max : c[i];
		}
		return max;
	}
	
	/**
	 * Returns the maximum of a series of Comparables. If two are the same, the
	 * one occurring first is returned.
	 * 
	 * @param c
	 *            The comparables to compare
	 * @return the maximum Comparable
	 */
	public static Comparable max( Comparable... c )
	{
		Comparable max = c[0];
		for( int i = 1; i < c.length; i++ )
		{
			if( c[i].compareTo( max ) > 0 )
				max = c[i];
		}
		return max;
	}
	
	public static int mod( int n, int m )
	{
		int x = n % m;
		if( x < 0 )
			x += m;
		return x;
	}
	
	public static float lerp( float t, float a, float b) 
	{ 
		return a + t * (b - a); 
	}
	
	public static float cosf( float a )
	{
		return (float)Math.cos( a );
	}
	
	public static float sinf( float a )
	{
		return (float)Math.sin( a );
	}
	
	public static int turnTowards( float heading, float desiredHeading )
	{
		double delta = heading - desiredHeading;
		if( delta < -180 )
			delta += 360;
		if( delta > 180 )
			delta -= 360;
		if( delta < 0 )
			return 1; //turn right
		else
			return -1; //turn left
		
	}
}