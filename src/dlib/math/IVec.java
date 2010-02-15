package dlib.math;

public abstract class IVec 
{
	public int x;
	public int y;
	public int z;
	
	public abstract void add( IVec vec );
	public abstract void sub( IVec vec );
	public abstract void mul( IVec vec );
	public abstract void div( IVec vec );
	
	public abstract void div( int m );
	public abstract void mul( int m );
}
