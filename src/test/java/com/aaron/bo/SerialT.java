package com.aaron.bo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class SerialT {

	public static void main(String[] args) {
		
		Component serial1 = new Component(1, "song");
		System.out.println("Object Serial---" + serial1);
		try {
			FileOutputStream fos = new FileOutputStream("serialTest.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(serial1);
			oos.flush();
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
