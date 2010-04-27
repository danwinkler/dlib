package com.phyloa.dlib.renderer;

import java.awt.Image;
import java.awt.event.KeyListener;

/**
 * All Renderers implement the Renderer interface. The Renderer methods are both for 
 * 2D and 3D drawing. 
 * 
 * @author Daniel Winkler
 *
 */
public interface Renderer
{
	/**
	 * begin is called to either start the render, or, if the renderer uses a
	 * game loop, to call initialize() and then loop update().
	 * 
	 * If the renderer does not implement the method, it will do nothing.
	 */
	public void begin();
	
	/**
	 * Sets the size of the rendering area/window
	 * @param x the width of the rendering area
	 * @param y the height of the rendering area
	 */
	public void size( int x, int y );
	
	/**
	 * Sets the frame rate if the Renderer uses a game loop
	 * 
	 * @param r the number of time per second update should be called
	 */
	public void frameRate( float r );
	
	/**
	 * Sets the color to draw in.
	 * @param c the color as a 32-bit ARGB integer
	 */
	public void color( int c );
	
	/**
	 * Sets the color to draw in.
	 * @param r the red component 0-255
	 * @param g the green component 0-255
	 * @param b the blue component 0-255
	 */
	public void color( float r, float g, float b );
	
	/**
	 * Sets the color to draw in.
	 * @param r the red component 0-255
	 * @param g the green component 0-255
	 * @param b the blue component 0-255
	 * @param a the alpha component 0-255
	 */
	public void color( float r, float g, float b, float a );
	
	/**
	 * Draws a line from one point to another in two-space.
	 * @param x1 the x location of the first point
	 * @param y1 the y location of the first point
	 * @param x2 the x location of the second point
	 * @param y2 the y location of the second point
	 */
	public void line( float x1, float y1, float x2, float y2 );
	
	/**
	 * Draws a line from one point to another in three-space.
	 * @param x1 the x location of the first point
	 * @param y1 the y location of the first point
	 * @param z1 the z location of the first point
	 * @param x2 the x location of the second point
	 * @param y2 the y location of the second point
	 * @param z2 the z location of the second point
	 */
	public void line( float x1, float y1, float z1, float x2, float y2, float z2 );
	
	/**
	 * Fills a rectangle in two-space.
	 * @param x the x location of the center of the rectangle
	 * @param y the y location of the center of the rectangle
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 */
	public void fillRect( float x, float y, float width, float height );
	
	/**
	 * Draws a rectangle in two-space.
	 * @param x the x location of the center of the rectangle
	 * @param y the y location of the center of the rectangle
	 * @param width the width of the rectangle
	 * @param height the height of the rectangle
	 */
	public void drawRect( float x, float y, float width, float height );
	
	/**
	 * Fills an ellipse in two-space.
	 * @param x the x location of the center of the ellipse
	 * @param y the y location of the center of the ellipse
	 * @param width the width of the ellipse
	 * @param height the height of the ellipse
	 */
	public void fillOval( float x, float y, float width, float height );
	
	/**
	 * Draws an ellipse in two-space.
	 * @param x the x location of the center of the ellipse
	 * @param y the y location of the center of the ellipse
	 * @param width the width of the ellipse
	 * @param height the height of the ellipse
	 */
	public void drawOval( float x, float y, float width, float height );
	
	/**
	 * Draws a string in two-space.
	 * 
	 * NOTE: there is currently no standard on how the string renders relative to 
	 * the location
	 * @param text the string to render
	 * @param x the x location of the string
	 * @param y the y location of the string
	 */
	public void text( String text, float x, float y );
	
	/**
	 * Renders a box at the origin in three-space.
	 * @param width the width of the box (x-space)
	 * @param height the height of the box (y-space)
	 * @param length the length of the box (z-space)
	 */
	public void box( float width, float height, float length );
	
	/**
	 * Begins recording points. Record points with vertex().
	 * 
	 * Similar to GL_Begin.
	 * 
	 * @param type The ShapeType denoting what type of shape should be rendered.
	 */
	public void beginShape( ShapeType type );
	
	/**
	 * Ends recording points.
	 */
	public void endShape();
	
	/**
	 * Records a point in two-space. Always call beginShape() first.
	 * @param x the x location of the point
	 * @param y the y location of the point
	 */
	public void vertex( float x, float y );
	
	/**
	 * Records a point in three-space. Always call beginShape() first.
	 * @param x the x location of the point
	 * @param y the y location of the point
	 * @param z the z location of the point
	 */
	public void vertex( float x, float y, float z );
	
	/**
	 * Sets the u, v coordinates of the texture for the next vertex.
	 * @param u
	 * @param v
	 */
	public void textureCoords( float u, float v );
	
	/**
	 * Called immediately after beginShape() to texture the shape begin rendered.
	 * @param img the Image to use for texturing
	 */
	public void texture( Image img );
	
	/**
	 * Translates the origin in two-space.
	 * @param x the amount to translate in x-space
	 * @param y the amount to translate in y-space
	 */
	public void translate( float x, float y );
	
	/**
	 * Translates the origin in three-space.
	 * @param x the amount to translate in x-space
	 * @param y the amount to translate in y-space
	 * @param z the amount to translate in z-space
	 */
	public void translate( float x, float y, float z );
	
	public void scale( float s );
	public void scale( float x, float y );
	public void scale( float x, float y, float z );
	
	/**
	 * Rotates the current space about a vector through the origin.
	 * @param angle the angle to rotate in radians
	 * @param vx x component of the vector to rotate around
	 * @param vy y component of the vector to rotate around
	 * @param vz z component of the vector to rotate around
	 */
	public void rotate( float angle, float vx, float vy, float vz );
	
	public void rotate( float angle );
	
	public void rotateX( float angle );
	public void rotateY( float angle );
	public void rotateZ( float angle );
	
	/**
	 * Pushes the current transformation matrix onto the stack.
	 */
	public void pushMatrix();
	
	/**
	 * Pops a transformation matrix off the stack and sets it as the current transformation matrix.
	 */
	public void popMatrix();
	
	/**
	 * Called once if game loop is used.
	 */
	public void initialize();
	
	/**
	 * Called every frame if game loop is used.
	 */
	public void update();
	
	/**
	 * Draws the image at the specified coordinates in two-space.
	 * @param img the Image to render
	 * @param x the x location of the upper left corner of the image
	 * @param y the y location of the upper left corner of the image
	 */
	public void drawImage( Image img, float x, float y );
	
	public void addKeyListener( KeyListener listener );
	
	public int getWidth();
	
	public int getHeight();
}

