package com.phyloa.dlib.renderer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import javax.media.opengl.GL;
import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.vecmath.Vector2f;

import com.jogamp.opengl.util.Animator;
import com.jogamp.opengl.util.texture.Texture;
import com.jogamp.opengl.util.texture.awt.AWTTextureIO;
import com.phyloa.dlib.util.DGraphics;
import com.phyloa.dlib.util.KeyHandler;
import com.phyloa.dlib.util.MouseHandler;

public abstract class GLRenderer implements Renderer, GLEventListener
{
	public Frame frame;
	public GLCanvas canvas;
	public Animator animator;
	
	public KeyHandler k;
	public MouseHandler m;
	
	public GL2 g;
	public GLU glu;
	
	float viewAngle = 30;
	float aspectRatio = 800/600;
	float nearZ = 1;
	float farZ = 100;
	
	HashMap<BufferedImage,Texture> textures = new HashMap<BufferedImage,Texture>();
	
	public void display( GLAutoDrawable g ) 
	{
		this.g = g.getGL().getGL2();
		render();
		update();
		this.g = null;
	}

	public void displayChanged( GLAutoDrawable g, boolean arg1, boolean arg2 ) 
	{
		this.g = g.getGL().getGL2();
		render();
		this.g = null;
	}

	public void init( GLAutoDrawable g ) 
	{
		this.g = g.getGL().getGL2();
		glu = new GLU();
		initialize();
		render();
		this.g = null;
	}

	public void reshape( GLAutoDrawable g, int x, int y, int width, int height )
	{
		this.g = g.getGL().getGL2();
		render();
		this.g = null;
	}
	
	public void dispose( GLAutoDrawable arg0 ) 
	{
		// TODO Auto-generated method stub
		
	}
	
	public void begin() 
	{
		frame = new Frame( "GLRenderer Window" );
	    canvas = new GLCanvas();
	    k = KeyHandler.get( canvas );
	    m = MouseHandler.get( canvas );

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

	public void setFarClip( float x )
	{
		farZ = x;
		perspective();
	}
	
	public void setNearClip( float x )
	{
		nearZ = x;
		perspective();
	}
	
	public void perspective()
	{
		aspectRatio = (float)canvas.getWidth()/(float)canvas.getHeight();
		g.glLoadIdentity();
		glu.gluPerspective( viewAngle, aspectRatio, nearZ, farZ );
	}
	
	public void lookAt( float camX, float camY, float camZ, float x, float y, float z, float upX, float upY, float upZ )
	{
		glu.gluLookAt( camX, camY, camZ, x, y, z, upX, upY, upZ );
	}
	
	public void addKeyListener( KeyListener listener ) 
	{
		canvas.addKeyListener( listener );
	}
	
	public void beginShape( ShapeType type ) 
	{
		switch( type )
		{
		case LINE_STRIP: g.glBegin( GL.GL_LINE_STRIP ); break;
		case LINES: g.glBegin( GL.GL_LINES ); break;
		case POINTS: g.glBegin( GL.GL_POINTS ); break;
		case QUADS: g.glBegin( GL2.GL_QUADS ); break;
		case QUAD_STRIP: g.glBegin( GL2.GL_QUAD_STRIP ); break;
		case TRIANGLE_FAN: g.glBegin( GL.GL_TRIANGLE_FAN ); break;
		case TRIANGLE_STRIP: g.glBegin( GL.GL_TRIANGLE_STRIP ); break;
		case TRIANGLES: g.glBegin( GL.GL_TRIANGLES ); break;
		}
		
	}

	
	public void box( float width, float height, float length )
	{
		g.glPushMatrix();
		g.glScalef( width/2, height/2, length/2 );
		g.glBegin( GL2.GL_QUADS );
		//FRONT FACE
		g.glNormal3f( 0, 0, -1 );
		g.glVertex3f( -1, -1, -1 );
		g.glNormal3f( 0, 0, -1 );
		g.glVertex3f( 1, -1, -1 );
		g.glNormal3f( 0, 0, -1 );
		g.glVertex3f( 1, 1, -1 );
		g.glNormal3f( 0, 0, -1 );
		g.glVertex3f( -1, 1, -1 );
		
		//BACK FACE
		g.glNormal3f( 0, 0, 1 );
		g.glVertex3f( -1, -1, 1 );
		g.glNormal3f( 0, 0, 1 );
		g.glVertex3f( 1, -1, 1 );
		g.glNormal3f( 0, 0, 1 );
		g.glVertex3f( 1, 1, 1 );
		g.glNormal3f( 0, 0, 1 );
		g.glVertex3f( -1, 1, 1 );
		
		//TOP
		g.glNormal3f( 0, 1, 0 );
		g.glVertex3f( -1, 1, -1 );
		g.glNormal3f( 0, 1, 0 );
		g.glVertex3f( 1, 1, -1 );
		g.glNormal3f( 0, 1, 0 );
		g.glVertex3f( 1, 1, 1 );
		g.glNormal3f( 0, 1, 0 );
		g.glVertex3f( -1, 1, 1 );
		
		//BOTTOM
		g.glNormal3f( 0, -1, 0 );
		g.glVertex3f( -1, -1, -1 );
		g.glNormal3f( 0, -1, 0 );
		g.glVertex3f( 1, -1, -1 );
		g.glNormal3f( 0, -1, 0 );
		g.glVertex3f( 1, -1, 1 );
		g.glNormal3f( 0, -1, 0 );
		g.glVertex3f( -1, -1, 1 );
		
		//RIGHT
		g.glNormal3f( 1, 0, 0 );
		g.glVertex3f( 1, -1, -1 );
		g.glNormal3f( 1, 0, 0 );
		g.glVertex3f( 1, -1, 1 );
		g.glNormal3f( 1, 0, 0 );
		g.glVertex3f( 1, 1, 1 );
		g.glNormal3f( 1, 0, 0 );
		g.glVertex3f( 1, 1, -1 );
		
		//LEFT
		g.glNormal3f( -1, 0, 0 );
		g.glVertex3f( -1, -1, -1 );
		g.glNormal3f( -1, 0, 0 );
		g.glVertex3f( -1, -1, 1 );
		g.glNormal3f( -1, 0, 0 );
		g.glVertex3f( -1, 1, 1 );
		g.glNormal3f( -1, 0, 0 );
		g.glVertex3f( -1, 1, -1 );
		g.glEnd();
		g.glPopMatrix();
		
	}

	
	public void drawImage( Image img, float x, float y ) 
	{
		//TODO create a quad with the img mapped onto it
		
	}

	public void endShape() 
	{
		g.glEnd();	
	}

	
	public void color( int c ) 
	{
		color( DGraphics.getRed( c ), DGraphics.getGreen( c ), DGraphics.getBlue( c ), DGraphics.getAlpha( c ) );
	}

	public void color( float r, float g, float b ) 
	{
		this.g.glColor3f( r/255, g/255, b/255 );
	}

	
	public void color( float r, float g, float b, float a ) 
	{
		this.g.glColor4f( r/255, g/255, b/255, a/255 );
	}

	
	public void frameRate( float r ) 
	{
		
	}

	
	public abstract void initialize();

	
	public void line( float x1, float y1, float x2, float y2 ) 
	{
		g.glBegin( GL2.GL_LINE );
		g.glVertex2f( x1, y1 );
		g.glVertex2f( x2, y2 );
		g.glEnd();
	}

	
	public void line(float x1, float y1, float z1, float x2, float y2, float z2) 
	{
		g.glBegin( GL2.GL_LINE );
		g.glVertex3f( x1, y1, z1 );
		g.glVertex3f( x2, y2, z2 );
		g.glEnd();
	}

	
	public void popMatrix()
	{
		g.glPopMatrix();	
	}

	
	public void pushMatrix()
	{
		g.glPushMatrix();
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

	
	public void rotate( float angle, float vx, float vy, float vz ) 
	{
		g.glRotatef( angle, vx, vy, vz );
	}

	
	public void rotate( float angle )
	{
		g.glRotatef( angle, 0, 0, 1 );
	}

	
	public void rotateX( float angle )
	{
		g.glRotatef( angle, 1, 0, 0 );	
	}

	
	public void rotateY(float angle) 
	{
		g.glRotatef( angle, 0, 1, 0 );
	}

	
	public void rotateZ(float angle) 
	{
		g.glRotatef( angle, 0, 0, 1 );
	}

	
	public void scale( float x, float y ) 
	{
		g.glScalef( x, y, (x+y)/2 );	
	}
	
	public void scale( float x, float y, float z ) 
	{
		g.glScalef( x, y, z );
	}

	public void size( int x, int y )
	{
		frame.setSize( x, y );
	}
	
	public void stroke( int c )
	{
		g.glColor4i( DGraphics.getRed( c ), DGraphics.getGreen( c ), DGraphics.getBlue( c ), DGraphics.getAlpha( c ) );
	}

	
	public void stroke(float r, float g, float b) 
	{
		this.g.glColor3f( r/255, g/255, b/255 );
	}

	public void stroke(float r, float g, float b, float a) 
	{
		this.g.glColor4f( r/255, g/255, b/255, a/255 );
	}
	
	public void text( String text, float x, float y ) 
	{	
		//TODO
	}

	public void texture( Image img ) 
	{
		BufferedImage im = (BufferedImage)img;
		if( textures.containsValue( im ) )
		{
			textures.get( im ).bind();
		}
		else
		{
			Texture t = AWTTextureIO.newTexture( g.getGLProfile(), im, false );
			textures.put( im, t );
			t.bind();
		}
	}

	
	public void translate( float x, float y ) 
	{
		g.glTranslatef( x, y, 0 );
	}

	
	public void translate(float x, float y, float z) 
	{
		g.glTranslatef( x, y, z );
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

	public void drawOval( float x, float y, float width, float height ) 
	{
		
	}

	public void drawRect( float x, float y, float width, float height ) 
	{
		
	}
	
	public void fillOval( float x, float y, float width, float height ) 
	{
		
	}

	public void fillRect( float x, float y, float width, float height ) 
	{
		
	}

	public int getHeight() {
		return canvas.getHeight();
	}

	public int getWidth() {
		return canvas.getWidth();
	}

	public void scale(float s)
	{
		
	}

	public void textureCoords( float u, float v ) 
	{
		g.glTexCoord2f( u, v );
	}
	
	public void drawImage( Image im, float x, float y, float width, float height ){}
	public void drawImage( Image img, float dx1, float dy1, float dx2, float dy2, float sx1, float sy1, float sx2, float sy2 ){}
	
	public Vector2f getStringSize( String text )
	{
		return null;
	}

	public void setFont( Font font )
	{
		
	}
	
	public void color( Color color )
	{
		g.glColor3i( color.getRed(), color.getBlue(), color.getGreen() );
	}

	@Override
	public void fillRoundedRect( float x, float y, float width, float height,
			float arcWidth, float arcHeight )
	{

	@Override
	public void drawRoundedRect( float x, float y, float width, float height,
			float arcWidth, float arcHeight )
	{
}

