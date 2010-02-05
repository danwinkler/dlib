package dlib.graphics;

import java.awt.Image;
import java.util.ArrayList;

import dlib.util.DGraphics;

//TODO: Think about making MultiModels with movements
public class MultiModel 
{
	ArrayList<Model> models = new ArrayList<Model>();
	ArrayList<Integer> colors = new ArrayList<Integer>();
	ArrayList<Image> textures = new ArrayList<Image>();
	
	public MultiModel()
	{
		
	}
	
	public void add( Model m, int color )
	{
		models.add( m );
		colors.add( color );
		textures.add( null );
	}
	
	public void add( Model m, int r, int g, int b )
	{
		add( m, DGraphics.rgb( r, g, b) );
	}
	
	public void add( Model m, int r, int g, int b, int a )
	{
		add( m, DGraphics.rgba( r, g, b, a) );
	}
	
	public void add( Model m, Image t )
	{
		models.add( m );
		colors.add( null );
		textures.add( t );
	}
}
