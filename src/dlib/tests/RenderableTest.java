package dlib.tests;

import dlib.graphics.Renderable;
import dlib.graphics.Renderer;

public class RenderableTest implements Renderable
{
	public void render( Renderer r )
	{
		r.rect( 0, 0, 20, 20 );
	}
}
