package dlib.util;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class DGraphics
{
	/**
	 * Combines r, g, b values of a color into a single 24-bit integer
	 * @param red the red component of the color
	 * @param green the green component of the color
	 * @param blue the blue component of the color
	 * @return a int containing the three values
	 */
	public static int rgb( int red, int green, int blue ) 
	{
		return (255 & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);
	}
	
	/**
	 * Combines r, g, b, a values of a color into a single -bit integer
	 * @param red the red component of the color
	 * @param green the green component of the color
	 * @param blue the blue component of the color
	 * @param a the alpha (transparency) component of the color
	 * @return a int containing the three values
	 */
	public static int rgba( int red, int green, int blue, int a ) 
	{
		return (a & 0xff) << 24 | (red & 0xff) << 16 | (green & 0xff) << 8 | (blue & 0xff);
	}
	
	/**
	 * Extracts the red component from an int
	 * @param c the integer to extract the color from
	 * @return an int containing the red value from 0-255
	 */
	public static int getRed( int c )
	{
		return (c >> 16) & 0xff;
	}
	
	/**
	 * Extracts the green component from an int
	 * @param c the integer to extract the color from
	 * @return an int containing the green value from 0-255
	 */
	public static int getGreen( int c )
	{
		return (c >> 8) & 0xff;
	}
	
	/**
	 * Extracts the blue component from an int
	 * @param c the integer to extract the color from
	 * @return an int containing the blue value from 0-255
	 */
	public static int getBlue( int c )
	{
		return c & 0xff;
	}
	
	/**
	 * Resizes the image by creating a new BufferedImage and rendering the image into that one.
	 * @param im the source image
	 * @param width the width of the new Image
	 * @param height the height of the new Image
	 * @return the scaled Image
	 */
	public static BufferedImage resize( Image im, int width, int height )
	{
		BufferedImage temp = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
		Graphics2D g = temp.createGraphics();
		g.drawImage( im, 0, 0, width, height, null );
		g.dispose();
		return temp;
	}
	
	/**
	 * Multiplies each value in the color stored in an int by 1.2.
	 * @param c the int to eactract the colors from
	 * @return an int containing a brightened version of each color
	 */
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
		return rgb( r, g, b );
		
	}
	
	public static BufferedImage createBufferedImage( int x, int y )
	{
		return new BufferedImage( x, y, BufferedImage.TYPE_INT_ARGB );
	}
	
	public static BufferedImage[] cut( BufferedImage im, int width, int height )
	{
		int imageWidth = im.getWidth();
		int imageHeight = im.getHeight();
		int mapWidth = imageWidth/width;
		int mapHeight = imageHeight/height;
		
		BufferedImage[] map = new BufferedImage[mapWidth*mapHeight];
		for( int y = 0; y < mapHeight; y++ )
		{
			for( int x = 0; x < mapWidth; x++ )
			{
				BufferedImage temp = createBufferedImage( width, height );
				Graphics g = temp.createGraphics();
				g.drawImage( im, 0, 0, width, height, x*width, x*height, x*width+width, x*height+height, null );
				g.dispose();
				map[y*mapHeight + x] = temp;
			}
		}
		return map;
	}
}
