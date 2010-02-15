package dlib.lua;

import java.util.HashMap;

import javax.script.ScriptException;

public class DLuaRunner
{
	HashMap<String, DLua> scripts = new HashMap<String, DLua>();
	
	public DLuaRunner()
	{
		
	}
	
	public void add( String name, DLua script )
	{
		scripts.put( name, script );
	}
	
	public void add( String name, String script )
	{
		add( name, new DLua( script ) );
	}
	
	public void run( String name ) throws ScriptException
	{
		scripts.get( name ).run();
	}
	
	public DLua get( String name )
	{
		return scripts.get( name );
	}
}
