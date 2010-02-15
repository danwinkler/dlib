package dlib.math;

public class FVec2 extends FVec
{	
	public FVec2() {};
	public FVec2( float x, float y ) { this.x = x; this.y = y; }
	public FVec2( FVec vec ) { this.x = vec.x; this.y = vec.y; }
	
	public void add( FVec v ) { this.x += v.x; this.y += v.y; }
	public void sub( FVec v ) { this.x -= v.x; this.y -= v.y; }
	public void mul( FVec v ) { this.x *= v.x; this.y *= v.y; }
	public void div( FVec v ) { this.x /= v.x; this.y /= v.y; }
	
	public void mul( float m ) { this.x *= m; this.y *= m; }
	public void div( float m ) { this.x /= m; this.y /= m; }
	
	public void add( float x, float y ) { this.x += x; this.y += y; }
	public void sub( float x, float y ) { this.x -= x; this.y -= y; }
	public void mul( float x, float y ) { this.x *= x; this.y *= y; }
	public void div( float x, float y ) { this.x /= x; this.y /= y; }
}
