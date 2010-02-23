package dlib.game;

import java.awt.Graphics2D;
import java.util.ArrayList;

import dlib.graphics.irenderer.Graphics2DImageRenderer;
import dlib.util.DGraphics;

public abstract class GameState
{
	ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	Graphics2DImageRenderer imr = new Graphics2DImageRenderer( DGame.width, DGame.height );
	
	int backgroundColor = DGraphics.rgb( 255, 255, 255 );
	
	public void start()
	{
		while( true )
		{
			long startTime = System.nanoTime();
			imr.fill( backgroundColor );
			imr.stroke( backgroundColor );
			imr.rect( 0, 0, DGame.width, DGame.height );
			
			update();
			for( int i = 0; i < gameObjects.size(); i++ )
			{
				gameObjects.get(i).updateObject();
				gameObjects.get(i).renderObject( imr );
			}
			DGame.window.draw( imr.getImage() );
			try { Thread.sleep( Math.max( (DGame.frameTime - (System.nanoTime() - startTime)) / 1000000, 0 ) ); } catch (InterruptedException e) {}
		}
	}
	
	public abstract void update();
	
	public void add( GameObject go )
	{
		gameObjects.add( go );
	}
	
	public void backgroundColor( int col )
	{
		
	}
}
