package dlib.tests;

import dlib.graphics.Model;
import dlib.graphics.renderer.PAppletRenderer;

public class ModelTest extends PAppletRenderer
{
	Model model = new Model( ShapeType.QUAD_STRIP );
	
	public void setup()
	{
		size( 800, 600, P3D );
		frameRate( 30 );
		
		for( int i = 0; i <= 20; i++ )
		{
			model.add( 1, 0, 0 );
			model.add( 1, 0, 1 );
			model.rotateZ( (PI*2)/20 );
		}
		model.finalize();
	}
	
	public void draw()
	{
		lights(); 
		  background(200, 200, 200); 
		  perspective(PI/3.f, width/height, 1, 1000); 
		  camera( -100 - mouseY, 0, 100 - mouseY, // eyeX, eyeY, eyeZ 
		  0, 0, 0, // centerX, centerY, centerZ 
		  0.f, 0.f, -1.f); // upX, upY, upZ  
		  fill( 1, 0, 128 ); 
		  rotateZ( mouseX / 100.f ); 
		  scale( 15 );
		model.render( this );
	}
	
	public static void main( String[] args )
	{
		ModelTest t = new ModelTest();
		t.begin();
	}
}
