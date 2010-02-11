package dlib.util;

public class DMath 
{
	public static float randomf()
	{
		return (float) Math.random();
	}
	
	public static float randomf( float min, float max )
	{
		float r = (float) Math.random();
		return r*(max-min) + min;
	}
	
	public static int max( int... c )
	{
		int max = Integer.MIN_VALUE;
		for( int i = 0; i < c.length; i++ )
		{
			max = max > c[i] ? max : c[i];
		}
		return max;
	}
}
