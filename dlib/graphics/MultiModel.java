package dlib.graphics;

import java.awt.Image;
import java.util.ArrayList;

import dlib.util.DGraphics;

//TODO: Think about making MultiModels with movements
public class MultiModel implements Renderable
{
	ArrayList<Model> models = new ArrayList<Model>();
	ArrayList<Integer> colors = new ArrayList<Integer>();
	
	public MultiModel()
	{
		
	}
	
	public void add( Model m, int color )
	{
		models.add( m );
		colors.add( color );
	}
	
	public void add( Model m, int r, int g, int b )
	{
		add( m, DGraphics.rgb( r, g, b) );
	}
	
	public void add( Model m, int r, int g, int b, int a )
	{
		add( m, DGraphics.rgba( r, g, b, a) );
	}

	public void render(Renderer r) 
	{
		for( int i = 0; i < models.size(); i++ )
		{
			r.fill( colors.get(i) );
			models.get(i).render( r );
		}
	}
}
