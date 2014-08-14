package com.aaron.bo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DeserialT {
	
	int a = 10;

	public static void main(String[] args) {
		Component serial2;
		try {
			FileInputStream fis = new FileInputStream("serialTest.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			serial2 = (Component) ois.readObject();
			ois.close();
			System.out.println("Object Deserial---" + serial2);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}