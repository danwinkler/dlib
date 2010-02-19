package dlib.graphics;


import java.awt.Image;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Stack;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Point3f;
import javax.vecmath.Tuple3f;
import javax.vecmath.Vector3f;

import dlib.graphics.Renderer.ShapeType;

public class Model implements Renderable, Serializable
{
	float[] x;
	float[] y;
	float[] z;
	Stack<Matrix4f> mats = new Stack<Matrix4f>();
	Matrix4f mat = new Matrix4f();
	
	ArrayList<Point3f> points = new ArrayList<Point3f>();
	boolean finalized = false;
	
	ShapeType type;
	
	public Model( ShapeType type )
	{
		this.type = type;
		mat.setIdentity();
	}
	
	public void add( Point3f point )
	{
		Point3f pt = new Point3f( point );
		mat.transform( point, pt );
		points.add( pt );
		finalized = false;
	}
	
	public void add( float x, float y, float z )
	{
		Point3f pt = new Point3f( x, y, z );
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
	
	public void render( Renderer r ) 
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
	
	public void render( Renderer r, Image texture ) 
	{
		r.beginShape(type);
		r.texture( texture );
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
		Matrix4f opMat = new Matrix4f();
		opMat.set( new Vector3f( x, y, z ) );
		mat.mul( opMat );
	}
	
	public void translate( Vector3f t )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.set( t );
		mat.mul( opMat );
	}
	
	public void rotate( Vector3f axis, float angle )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.set( new AxisAngle4f( axis, angle ) );
		mat.mul( opMat );
	}
	
	public void rotateX( float angle )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.rotX( angle );
		mat.mul( opMat );
	}
	
	public void rotateY( float angle )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.rotY( angle );
		mat.mul( opMat );
	}
	
	public void rotateZ( float angle )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.rotZ( angle );
		mat.mul( opMat );
	}
	
	public void pushMatrix()
	{
		mats.push( new Matrix4f( mat ) );
	}
	
	public void popMatrix()
	{
		mat = mats.pop();
	}
	
	public void box( float x, float y, float z )
	{
		float x2 = x/2;
		float y2 = y/2;
		float z2 = z/2;
		//TOP
		add( x2, y2, z2 );
		add( x2, -y2, z2 );
		add( -x2, -y2, z2 );
		add( -x2, y2, z2 );
		//BOTTOM
		add( x2, y2, -z2 );
		add( x2, -y2, -z2 );
		add( -x2, -y2, -z2 );
		add( -x2, y2, -z2 );
		//FRONT
		add( x2, y2, z2 );
		add( x2, y2, -z2 );
		add( -x2, y2, -z2 );
		add( -x2, y2, z2 );
		//BACK
		add( x2, -y2, z2 );
		add( x2, -y2, -z2 );
		add( -x2, -y2, -z2 );
		add( -x2, -y2, z2 );
		//LEFT
		add( x2, y2, z2 );
		add( x2, y2, -z2 );
		add( x2, -y2, -z2 );
		add( x2, -y2, z2 );
		//RIGHT
		add( -x2, y2, z2 );
		add( -x2, y2, -z2 );
		add( -x2, -y2, -z2 );
		add( -x2, -y2, z2 );
	}
	
	public void clear()
	{
		finalized = false;
		points = new ArrayList<Point3f>();
		mats.clear();
		mat.setIdentity();
	}
}