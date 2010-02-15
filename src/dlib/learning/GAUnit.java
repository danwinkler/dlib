package dlib.learning;

public interface GAUnit
{
	/**
	 * Returns a new object based off this, but mutated randomly.
	 * @return the new "baby" object
	 */
	public Object mutate();
	
	/**
	 * Returns how well the object scored. Higher is better.
	 * @return the score
	 */
	public float getScore();
	
	/**
	 * Optional. The code determining the score should be run in here.
	 */
	public void run();
}
