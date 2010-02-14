package dlib.learning;

import java.util.ArrayList;

public class GARunner<E extends GAUnit>
{
	ArrayList<E> units = new ArrayList<E>();
	public E winner;
	int batchSize = 20;
	
	public GARunner( E e )
	{
		winner = e;
		breed();
	}
	
	public void runAll()
	{
		for( int i = 0; i < units.size(); i++ )
		{
			units.get(i).run();
		}
	}
	
	public void findWinner()
	{
		winner = units.get(0);
		for( int i = 1; i < units.size(); i++ )
		{
			if( units.get(i).getScore() > winner.getScore() )
				winner = units.get(i);
		}
	}
	
	public void breed()
	{
		units.clear();
		for( int i = 0; i < batchSize; i++ )
		{
			units.add( (E)winner.mutate() );
		}
	}
	
	public void setBatchSize( int size )
	{
		this.batchSize = size;
	}
}
