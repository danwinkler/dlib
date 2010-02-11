package dlib.util;

import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;

import dlib.math.Intersection;
import dlib.math.Rayf;
import dlib.math.Trianglef;

public class DGeom
{
	public static final float EPSILON = .00001f;
	
	public static Intersection rayTriangleIntersect(Rayf ray, Trianglef tri)
	{
		float epsilon = .00001f;

		Point3f pt0 = tri.p1;
		Point3f pt1 = tri.p2;
		Point3f pt2 = tri.p3;
		Vector3f e1 = new Vector3f();
		Vector3f e2 = new Vector3f();
		e1.sub(pt1, pt0);
		e2.sub(pt2, pt0);
		Vector3f p = new Vector3f();
		p.cross(ray.dir, e2);
		float a;
		a = e1.dot(p);
		if( a > -epsilon && a < epsilon )
		{
			return null;
		}

		float f = 1.f / a;
		Vector3f s = new Vector3f();
		s.sub(ray.loc, pt0);
		float u = f * s.dot(p);

		if( u < 0 || u > 1 )
		{
			return null;
		}

		Vector3f q = new Vector3f();
		q.cross( s, e1 );
		float v = f * ray.dir.dot(q);

		if(v < 0 || u + v > 1)
		{
			return null;
		}

		float t = f * e2.dot(q);

		if( t < 0 )
		{
			return null;
		}
		t *= .99999;
		Point3f pos = new Point3f();
		pos.set(ray.dir);
		pos.scale(t);

		Vector3f dist = new Vector3f();
		dist.set(pos);
		pos.add( ray.loc );
		return new Intersection( pos, ray, tri );
	}
	
	
	public static Intersection rayTriangleIntersect2( Rayf ray, Trianglef tri )
	{
		Point3f vert0 = tri.p1;
		Point3f vert1 = tri.p2;
		Point3f vert2 = tri.p3;
		Vector3f dir = ray.dir;
		Point3f orig = ray.loc;
		
		float u, v, t;
		
		Vector3f edge1 = new Vector3f();
		Vector3f edge2 = new Vector3f();
		Vector3f tvec = new Vector3f();
		Vector3f pvec = new Vector3f();
		Vector3f qvec = new Vector3f();
		float det,inv_det;

		/* find vectors for two edges sharing vert0 */
		edge1.sub( vert1, vert0 );
		edge2.sub( vert2, vert0 );
		
		/* begin calculating determinant - also used to calculate U parameter */
		pvec.cross( dir, edge2 );
		
		/* if determinant is near zero, ray lies in plane of triangle */
		det = edge1.dot( pvec );
		
		if (det < EPSILON)
			return null;
		
		/* calculate distance from vert0 to ray origin */
		tvec.sub( orig, vert0 );
		
		/* calculate U parameter and test bounds */
		u = tvec.dot( pvec );
		if (u < 0.0 || u > det)
			return null;
		
		/* prepare to test V parameter */
		qvec.cross( tvec, edge1 );
		
		/* calculate V parameter and test bounds */
		v = dir.dot( qvec );
		if (v < 0.0 || u + v > det)
			return null;
		/* calculate t, scale parameters, ray intersects triangle */
		t = edge2.dot( qvec );
		inv_det = 1.f / det;
		t *= inv_det;
		u *= inv_det;
		v *= inv_det;
		   
		Point3f pos = new Point3f();
		pos.set(ray.dir);
		pos.scale(t);
		
		Vector3f dist = new Vector3f();
		dist.set(pos);
		pos.add( ray.loc );
		if( t < 0 )
			return null;
		return new Intersection( pos, ray, tri );

	}
}
