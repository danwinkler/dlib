package dlib.graphics;


import java.io.Serializable;
import java.util.ArrayList;

import javax.vecmath.Matrix4f;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3f;

import dlib.graphics.Renderer.ShapeType;

public class Model implements Renderable, Serializable
{
	float[] x;
	float[] y;
	float[] z;
	Matrix4f mat = new Matrix4f();
	
	ArrayList<Point3f> points = new ArrayList<Point3f>();
	boolean finalized = true;
	
	ShapeType type;
	
	public Model( ShapeType type )
	{
		this.type = type;
	}
	
	public void add( Point3f point )
	{
		Point3f pt = new Point3f();
		mat.transform( point, pt );
		points.add( pt );
		finalized = false;
	}
	
	public void add( float x, float y, float z )
	{
		Point3f pt = new Point3f( x, y, z);
		mat.transform( pt );
		points.add( pt );
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
				Point3f p = points.get(i);
				r.vertex( p.x, p.y, p.z );
			}
		}
		r.endShape();
	}
	
	public void translate( float x, float y, float z )
	{
		
	}
	
	public void translate( Tuple3f t )
	{
		
	}

}
