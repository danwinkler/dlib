package dlib.game;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.vecmath.Point2f;
import javax.vecmath.Vector2f;

import dlib.graphics.Renderer;
import dlib.tests.DGameTest;
import dlib.util.DGraphics;

public class GameObject 
{
	public Point2f loc = new Point2f();
	public Vector2f speed = new Vector2f();
	
	public Vector2f acceleration = new Vector2f();
	
	public float angle;
	public float deltaAngle;
	
	public BufferedImage[] spriteSheet;
	
	public Image sprite;
	public float width;
	public float height;
	
	public GameObject( Image im, float x, float y, float width, float height )
	{
		subSheet( im, width, height );
		this.loc.x = x;
		this.loc.y = y;
		this.width = width;
		this.height = height;
	}
	
	public void updateObject()
	{
		update();
		
		speed.add( acceleration );
		loc.add( speed );
	}
	
	public void renderObject( Renderer r )
	{
		r.pushMatrix();
		r.translate( loc.x, loc.y );
		r.rotate( angle );
		r.drawImage( sprite, -width/2, -height/2 );
		r.popMatrix();
	}
	
	private void subSheet( Image im, float width, float height )
	{
		int parts =  (im.getWidth(null) / (int)width);
		spriteSheet = new BufferedImage[parts];
		for( int i = 0; i < parts; i++ )
		{
			spriteSheet[i] = DGraphics.createBufferedImage( (int)width, (int)height );
			Graphics2D g = spriteSheet[i].createGraphics();
			g.drawImage( im, -i*(int)width, 0, null );
			g.dispose();
		}
		sprite = spriteSheet[0];
	}
	
	public void setSprite( int i )
	{
		sprite = spriteSheet[i];
	}
	
	public void update()
	{
		
	}
}
