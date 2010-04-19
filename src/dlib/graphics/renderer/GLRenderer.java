package dlib.graphics.renderer;

import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

import com.sun.opengl.util.Animator;

import dlib.graphics.Renderer;
import dlib.util.DGraphics;

public abstract class GLRenderer implements Renderer, GLEventListener
{
	Frame frame;
	GLCanvas canvas;
	Animator animator;
	
	private GL g;
	
	public void display( GLAutoDrawable g ) 
	{
		this.g = g.getGL();
		render();
		update();
		this.g = null;
	}

	public void displayChanged( GLAutoDrawable g, boolean arg1, boolean arg2 ) 
	{
		this.g = g.getGL();
		render();
		this.g = null;
	}

	public void init( GLAutoDrawable g ) 
	{
		this.g = g.getGL();
		initialize();
		render();
		this.g = null;
	}

	public void reshape( GLAutoDrawable g, int x, int y, int width, int height )
	{
		this.g = g.getGL();
		render();
		this.g = null;
	}
	
	public void begin() 
	{
		frame = new Frame( "GLRenderer Window" );
	    GLCanvas canvas = new GLCanvas();

	    canvas.addGLEventListener( this );
	    frame.add(canvas);
	    frame.setSize(800, 600);
	    final Animator animator = new Animator(canvas);
	    frame.addWindowListener(new WindowAdapter() {
	        public void windowClosing( WindowEvent e ) {
	          new Thread(new Runnable() {
	              public void run() {
	                animator.stop();
	                System.exit(0);
	              }
	            }).start();
	        }
	      });
	    frame.setVisible(true);
	    animator.start();
	}

	
	
	public void addKeyListener( KeyListener listener ) 
	{
		frame.addKeyListener( listener );
	}
	
	public void beginShape( ShapeType type ) 
	{
		switch( type )
		{
		case LINE_STRIP: g.glBegin( GL.GL_LINE_STRIP ); break;
		case LINES: g.glBegin( GL.GL_LINES ); break;
		case POINTS: g.glBegin( GL.GL_POINTS ); break;
		case QUADS: g.glBegin( GL.GL_QUADS ); break;
		case QUAD_STRIP: g.glBegin( GL.GL_QUAD_STRIP ); break;
		case TRIANGLE_FAN: g.glBegin( GL.GL_TRIANGLE_FAN ); break;
		case TRIANGLE_STRIP: g.glBegin( GL.GL_TRIANGLE_STRIP ); break;
		case TRIANGLES: g.glBegin( GL.GL_TRIANGLES ); break;
		}
		
	}

	
	public void box( float width, float height, float length )
	{
		g.glPushMatrix();
		g.glScalef( width/2, height/2, length/2 );
		g.glBegin( GL.GL_QUADS );
		//FRONT FACE
		g.glVertex3f( -1, -1, -1 );
		g.glVertex3f( 1, -1, -1 );
		g.glVertex3f( 1, 1, -1 );
		g.glVertex3f( -1, 1, -1 );
		
		//BACK FACE
		g.glVertex3f( -1, -1, 1 );
		g.glVertex3f( 1, -1, 1 );
		g.glVertex3f( 1, 1, 1 );
		g.glVertex3f( -1, 1, 1 );
		
		//TOP
		g.glVertex3f( -1, 1, -1 );
		g.glVertex3f( 1, 1, -1 );
		g.glVertex3f( 1, 1, 1 );
		g.glVertex3f( -1, 1, 1 );
		
		//BOTTOM
		g.glVertex3f( -1, -1, -1 );
		g.glVertex3f( 1, -1, -1 );
		g.glVertex3f( 1, -1, 1 );
		g.glVertex3f( -1, -1, 1 );
		
		//RIGHT
		g.glVertex3f( 1, -1, -1 );
		g.glVertex3f( 1, -1, 1 );
		g.glVertex3f( 1, 1, 1 );
		g.glVertex3f( 1, 1, -1 );
		
		//LEFT
		g.glVertex3f( -1, -1, -1 );
		g.glVertex3f( -1, -1, 1 );
		g.glVertex3f( -1, 1, 1 );
		g.glVertex3f( -1, 1, -1 );
		g.glEnd();
		g.glPopMatrix();
		
	}

	
	public void drawImage(Image img, float x, float y) {
		
		
	}

	
	public void ellipse( float x, float y, float width, float height ) 
	{
		
		
	}

	
	public void endShape() 
	{
		g.glEnd();	
	}

	
	public void fill( int c ) 
	{
		g.glColor4i( DGraphics.getRed( c ), DGraphics.getGreen( c ), DGraphics.getBlue( c ), DGraphics.getAlpha( c ) );
	}

	
	public void fill( float r, float g, float b ) {
		
		
	}

	
	public void fill( float r, float g, float b, float a ) {
		
		
	}

	
	public void frameRate(float r) {
		
		
	}

	
	public abstract void initialize();

	
	public void line(float x1, float y1, float x2, float y2) {
		
		
	}

	
	public void line(float x1, float y1, float z1, float x2, float y2, float z2) {
		
		
	}

	
	public void popMatrix() {
		
		
	}

	
	public void pushMatrix() {
		
		
	}

	
	public void rect(float x, float y, float width, float height) 
	{
		beginShape( ShapeType.QUADS );
		vertex( x, y );
		vertex( x + width, y );
		vertex( x + width, y + height );
		vertex( x, y + height );
		endShape();
	}

	
	public void rotate(float angle, float vx, float vy, float vz) {
		
		
	}

	
	public void rotate(float angle) {
		
		
	}

	
	public void rotateX(float angle) {
		
		
	}

	
	public void rotateY(float angle) {
		
		
	}

	
	public void rotateZ(float angle) {
		
		
	}

	
	public void scale(float x, float y) {
		
		
	}

	
	public void scale(float x, float y, float z) {
		
		
	}

	
	public void size(int x, int y) {
		
		
	}

	
	public void stroke(int c) {
		
		
	}

	
	public void stroke(float r, float g, float b) {
		
		
	}

	
	public void stroke(float r, float g, float b, float a) {
		
		
	}

	
	public void text(String text, float x, float y) {
		
		
	}

	
	public void texture( Image img ) {
		
		
	}

	
	public void translate(float x, float y) {
		
		
	}

	
	public void translate(float x, float y, float z) {
		
		
	}

	
	public abstract void update();
	
	/**
	 * Because rendering can happen at any time, its not a good idea to update game logic here
	 */
	public abstract void render();
	
	public void vertex( float x, float y ) 
	{
		g.glVertex2f( x, y );
		
	}

	
	public void vertex( float x, float y, float z ) 
	{
		g.glVertex3f( x, y, z );
		
	}
	
	public GL getGL()
	{
		return g;
	}
}
