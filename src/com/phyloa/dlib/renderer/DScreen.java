package com.phyloa.dlib.renderer;

public abstract class DScreen<E, F>
{	
	public DScreenHandler<E, F> dsh;
	public E gc;
	
	public abstract void update( E gc, int delta );
	public abstract void render( E gc, F g );
	public abstract void onActivate( E gc, DScreenHandler<E, F> dsh );
	public abstract void onExit();
	public abstract void message( Object o );
}
