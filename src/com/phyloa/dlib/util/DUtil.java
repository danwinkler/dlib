package com.phyloa.dlib.util;

import java.util.ArrayList;

public class DUtil
{
	public static int[] integerArrayListToIntArray( ArrayList<Integer> list )
	{
		int[] ret = new int[list.size()];
		for( int i = 0; i < list.size(); i++ )
		{
			ret[i] = list.get( i );
		}
		return ret;
	}
}
