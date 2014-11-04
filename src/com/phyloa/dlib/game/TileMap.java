package com.phyloa.dlib.game;

public class TileMap<E> 
{
	int width, height;
	
	Tile[][] tiles;
	
	public TileMap( int width, int height )
	{
		this.width = width;
		this.height = height;
		tiles = new Tile[width][height];
	}
	
	public static class Tile
	{
		
	}
}
