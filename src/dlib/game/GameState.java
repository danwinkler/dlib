package dlib.game;

import java.util.ArrayList;

import dlib.graphics.irenderer.Graphics2DImageRenderer;

public abstract class GameState
{
	ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	
	Graphics2DImageRenderer imr = new Graphics2DImageRenderer( DGame.width, DGame.height );
	
	public void start()
	{
		// TODO create game loop
	}
	
	public abstract void update();
	
	public void add( GameObject go )
	{
		gameObjects.add( go );
	}
}
