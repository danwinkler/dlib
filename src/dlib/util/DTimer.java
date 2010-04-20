package dlib.util;

public class DTimer 
{
	public static long nanoSeconds = 1000000000;
	long lastNanos;
	long timeToWait = nanoSeconds/30;
	long nanoChange;
	
	public DTimer( int frameRate )
	{
		timeToWait = nanoSeconds/frameRate;
		lastNanos = System.nanoTime();
	}
	
	public void pause()
	{
		long nanos = System.nanoTime();
		nanoChange = nanos - lastNanos;
		long dmillis = nanoChange/1000000;
		long diff = nanoChange - (dmillis*1000000);
		if( nanoChange < timeToWait )
		{
			try {
				Thread.sleep( dmillis, (int)diff );
			} catch (InterruptedException e) {}
		}
		lastNanos = nanos;
	}
	
	public void update()
	{
		long nanos = System.nanoTime();
		nanoChange = nanos - lastNanos;
		lastNanos = nanos;
	}
	
	public long getChange()
	{
		return nanoChange;
	}
}
