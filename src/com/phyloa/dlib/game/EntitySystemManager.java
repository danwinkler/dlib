package com.phyloa.dlib.game;

import java.util.ArrayList;
import java.util.List;

public class EntitySystemManager<Graphics>
{
	public EntityList list = new EntityList();
	public ArrayList<EntitySystem> updateSystems = new ArrayList<EntitySystem>();
	public ArrayList<EntitySystem> renderSystems = new ArrayList<EntitySystem>();
	
	public void add( Entity e )
	{
		list.add( e );
	}
	
	public void add( Entity e, String name )
	{
		list.add( e, name );
	}
	
	public void name( Entity e, String name )
	{
		list.name( e, name );
	}
	
	public void addAll( List<Entity> el )
	{
		list.addAll( el );
	}
	
	public void update( float d )
	{
		for( Entity en : list.list )
		{
			for( EntitySystem es : updateSystems )
			{
				es.update( d, en, list );
			}
		}
	}
	
	public void render( Graphics g )
	{
		for( Entity en : list.list )
		{
			for( EntitySystem es : updateSystems )
			{
				es.render( g, en, list );
			}
		}
	}

	public void addUpdate( EntitySystem s )
	{
		updateSystems.add( s );
	}
	
	public void addRender( EntitySystem s )
	{
		updateSystems.add( s );
	}

	public void updateEntities( ArrayList<Entity> el )
	{
		for( Entity e : el )
		{
			list.update( e );
		}
	}
}
