package com.phyloa.dlib.game;

public abstract class EntitySystem<Graphics>
{
	public abstract void update( float d, Entity e, EntityList list );
	
	public void render( Graphics g, Entity e, EntityList list )
	{
		
	}
}
