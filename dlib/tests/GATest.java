package dlib.tests;

import dlib.DMath;
import dlib.learning.GARunner;
import dlib.learning.GAUnit;

public class GATest
{
	public static void main( String[] args )
	{
		GARunner<TwentyFive> runner = new GARunner<TwentyFive>( new TwentyFive() ); //UGH THATS UGLY
		
		for( int i = 0; i < 100; i++ )
		{
			runner.runAll();
			runner.findWinner();
			System.out.println( runner.winner.getScore() + ": " + runner.winner.x + ", " + runner.winner.y );
			runner.breed();
		}
	}
	
	public static class TwentyFive implements GAUnit
	{
		float x;
		float y;
		
		public TwentyFive()
		{
			x = DMath.randomf( -20, 20 );
			y = DMath.randomf( -20, 20 );
		}
		
		public TwentyFive( TwentyFive f )
		{
			if( DMath.randomf() > .8 )
			{
				x = DMath.randomf( -20, 20 );
				y = DMath.randomf( -20, 20 );
			}
			else
			{
				this.x = f.x + DMath.randomf( -.0001f, .0001f );
				this.y = f.y + DMath.randomf( -.0001f, .0001f );
			}
		}

		public float getScore()
		{
			return 100 - Math.abs( 25 - (x*y) );
		}

		public Object mutate()
		{
			return new TwentyFive( this );
		}

		public void run()
		{
			//hmmm i should have done the math in here not in getScore()
			
		}
	}
}
