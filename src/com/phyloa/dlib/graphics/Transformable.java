package com.phyloa.dlib.graphics;

import java.util.Stack;

import javax.vecmath.AxisAngle4f;
import javax.vecmath.Matrix4f;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

public class Transformable
{
	Stack<Matrix4f> mats = new Stack<Matrix4f>();
	Matrix4f mat = new Matrix4f();
	{
		mat.setIdentity();
	}
	
	public void translate( float x, float y, float z )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.set( new Vector3f( x, y, z ) );
		mat.mul( opMat );
	}
	
	public void translate( float x, float y )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.set( new Vector3f( x, y, 0 ) );
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
	
	public void rotate( float x, float y, float z, float angle )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.set( new AxisAngle4f( x, y, z, angle ) );
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
	
	public void scale( float x, float y, float z )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.setScale( x );
		mat.mul( opMat );
	}
	
	public void scale( float x, float y )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.setScale( x );
		mat.mul( opMat );
	}
	
	public void scale( float s )
	{
		Matrix4f opMat = new Matrix4f();
		opMat.setScale( s );
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
	
	protected void transform( Point3f v )
	{
		mat.transform( v );
	}
}
