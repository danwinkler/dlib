package dlib.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
	
	public static int getRed( int c )
	{
		return (c >> 16) & 0xff;
	}
	
	public static int getGreen( int c )
	{
		return (c >> 8) & 0xff;
	}
	
	public static int getBlue( int c )
	{
		return c & 0xff;
	}
	
	public static Image resize( Image im, int width, int height )
	{
		BufferedImage temp = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
		Graphics2D g = temp.createGraphics();
		g.drawImage( im, 0, 0, width, height, null );
		g.dispose();
		return temp;
	}
	
	public static int brighten( int c )
	{
		//TODO: make real
		int r = getRed( c );
		int g = getGreen( c );
		int b = getBlue( c );
		r *= 1.2f;
		g *= 1.2f;
		b *= 1.2f;
		r = r > 255 ? 255 : r;
		g = g > 255 ? 255 : g;
		b = b > 255 ? 255 : b;
		return rgb( r, g, b );
		
	}
	
	public static int darken( int c )
	{
		//TODO: make real
		int r = getRed( c );
		int g = getGreen( c );
		int b = getBlue( c );
		r *= .8f;
		g *= .8f;
		b *= .8f;
		r = r > 255 ? 255 : r;
		g = g > 255 ? 255 : g;
		b = b > 255 ? 255 : b;
		return rgb( r, g, b );
		
	}
}
