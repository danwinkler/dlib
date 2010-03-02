package dlib.math;

public class IVec2 extends IVec
{
	public IVec2() {};
	public IVec2( int x, int y ) { this.x = x; this.y = y; }
	public IVec2( IVec vec ) { this.x = vec.x; this.y = vec.y; }
	
	public void add( IVec v ) { this.x += v.x; this.y += v.y; }
	public void sub( IVec v ) { this.x -= v.x; this.y -= v.y; }
	public void mul( IVec v ) { this.x *= v.x; this.y *= v.y; }
	public void div( IVec v ) { this.x /= v.x; this.y /= v.y; }
	
	public void mul( int m ) { this.x *= m; this.y *= m; }
	public void div( int m ) { this.x /= m; this.y /= m; }
	
	public void add( int x, int y ) { this.x += x; this.y += y; }
	public void sub( int x, int y ) { this.x -= x; this.y -= y; }
	public void mul( int x, int y ) { this.x *= x; this.y *= y; }
	public void div( int x, int y ) { this.x /= x; this.y /= y; }
}
