package dlib.math;

import javax.vecmath.Point3f;

public class Trianglef extends Geom
{
	public Point3f p1;
	public Point3f p2;
	public Point3f p3;
	public int color;
	
	public Trianglef( Point3f p1, Point3f p2, Point3f p3 )
	{
		this.p1 = new Point3f( p1 );
		this.p2 = new Point3f( p2 );
		this.p3 = new Point3f( p3 );
	}
	
	public Trianglef( Point3f p1, Point3f p2, Point3f p3, int color )
	{
		this.p1 = new Point3f( p1 );
		this.p2 = new Point3f( p2 );
		this.p3 = new Point3f( p3 );
		this.color = color;
	}
	
	public void setColor( int color )
	{
		this.color = color;
	}
	
	public int getColor( float u, float v )
	{
		return color;
	}
}
