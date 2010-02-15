package dlib.math;

public class IVec3 extends IVec
{
	public IVec3() {};
	public IVec3( int x, int y, int z ) { this.x = x; this.y = y; this.z = z; }
	public IVec3( IVec vec ) { this.x = vec.x; this.y = vec.y; this.z = vec.z; }
	
	public void add( IVec v ) { this.x += v.x; this.y += v.y; this.z += v.z; }
	public void sub( IVec v ) { this.x -= v.x; this.y -= v.y; this.z -= v.z; }
	public void mul( IVec v ) { this.x *= v.x; this.y *= v.y; this.z *= v.z; }
	public void div( IVec v ) { this.x /= v.x; this.y /= v.y; this.z /= v.z; }
	
	public void mul( int m ) { this.x *= m; this.y *= m; this.z *= m; }
	public void div( int m ) { this.x /= m; this.y /= m; this.z /= m; }
	
	public void add( int x, int y, int z ) { this.x += x; this.y += y; this.z += z; }
	public void sub( int x, int y, int z ) { this.x -= x; this.y -= y; this.z -= z; }
	public void mul( int x, int y, int z ) { this.x *= x; this.y *= y; this.z *= z; }
	public void div( int x, int y, int z ) { this.x /= x; this.y /= y; this.z /= z; }
}
