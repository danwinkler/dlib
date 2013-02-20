package com.phyloa.dlib.particle;

import java.util.ArrayList;

public class ParticleSystem<R>
{
	ArrayList<Particle<R>> particles = new ArrayList<Particle<R>>();
	
	public void update( float d )
	{
		for( int i = 0; i < particles.size(); i++ )
		{
			Particle<R> p = particles.get( i );
			p.update( d );
			if( !p.alive )
			{
				particles.remove( i );
				i--;
			}
		}
	}
	
	public void render( R r )
	{
		for( int i = 0; i < particles.size(); i++ )
		{
			Particle<R> p = particles.get( i );
			p.render( r );
		}
	}
	
	public void add( Particle<R> p )
	{
		particles.add( p );
	}
}
