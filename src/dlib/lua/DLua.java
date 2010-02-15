package dlib.lua;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class DLua 
{
	ScriptEngineManager mgr = new ScriptEngineManager();
	ScriptEngine e = mgr.getEngineByExtension(".lua");
	
	private String script = "";
	
	public DLua()
	{
		
	}
	
	public DLua( String s )
	{
		this.setScript(s);
	}
	
	public void run() throws ScriptException
	{
		setScript(getScript().trim());
		e.eval( getScript() );
	}
	
	public Object get( String key )
	{
		return e.get( key );
	}
	
	public void put( String key, Object value )
	{
		e.put( key, value );
	}
	
	public void nl( String line )
	{
		setScript(getScript() + (" \n " + line));
	}

	public void setScript( String script ) 
	{
		this.script = script;
	}

	public String getScript() 
	{
		return script;
	}

}
