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
	
	public static Image resize( Image im, int width, int height )
	{
		BufferedImage temp = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
		Graphics2D g = temp.createGraphics();
		g.drawImage( im, 0, 0, width, height, null );
		g.dispose();
		return temp;
	}
}
