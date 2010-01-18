package dlib.util;

public class DGraphics
{
	public static int rgb( int red, int green, int blue ) 
	{
		return (255 & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);
	}
	
	public static int rgba( int red, int green, int blue, int a ) 
	{
		return (a & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);
	}
}
