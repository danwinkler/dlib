package dlib.math;

public class FVec3 extends FVec
{
	public FVec3() {};
	public FVec3( float x, float y, float z ) { this.x = x; this.y = y; this.z = z; }
	public FVec3( FVec vec ) { this.x = vec.x; this.y = vec.y; this.z = vec.z; }
	
	public void add( FVec v ) { this.x += v.x; this.y += v.y; this.z += v.z; }
	public void sub( FVec v ) { this.x -= v.x; this.y -= v.y; this.z -= v.z; }
	public void mul( FVec v ) { this.x *= v.x; this.y *= v.y; this.z *= v.z; }
	public void div( FVec v ) { this.x /= v.x; this.y /= v.y; this.z /= v.z; }
	
	public void mul( float m ) { this.x *= m; this.y *= m; this.z *= m; }
	public void div( float m ) { this.x /= m; this.y /= m; this.z /= m; }
	
	public void add( float x, float y, float z ) { this.x += x; this.y += y; this.z += z; }
	public void sub( float x, float y, float z ) { this.x -= x; this.y -= y; this.z -= z; }
	public void mul( float x, float y, float z ) { this.x *= x; this.y *= y; this.z *= z; }
	public void div( float x, float y, float z ) { this.x /= x; this.y /= y; this.z /= z; }
	
	public FVec3 cross( FVec3 v )
	{
		FVec3 r = new FVec3();
		r.x = this.y*v.z - this.z*v.y;
		r.y = v.x*this.z - v.z*this.x;
		r.z = this.x*v.y - this.y*v.x;
		return r;
	}
}
