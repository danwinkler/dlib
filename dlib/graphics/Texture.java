package dlib.graphics;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

public class Texture 
{
	Image im;
	
	public Texture( Image i, int width, int height )
	{
		BufferedImage temp = new BufferedImage( width, height, BufferedImage.TYPE_INT_ARGB );
		Graphics2D g = temp.createGraphics();
		g.drawImage( i, 0, 0, width, height, null );
		g.dispose();
		im = temp;
	}
}
