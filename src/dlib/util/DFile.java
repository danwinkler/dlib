package dlib.util;

import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class DFile
{
	public Object loadObject( String filename ) throws IOException, ClassNotFoundException
	{
		FileInputStream fis = new FileInputStream( filename );
		ObjectInputStream ois = new ObjectInputStream( fis );
		Object o = ois.readObject();
		ois.close();
		return o;
	}
	
	public void saveObject( String filename, Object file ) throws IOException
	{
		FileOutputStream fos = new FileOutputStream( filename );
		ObjectOutputStream oos = new ObjectOutputStream( fos );
		oos.writeObject( file );
		oos.close();
	}
	
	/*
	public String loadText( String filename ) throws FileNotFoundException
	{
		Scanner scanner = new Scanner( filename );
		
	}
	
	public void saveText( String filename, String text ) throws FileNotFoundException
	{
		FileOutputStream fos = new FileOutputStream( filename );
	}
	
	/**
	public Image loadImage( String filename ) throws FileNotFoundException
	{
		FileInputStream fis = new FileInputStream( filename );
	}
	
	public void saveImage( String filename, Image image ) throws FileNotFoundException
	{
		FileOutputStream fos = new FileOutputStream( filename );
	}
	*/
}
