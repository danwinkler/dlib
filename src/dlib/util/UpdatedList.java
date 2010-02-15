package dlib.util;

import java.util.ArrayList;

import dlib.util.Updateable;

@SuppressWarnings("serial")
public class UpdatedList<E extends Updateable<M>, M> extends ArrayList<E>
{
	@SuppressWarnings("hiding")
	public <E extends Updateable<M>, M> UpdatedList()
	{
		super();
	}
	
	public void update(M m)
	{
		for( int i = 0; i < size(); i++ )
		{
			Updateable<M> u = get(i);
			if( u.isAlive() )
				u.update(m);
			else
			{
				remove( u );
				i--;
			}
		}
	}
	
	public void render(M m)
	{
		for( int i = 0; i < size(); i++ )
		{
			get(i).render(m);
		}
	}
}
