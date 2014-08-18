package com.aaron.IO.demo;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStreamDemo {

	 //使用FileOutputStream复制文件
	 public static void copyFileByFileOutputStream(File file) throws IOException
	 {
	     FileInputStream fis = null;
	     FileOutputStream fos = null;
	     try
	     {
	         fis = new FileInputStream(file);
	         fos = new FileOutputStream(file.getName() + ".bak");
	         byte[] buffer = new byte[1024];
	         int bytesRead = 0;
	         while((bytesRead = fis.read(buffer,0,buffer.length)) != -1)
	         {
	             fos.write(buffer, 0, bytesRead);
	         }
	         fos.flush();
	     }
	     catch(Exception ex)
	     {
	         System.out.println("Error occurs during copying " + file.getAbsoluteFile());
	     }
	     finally
	     {
	         if (fis != null) fis.close();
	         if (fos != null) fos.close();
	     }
	 }
	 
	 //使用BufferedOutputStream复制文件
	 public static void copyFilebyBufferedOutputStream(File file)throws IOException
	 {
	     FileInputStream fis = null;
	     BufferedInputStream bis = null;
	     FileOutputStream fos = null;
	     BufferedOutputStream bos = null;
	     try
	     {
	         fis = new FileInputStream(file);
	         bis = new BufferedInputStream(fis);
	         fos = new FileOutputStream(file.getName() + ".bak");
	         bos = new BufferedOutputStream(fos);
	         byte[] buffer = new byte[1024];
	         int bytesRead = 0;
	         while((bytesRead = bis.read(buffer, 0, buffer.length)) != -1)
	         {
	             bos.write(buffer, 0, bytesRead);
	         }
	         bos.flush();
	     }
	     catch(Exception ex)
	     {
	         System.out.println("Error occurs during copying " + file.getAbsoluteFile());
	     }
	     finally
	     {
	         if (fis != null) fis.close();
	         if (bis != null) bis.close();
	         if (fos != null) fos.close();
	         if (bos != null) bos.close();
	     }
	 }
}
