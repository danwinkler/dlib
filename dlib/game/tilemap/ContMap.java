package dlib.game.tilemap;

import dlib.graphics.Renderer;

public class ContMap
{
	Tilemap[][] area = new Tilemap[3][3];
	MapServer ms;
	
	public ContMap( MapServer ms )
	{
		this.ms = ms;
	}
	
	public void render( int x, int y, int width, int height, Renderer r )
	{
		
	}
	
	public Tilemap getMiddle()
	{
		return area[1][1];
	}
}
