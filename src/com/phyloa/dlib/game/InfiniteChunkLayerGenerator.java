package com.phyloa.dlib.game;

public interface InfiniteChunkLayerGenerator<E>
{
	public E generate( int x, int y, String layerName );
}
