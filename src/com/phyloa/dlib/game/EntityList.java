package com.phyloa.dlib.game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntityList {
	int nextKey = 0;
	
	public ArrayList<Entity> list = new ArrayList<Entity>();
	public HashMap<Integer, Entity> map = new HashMap<Integer, Entity>();
	
	public HashMap<String, Entity> namedEntities = new HashMap<String, Entity>();
	
	public void add( Entity e )
	{
		map.put( e.id, e );
		list.add( e );
	}
	
	public void add( Entity e, String name )
	{
		add( e );
		name( e, name );
	}
	
	public void update( Entity e )
	{
		if( map.containsKey( e.id ) )
		{
			map.get( e.id ).update( e );
		}
		else
		{
			add( e );
		}
	}
	
	public Entity getIndex( int index )
	{
		return list.get( index );
	}
	
	public Entity get( int key )
	{
		return map.get( key );
	}
	
	public Entity getByName( String name )
	{
		return namedEntities.get( name );
	}
	
	public int size()
	{
		return list.size();
	}
	
	public void remove( Entity e )
	{
		list.remove( map.remove( e.id ) );
		if( e.entityName != null ) {
			namedEntities.remove( e.entityName );
		}
	}
	
	public void addAll( List<Entity> el )
	{
		for( Entity e : el )
		{
			add( e );
		}
	}
	
	public void name( Entity e, String name )
	{
		e.entityName = name;
		namedEntities.put( name, e );
	}
}
