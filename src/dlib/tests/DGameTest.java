package dlib.tests;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import dlib.game.DGame;
import dlib.game.GameObject;
import dlib.game.GameState;
import dlib.graphics.window.ImageWindow;
import dlib.util.DGraphics;
import dlib.util.DMath;

public class DGameTest
{
	public static void main( String[] args )
	{
		DGame.start( 800, 600, GameStateTest1.class );
	}

	public static class GameStateTest1 extends GameState
	{
		public GameStateTest1()
		{
			add( new Ball() );
		}
		
		public void update() 
		{
			
			
		}
	}
	
	public static class Ball extends GameObject
	{
		public static BufferedImage ballImage;
		
		static {
			ballImage = DGraphics.createBufferedImage( 20, 10 );
			Graphics2D g = ballImage.createGraphics();
			g.setColor( new Color( 0, 0, 0, 0 ) );
			g.drawRect( 0, 0, 20, 10 );
			g.setColor( Color.red );
			g.fillOval( 0, 0, 10, 10 );
			
			g.setColor( Color.blue );
			g.fillOval( 10, 0, 10, 10 );
			g.dispose();
		}
		
		public Ball()
		{
			super( ballImage, 100, 100, 10, 10 );
			
			acceleration.y = .001f;
		}
		
		public void update()
		{
			
		}
	}
}
