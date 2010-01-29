package dlib;

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
}
