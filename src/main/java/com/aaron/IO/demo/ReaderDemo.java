package com.aaron.IO.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo {

	 //使用BufferedReader读取文件内容
	 public static String readFile(String file)throws IOException
	 {
	     BufferedReader br = null;
	     StringBuffer sb = new StringBuffer();
	     try
	     {
	         br = new BufferedReader(new FileReader(file));
	         String line = null;

	         while((line = br.readLine()) != null)
	         {
	             sb.append(line);
	         }
	     }
	     catch(Exception ex)
	     {
	         System.out.println("Error occurs during reading " + file);
	     }
	     finally
	     {
	         if (br != null) br.close();
	     }
	     return sb.toString();
	 }
}
