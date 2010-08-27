package com.phyloa.dlib.dui;

import com.phyloa.dlib.renderer.Graphics2DRenderer;

public class DUITest extends Graphics2DRenderer implements DUIListener
{
	DUI ui;
	
	DText lastPressed;
	
	public void initialize()
	{
		ui = new DUI( canvas );
		ui.addDUIListener( this );
		
		ui.add( new DButton( "File", 0, 0, 100, 30 ) );
		ui.add( new DButton( "Edit", 100, 0, 100, 30 ) );
		ui.add( new DButton( "Source", 200, 0, 100, 30 ) );
		ui.add( new DButton( "Refactor", 300, 0, 100, 30 ) );
		ui.add( new DButton( "Navigate", 400, 0, 100, 30 ) );
		ui.add( new DButton( "Search", 500, 0, 100, 30 ) );
		ui.add( new DButton( "Project", 600, 0, 100, 30 ) );
		ui.add( new DButton( "Run", 700, 0, 100, 30 ) );
		
		lastPressed = new DText( "Last Button Pressed: ", 100, 500 );
		ui.add( lastPressed );
		
		size( 800, 600 );
	}
	
	int size = 100;
	
	public void update()
	{
		color( 255, 255, 255 );
		fillRect( 0, 0, getWidth(), getHeight() );
		ui.update();
		ui.render( this );
		
		color( 0, 0, 0 );
	}
	
	public void event( DUIEvent event )
	{
		if( event.e instanceof DButton )
		{
			DButton button = (DButton)event.e;
			lastPressed.setText( "Last Button Pressed: " + button.getText() );
		}
	}
	
	public static void main( String[] args )
	{
		DUITest test = new DUITest();
		test.begin();
	}
}
