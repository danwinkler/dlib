package com.phyloa.dlib.game;

import java.util.HashMap;

public abstract class Entity 
{
	static int nextId = 0;
	
	public HashMap<String, EntityComponent> components = new HashMap<String, EntityComponent>();
	
	public String entityName;
	public int id = nextId++;
	
	public <E extends EntityComponent> void add( E gc )
	{
		components.put( gc.getClass().getName(), gc );
	}
	
	@SuppressWarnings( "unchecked" )
	public <E extends EntityComponent> E getComponent( Class<E> c )
	{
		return (E)components.get( c.getName() );
	}

	public void update( Entity e )
	{
		this.components = e.components;
	}
}
