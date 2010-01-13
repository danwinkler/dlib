package dlib.math;

public abstract class FVec
{
	public float x;
	public float y;
	public float z;
	
	public abstract void add( FVec vec );
	public abstract void sub( FVec vec );
	public abstract void mul( FVec vec );
	public abstract void div( FVec vec );
	
	public abstract void div( float m );
	public abstract void mul( float m );
	
	public float mag2() { return x*x + y*y + z*z; }
	public float mag() { return (float)Math.sqrt( x*x + y*y + z*z ); }
	public void norm() { div( mag() ); };
}
