package dlib.graphics;

import java.awt.Image;

import dlib.math.FVec;

public interface Renderer
{
	//TODO: create interface so renderer can be chosen independently
	public void start( Renderer r );
	public void size( int x, int y );
	public void frameRate( float r );
	
	public void fill( int c );
	public void fill( float r, float g, float b );
	public void fill( float r, float g, float b, float a );
	
	public void stroke( int c );
	public void stroke( float r, float g, float b );
	public void stroke( float r, float g, float b, float a );
	
	public void line( float x1, float y1, float x2, float y2 );
	public void line( float x1, float y1, float z1, float x2, float y2, float z2 );
	
	public void rect( float x, float y, float width, float height );
	public void ellipse( float x, float y, float width, float height );
	
	public void text( String text, float x, float y );
	
	public void box( float width, float height, float length );
	
	enum ShapeType { POINTS, LINES, LINE_STRIP, TRIANGLES, TRIANGLE_STRIP, TRIANGLE_FAN, QUADS, QUAD_STRIP };
	public void beginShape( ShapeType type );
	public void endShape();
	
	public void vertex( float x, float y );
	public void vertex( float x, float y, float z );
	
	public void texture( Image img );
	
	public void translate( float x, float y );
	public void translate( float x, float y, float z );
	
	public void scale( float x, float y );
	public void scale( float x, float y, float z );
	
	public void rotate( float angle, float vx, float vy, float vz );
	
	public void pushMatrix();
	public void popMatrix();
	
	public void setup();
	public void draw();
	
}
