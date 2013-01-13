package com.phyloa.dlib.renderer;

public interface DScreen<E, F>
{	
	public void update( E e, int delta );
	public void render( E e, F f );
	public void onActivate( E e, DScreenHandler<E, F> dsh );
	public void onExit();
}
