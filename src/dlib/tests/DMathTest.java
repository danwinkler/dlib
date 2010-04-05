package dlib.tests;

import dlib.util.DMath;

public class DMathTest 
{
	public static void main( String[] args )
	{
		for( int i = -10; i < 10; i++ )
		{
			System.out.println( i + " & " + DMath.mod( i, 5 ) );
		}
	}
}
