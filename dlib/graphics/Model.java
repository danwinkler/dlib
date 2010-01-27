package dlib.graphics;

import java.io.Serializable;
import java.util.ArrayList;

import dlib.graphics.Renderer.ShapeType;
import dlib.math.FVec3;

public class Model implements Renderable, Serializable
{
	float[] x;
	float[] y;
	float[] z;
	
	ArrayList<FVec3> points = new ArrayList<FVec3>();
	boolean finalized = true;
	
	ShapeType type;
	
	public Model( ShapeType type )
	{
		this.type = type;
	}
	
	public void add( FVec3 point )
	{
		points.add( point );
		finalized = false;
	}
	
	public void add( float x, float y, float z )
	{
		points.add( new FVec3( x, y, z ) );
		finalized = false;
	}
	
	public void finalize()
	{
		x = new float[points.size()];
		y = new float[points.size()];
		z = new float[points.size()];
		for( int i = 0; i < points.size(); i++ )
		{
			x[i] = points.get(i).x;
			y[i] = points.get(i).y;
			z[i] = points.get(i).z;
		}
		finalized = true;
	}
	
	public void render(Renderer r) 
	{
		r.beginShape(type);
		if( finalized )
		{
			for( int i = 0; i < x.length; i++ )
			{
				r.vertex( x[i], y[i], z[i] );
			}
		}
		else
		{
			for( int i = 0; i < points.size(); i++ )
			{
				FVec3 p = points.get(i);
				r.vertex( p.x, p.y, p.z );
			}
		}
		r.endShape();
	}

}
