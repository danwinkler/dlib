package com.phyloa.dlib.game;

import java.util.HashMap;

public class InfiniteChunkManager<E>
{
	Class<E> chunkClass;
	
	HashMap<String, Layer<E>> layers = new HashMap<String, Layer<E>>();
	
	float chunkWidth;
	float chunkHeight;
	
	public InfiniteChunkManager( Class<E> c, float chunkWidth, float chunkHeight )
	{
		chunkClass = c;
		this.chunkWidth = chunkWidth;
		this.chunkHeight = chunkHeight;
	}
	
	public void render( String layer )
	{
		
	}
	
	public void newLayer( String name, InfiniteChunkLayerGenerator<E> iclg )
	{
		layers.put( name, new Layer<E>( name, iclg, chunkWidth, chunkHeight ) );
	}
	
	public Layer<E> getLayer( String name )
	{
		return layers.get( name );
	}
	
	public static class Layer<E>
	{
		HashMap<Long, E> chunks = new HashMap<Long, E>();
		InfiniteChunkLayerGenerator<E> iclg;	
		String name;
		float chunkWidth;
		float chunkHeight;
		
		public Layer( String name, InfiniteChunkLayerGenerator<E> iclg, float chunkWidth, float chunkHeight )
		{
			this.iclg = iclg;
			this.name = name;
			this.chunkWidth = chunkWidth;
			this.chunkHeight = chunkHeight;
		}
		
		public E get( int x, int y )
		{
			long id = x + ((long)y << 32);
			E c = chunks.get( id );
			if( c == null ) 
			{
				c = iclg.generate( x, y, this.name );
				chunks.put( id, c );
			}
			return c;
		}
		
		public void put( int x, int y, E e )
		{
			long id = x + ((long)y << 32);
			chunks.put( id, e ); 
		}
		
		//Iterator
		int xmin, ymin, xmax, ymax;
		int xon, yon;
		boolean complete = true;
		
		public void resetIterator( float x, float y, float width, float height )
		{
			xmin = (int)Math.floor(x / chunkWidth);
			ymin = (int)Math.floor(y / chunkHeight);
			xmax = (int)Math.ceil((x+width) / chunkWidth);
			ymax = (int)Math.ceil((y+height) / chunkHeight);
			
			xon = xmin;
			yon = ymin;
			complete = false;
		}
		
		public boolean hasNext()
		{
			return !complete;
		}
		
		public E next()
		{
			if( complete ) return null;
			E c = get( xon, yon );
			xon++;
			if( xon > xmax )
			{
				xon = xmin;
				yon++;
				if( yon > ymax )
				{
					complete = true;
				}
			}
			return c;
		}
	}
}
