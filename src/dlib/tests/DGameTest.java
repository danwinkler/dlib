package dlib.tests;

import dlib.game.DGame;
import dlib.game.GameState;

public class DGameTest
{
	public static void main( String[] args )
	{
		DGame.start( 800, 600, GameStateTest1.class );
	}

	public static class GameStateTest1 extends GameState
	{

		public void update() 
		{
			
			
		}
		
	}
}
