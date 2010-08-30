package com.phyloa.dlib.dui;

public class DUIEvent 
{
	DUIElement element;
	
	public DUIEvent( DUIElement e )
	{
		this.element = e;
	}

	public DUIElement getElement()
	{
		return element;
	}
}
