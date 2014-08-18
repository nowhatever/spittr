package com.aaron.IO.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {

	 //使用BufferedWriter复制文件
	 public static void copyFile(String file) throws IOException
	 { 
	     BufferedReader br = null;
	     BufferedWriter bw = null;
	     try
	     {
	         br = new BufferedReader(new FileReader(file));
	         bw = new BufferedWriter(new FileWriter(file + ".bak"));
	         String line = null;
	         while((line = br.readLine())!= null)
	         {
	             bw.write(line);
	         }
	     }
	     catch(Exception ex)
	     {
	         System.out.println("Error occurs during copying " + file);
	     }
	     finally
	     {
	         if (br != null) br.close();
	         if (bw != null) bw.close();
	     }
	 }
	
}
