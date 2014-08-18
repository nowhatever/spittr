package com.aaron.IO.demo;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InputStreamDemo {

	 //使用FileInputStream读取文件信息
	 public static byte[] readFileByFileInputStream(File file) throws IOException
	 {
	     ByteArrayOutputStream output = new ByteArrayOutputStream();
	     FileInputStream fis = null;
	     try
	     {
	         fis = new FileInputStream(file);
	         byte[] buffer = new byte[1024];
	         int bytesRead = 0;
	         while((bytesRead = fis.read(buffer, 0, buffer.length)) != -1)
	         {
	             output.write(buffer, 0, bytesRead);
	         }
	     }
	     catch(Exception ex)
	     {
	         System.out.println("Error occurs during reading " + file.getAbsoluteFile());
	     }
	     finally
	     {
	         if (fis !=null) fis.close();
	         if (output !=null) output.close();
	     }
	     return output.toByteArray();
	 }
	 
	 //使用BufferedInputStream读取文件信息
	 public static byte[] readFileByBufferedInputStream(File file) throws Exception
	 {
	     FileInputStream fis = null;
	     BufferedInputStream bis = null;
	     ByteArrayOutputStream output = new ByteArrayOutputStream();
	     try
	     {
	         fis = new FileInputStream(file);
	         bis = new BufferedInputStream(fis);
	         byte[] buffer = new byte[1024];
	         int bytesRead = 0;
	         while((bytesRead = bis.read(buffer, 0, buffer.length)) != -1)
	         {
	             output.write(buffer, 0, bytesRead);
	         }
	     }
	     catch(Exception ex)
	     {
	         System.out.println("Error occurs during reading " + file.getAbsoluteFile());
	     }
	     finally
	     {
	         if (fis != null) fis.close();
	         if (bis != null) bis.close();
	         if (output != null) output.close();
	     }
	     return output.toByteArray();
	 }
}
