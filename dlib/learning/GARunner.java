package dlib.learning;

import java.util.ArrayList;

/**
 * GARunner runs a genetic algorithm over a class implementing the GAUnit interface.
 * 
 * @author Daniel Winkler
 *
 * @param <E> type to run the GA over
 */
public class GARunner<E extends GAUnit>
{
	public static final int DEFAULT_BATCH_SIZE = 20;
	
	ArrayList<E> units = new ArrayList<E>();
	public E winner;
	int batchSize = DEFAULT_BATCH_SIZE;
	
	/**
	 * Takes base object to use for breeding the first batch.
	 * Makes a call to breed().
	 * @param e the object used for breeding
	 */
	public GARunner( E e )
	{
		winner = e;
		breed();
	}
	
	/**
	 * Calls run() on each object in the breeding pool. 
	 */
	public void runAll()
	{
		for( int i = 0; i < units.size(); i++ )
		{
			units.get(i).run();
		}
	}
	
	/** 
	 * Calls getScore() on each object in the breeding pool to determine the winner 
	 * for the next round of breeding();
	 */
	public void findWinner()
	{
		winner = units.get(0);
		for( int i = 1; i < units.size(); i++ )
		{
			if( units.get(i).getScore() > winner.getScore() )
				winner = units.get(i);
		}
	}
	
	/**
	 * Populates the new breeding pool by calling mutate() on the winner.
	 */
	public void breed()
	{
		units.clear();
		for( int i = 0; i < batchSize; i++ )
		{
			units.add( (E)winner.mutate() );
		}
	}
	
	/**
	 * Sets the batch size. Calls breed();
	 * @param size the size of the new breeding pool
	 */
	public void setBatchSize( int size )
	{
		this.batchSize = size;
		breed();
	}
	
	/**
	 * Runs a series of rounds of breeding. Calls runAll(), findWinner(), then breed() t times.
	 * @param t the number of times to iterate the breeding cycle
	 * @return the winner after all the rounds.
	 */
	public E runRounds( int t )
	{
		for( int i = 0; i < t; i++ )
		{
			runAll();
			findWinner();
			breed();
		}
		return winner;
	}
}
