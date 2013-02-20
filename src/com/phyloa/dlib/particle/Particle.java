package com.phyloa.dlib.particle;

public abstract class Particle<R>
{
	public float x, y, dx, dy;
	
	public float timeleft;
	
	public float friction = 0;
	
	public boolean alive = true;
	
	public Particle( float x, float y, float dx, float dy, float duration )
	{
		this.x = x;
		this.y = y;
		this.dx = dx;
		this.dy = dy;
		this.timeleft = duration;
	}
	
	public void update( float time )
	{
		dx -= dx*friction;
		dy -= dy*friction;
		x += dx * time;
		y += dy * time;
		
		timeleft -= time;
		
		if( timeleft <= 0 )
		{
			alive = false;
		}
	}
	
	public abstract void render( R r );
}
