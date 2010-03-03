package dlib.graphics.window;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
	public boolean k1 = false;
	public boolean k2 = false;
	public boolean k3 = false;
	public boolean k4 = false;
	public boolean k5 = false;
	public boolean k6 = false;
	public boolean k7 = false;
	public boolean k8 = false;
	public boolean k9 = false;
	public boolean a = false;
	public boolean b = false;
	public boolean c = false;
	public boolean d = false;
	public boolean e = false;
	public boolean f = false;
	public boolean g = false;
	public boolean h = false;
	public boolean i = false;
	public boolean j = false;
	public boolean k = false;
	public boolean l = false;
	public boolean m = false;
	public boolean n = false;
	public boolean o = false;
	public boolean p = false;
	public boolean q = false;
	public boolean r = false;
	public boolean s = false;
	public boolean t = false;
	public boolean u = false;
	public boolean v = false;
	public boolean w = false;
	public boolean x = false;
	public boolean y = false;
	public boolean z = false;
	public boolean up = false;
	public boolean down = false;
	public boolean left = false;
	public boolean right = false;
	public boolean enter = false;
	public boolean shift = false;
	public boolean ctrl = false;
	public boolean space = false;
	public boolean alt = false;
	
	public int lastKeyCodePressed;
	public int lastModifiersExPressed;
	
	public int lastKeyCodeReleased;
	public int lastModifiersExReleased;

	public KeyHandler( Component c ) 
	{
		c.addKeyListener( this );
	}

	public void keyPressed( KeyEvent ke ) 
	{
		lastKeyCodePressed = ke.getKeyCode();
		lastModifiersExPressed = ke.getModifiersEx();
		switch( ke.getKeyCode() )
		{
		case KeyEvent.VK_A: a = true;
		case KeyEvent.VK_B: b = true;
		case KeyEvent.VK_C: c = true;
		case KeyEvent.VK_D: d = true;
		case KeyEvent.VK_E: e = true;
		case KeyEvent.VK_F: f = true;
		case KeyEvent.VK_G: g = true;
		case KeyEvent.VK_H: h = true;
		case KeyEvent.VK_I: i = true;
		case KeyEvent.VK_J: j = true;
		case KeyEvent.VK_K: k = true;
		case KeyEvent.VK_L: l = true;
		case KeyEvent.VK_M: m = true;
		case KeyEvent.VK_N: n = true;
		case KeyEvent.VK_O: o = true;
		case KeyEvent.VK_P: p = true;
		case KeyEvent.VK_Q: q = true;
		case KeyEvent.VK_R: r = true;
		case KeyEvent.VK_S: s = true;
		case KeyEvent.VK_T: t = true;
		case KeyEvent.VK_U: u = true;
		case KeyEvent.VK_V: v = true;
		case KeyEvent.VK_W: w = true;
		case KeyEvent.VK_X: x = true;
		case KeyEvent.VK_Y: y = true;
		case KeyEvent.VK_SPACE: space = true;
		case KeyEvent.VK_ENTER: enter = true;
		case KeyEvent.VK_ALT: alt = true;
		case KeyEvent.VK_SHIFT: shift = true;
		case KeyEvent.VK_CONTROL: ctrl = true;
		case KeyEvent.VK_UP: up = true;
		case KeyEvent.VK_DOWN: down = true;
		case KeyEvent.VK_LEFT: left = true;
		case KeyEvent.VK_RIGHT: right = true;
		}
	}
	
	public void keyReleased( KeyEvent ke ) 
	{
		lastKeyCodeReleased = ke.getKeyCode();
		lastModifiersExReleased = ke.getModifiersEx();
		switch( ke.getKeyCode() )
		{
		case KeyEvent.VK_A: a = false;
		case KeyEvent.VK_B: b = false;
		case KeyEvent.VK_C: c = false;
		case KeyEvent.VK_D: d = false;
		case KeyEvent.VK_E: e = false;
		case KeyEvent.VK_F: f = false;
		case KeyEvent.VK_G: g = false;
		case KeyEvent.VK_H: h = false;
		case KeyEvent.VK_I: i = false;
		case KeyEvent.VK_J: j = false;
		case KeyEvent.VK_K: k = false;
		case KeyEvent.VK_L: l = false;
		case KeyEvent.VK_M: m = false;
		case KeyEvent.VK_N: n = false;
		case KeyEvent.VK_O: o = false;
		case KeyEvent.VK_P: p = false;
		case KeyEvent.VK_Q: q = false;
		case KeyEvent.VK_R: r = false;
		case KeyEvent.VK_S: s = false;
		case KeyEvent.VK_T: t = false;
		case KeyEvent.VK_U: u = false;
		case KeyEvent.VK_V: v = false;
		case KeyEvent.VK_W: w = false;
		case KeyEvent.VK_X: x = false;
		case KeyEvent.VK_Y: y = false;
		case KeyEvent.VK_SPACE: space = false;
		case KeyEvent.VK_ENTER: enter = false;
		case KeyEvent.VK_ALT: alt = false;
		case KeyEvent.VK_SHIFT: shift = false;
		case KeyEvent.VK_CONTROL: ctrl = false;
		case KeyEvent.VK_UP: up = false;
		case KeyEvent.VK_DOWN: down = false;
		case KeyEvent.VK_LEFT: left = false;
		case KeyEvent.VK_RIGHT: right = false;
		}
	}

	public void keyTyped( KeyEvent e ) 
	{
		
	}
}
