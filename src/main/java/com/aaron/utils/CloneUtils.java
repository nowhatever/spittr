package com.aaron.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class CloneUtils {

	@SuppressWarnings("unchecked")
	public static <T extends Serializable> T clone(T obj){
		T cloneOjbT = null;
		
		try {
			//写入字节流
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			ObjectOutputStream outputStream = new ObjectOutputStream(out);
			outputStream.writeObject(obj);
			outputStream.close();
			
			//分配
			ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
			ObjectInputStream objIn = new ObjectInputStream(ios);
			cloneOjbT = (T)objIn.readObject();
			objIn.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return cloneOjbT;
	}
}
