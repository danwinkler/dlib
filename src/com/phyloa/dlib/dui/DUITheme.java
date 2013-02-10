package com.phyloa.dlib.dui;

import java.awt.Color;

public class DUITheme
{
	public static DUITheme defaultTheme;
	
	static
	{
		defaultTheme = new DUITheme();
		defaultTheme.borderColor = new Color( 32, 32, 128 );
		defaultTheme.backgroundColor = new Color( 128, 128, 255 );
	}
	
	Color borderColor;
	Color backgroundColor;
}
