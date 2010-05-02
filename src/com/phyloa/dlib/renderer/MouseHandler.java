package com.phyloa.dlib.renderer;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseHandler implements MouseListener, MouseMotionListener, MouseWheelListener
{
	public MouseHandler( Component c )
	{
		c.addMouseListener( this );
		c.addMouseMotionListener( this );
		c.addMouseWheelListener( this );
	}

	public void mouseClicked( MouseEvent arg0 )
	{
		
	}

	public void mouseEntered( MouseEvent arg0 )
	{
		
	}

	public void mouseExited( MouseEvent arg0 )
	{
		
	}

	public void mousePressed( MouseEvent arg0 )
	{
		
	}

	public void mouseReleased( MouseEvent arg0 )
	{
		
	}

	public void mouseDragged( MouseEvent arg0 )
	{
		
	}

	public void mouseMoved( MouseEvent arg0 )
	{
		
	}

	public void mouseWheelMoved( MouseWheelEvent arg0 )
	{
	
	}
}
