package dlib.graphics;

import java.awt.Image;

import dlib.graphics.Renderer.ShapeType;

public class TexturedModel extends Model 
{
	float[] u;
	float[] v;
	
	Image texture;
	
	public TexturedModel(ShapeType type) 
	{
		super(type);
		
	}
	
	public TexturedModel( ShapeType type, Image texture )
	{
		super( type );
		this.texture = texture;
	}
}
