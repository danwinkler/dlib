package dlib.game;

import dlib.graphics.window.ImageWindow;

public class DGame 
{
	static ImageWindow window;
	static int pixelSize = 1;
	
	static int width;
	static int height;
	
	static long frameTime;
	
	public static void start( int width, int height, Class<? extends GameState> c )
	{
		try {
			window = new ImageWindow();
			window.size( width, height );
			DGame.width = width;
			DGame.height = height;
			GameState g = c.newInstance();
			g.start();
		} catch (InstantiationException e) {
			System.err.println( "Not a valid GameState." );
		} catch (IllegalAccessException e) {
			System.err.println( "Not a valid GameState." );
		}
	}
	
	public static void setPixelSize( int pixelSize )
	{
		DGame.pixelSize = pixelSize;
	}
	
	public static void frameRate( float r )
	{
		frameTime = (long) (1000000000 / r);
	}
}
