package com.rmg.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainClass
{
	public static void main(String[] args) throws Throwable
	{
		/*serialization*/
		/*Game user1 = new Game("keerthi",10,04,30);
		FileOutputStream file=new FileOutputStream("./pubg.ser");
		ObjectOutputStream obj=new ObjectOutputStream(file);
		obj.writeObject(user1);
		System.out.println("done");*/
		
		
		/*deserilization*/
		FileInputStream file=new FileInputStream("./pubg.ser");
		ObjectInputStream obj=new ObjectInputStream(file);
		Game data=(Game)obj.readObject();
		System.out.println(data.level);
		System.out.println(data.name);
		System.out.println(data.boost);
		System.out.println(data.fuel);
	}

}
