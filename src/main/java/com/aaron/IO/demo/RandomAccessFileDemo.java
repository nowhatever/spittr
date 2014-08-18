package com.aaron.IO.demo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {

 	 //创建大小固定的文件
	 public static void createFile(String file, int size) throws IOException
	 {
	     File temp = new File(file);
	     RandomAccessFile raf = new RandomAccessFile(temp, "rw");
	     raf.setLength(size);
	     raf.close();
	 }
	 
	 //向文件中随机插入数据
	 public static void writeFile(String file, byte[] content, int startPos, int contentLength) throws IOException
	 {
	     RandomAccessFile raf = new RandomAccessFile(new File(file), "rw");
	     raf.seek(startPos);
	     raf.write(content, 0, contentLength);
	     raf.close();
	 }
	 
	 //移动文件
	 public static boolean moveFile(String sourceFile, String destFile)
	 {
	     File source = new File(sourceFile);
	     if (!source.exists()) throw new RuntimeException("source file does not exist.");
	     File dest = new File(destFile);
	     if (!(new File(dest.getPath()).exists())) new File(dest.getParent()).mkdirs();
	     return source.renameTo(dest);
	 }
	 
	 //复制文件
	 public static void copyFile(String sourceFile, String destFile) throws IOException
	 {
	     File source = new File(sourceFile);
	     if (!source.exists()) throw new RuntimeException("File does not exist.");
	     if (!source.isFile()) throw new RuntimeException("It is not file.");
	     if (!source.canRead()) throw new RuntimeException("File cound not be read.");
	     File dest = new File(destFile);
	     if (dest.exists())
	     {
	         if (dest.isDirectory()) throw new RuntimeException("Destination is a folder.");
	         else
	         {
	             dest.delete();
	         }
	     }
	     else
	     {
	         File parentFolder = new File(dest.getParent());
	         if (!parentFolder.exists()) parentFolder.mkdirs();
	         if (!parentFolder.canWrite()) throw new RuntimeException("Destination can not be written.");
	     }
	     FileInputStream fis = null;
	     FileOutputStream fos = null;
	     try
	     {
	         fis = new FileInputStream(source);
	         fos = new FileOutputStream(dest);
	         byte[] buffer = new byte[1024];
	         int bytesRead = 0;
	         while((bytesRead = fis.read(buffer, 0, buffer.length)) != -1)
	         {
	             fos.write(buffer, 0, bytesRead);
	         }
	         fos.flush();
	     }
	     catch(IOException ex)
	     {
	         System.out.println("Error occurs during copying " + sourceFile);
	     }
	     finally
	     {
	         if (fis != null) fis.close();
	         if (fos != null) fos.close();
	     }
	 }
	 
	 //复制文件夹
	 public static void copyDir(String sourceDir, String destDir) throws IOException
	 {

	     File source = new File(sourceDir);
	     if (!source.exists()) throw new RuntimeException("Source does not exist.");
	     if (!source.canRead()) throw new RuntimeException("Source could not be read.");
	     File dest = new File(destDir);
	     if (!dest.exists()) dest.mkdirs();

	     File[] arrFiles = source.listFiles();
	     for(int i = 0; i < arrFiles.length; i++)
	     {
	         if (arrFiles[i].isFile())
	         {
	             BufferedReader reader = new BufferedReader(new FileReader(arrFiles[i]));
	             BufferedWriter writer = new BufferedWriter(new FileWriter(destDir + "/" + arrFiles[i].getName()));
	             String line = null;
	             while((line = reader.readLine()) != null) writer.write(line);
	             writer.flush();
	             reader.close();
	             writer.close();
	         }
	         else
	         {
	             copyDir(sourceDir + "/" + arrFiles[i].getName(), destDir + "/" + arrFiles[i].getName());
	         }
	     }
	 }
	 
	 //删除文件夹
	 public static void del(String filePath)
	 {
	     File file = new File(filePath);
	     if (file == null || !file.exists()) return;
	     if (file.isFile())
	     {
	         file.delete();
	     }
	     else
	     {
	         File[] arrFiles = file.listFiles();
	         if (arrFiles.length > 0)
	         {
	             for(int i = 0; i < arrFiles.length; i++)
	             {
	                 del(arrFiles[i].getAbsolutePath());
	             }
	         }
	         file.delete();
	     }
	 }
	 
	 //获取文件夹大小
	 public static long getFolderSize(String dir)
	 {
	     long size = 0;
	     File file = new File(dir);
	     if (!file.exists()) throw new RuntimeException("dir does not exist.");
	     if (file.isFile()) return file.length();
	     else
	     {
	         String[] arrFileName = file.list();
	         for (int i = 0; i < arrFileName.length; i++)
	         {
	             size += getFolderSize(dir + "/" + arrFileName[i]);
	         }
	     }

	     return size;
	 }
	 
	 //将大文件切分成多个小文件
	 public static void splitFile(String filePath, long unit) throws IOException
	 {
	     File file = new File(filePath);
	     if (!file.exists()) throw new RuntimeException("file does not exist.");
	     long size = file.length();
	     if (unit >= size) return;
	     int count = size % unit == 0 ? (int)(size/unit) : (int)(size/unit) + 1;
	     String newFile = null;
	     FileOutputStream fos = null;
	     FileInputStream fis =null;
	     byte[] buffer = new byte[(int)unit];
	     fis = new FileInputStream(file);
	     long startPos = 0;
	     String countFile = filePath + "_Count";
	     PrintWriter writer = new PrintWriter(new FileWriter( new File(countFile)));
	     writer.println(filePath + "\t" + size);
	     for (int i = 1; i <= count; i++)
	     {
	         newFile = filePath + "_" + i;
	         startPos = (i - 1) * unit;
	         System.out.println("Creating " + newFile);
	         fos = new FileOutputStream(new File(newFile));
	         int bytesRead = fis.read(buffer, 0, buffer.length);
	         if (bytesRead != -1)
	         {
	             fos.write(buffer, 0, bytesRead);
	             writer.println(newFile + "\t" + startPos + "\t" + bytesRead);
	         }
	         fos.flush();
	         fos.close();
	         System.out.println("StartPos:" + i*unit + "; EndPos:" + (i*unit + bytesRead));
	     }
	     writer.flush();
	     writer.close();
	     fis.close();
	 }
	 
	 //将多个小文件合并成一个大文件
	 public static void linkFiles(String countFile) throws IOException
	 {
	     File file = new File(countFile);
	     if (!file.exists()) throw new RuntimeException("Count file does not exist.");
	     BufferedReader reader = new BufferedReader(new FileReader(file));
	     String line = reader.readLine();
	     String newFile = line.split("\t")[0];
	     long size = Long.parseLong(line.split("\t")[1]);
	     RandomAccessFile raf = new RandomAccessFile(newFile, "rw");
	     raf.setLength(size);
	     FileInputStream fis = null;
	     byte[] buffer = null;

	     while((line = reader.readLine()) != null)
	     {
	         String[] arrInfo = line.split("\t");
	         fis = new FileInputStream(new File(arrInfo[0]));
	         buffer = new byte[Integer.parseInt(arrInfo[2])];
	         long startPos = Long.parseLong(arrInfo[1]);
	         fis.read(buffer, 0, Integer.parseInt(arrInfo[2]));
	         raf.seek(startPos);
	         raf.write(buffer, 0, Integer.parseInt(arrInfo[2]));
	         fis.close();
	     }
	     raf.close();
	 }
	 
	 //执行外部命令
	 public static void execExternalCommand(String command, String argument)
	 {
	     Process process = null;
	     try
	     {
	         process = Runtime.getRuntime().exec(command + " " + argument);
	         InputStream is = process.getInputStream();
	         BufferedReader br = new BufferedReader(new InputStreamReader(is));
	         String line = null;
	         while((line = br.readLine()) != null)
	         {
	             System.out.println(line);
	         }
	     }
	     catch(Exception ex)
	     {
	         System.err.println(ex.getMessage());
	     }
	     finally
	     {
	         if (process != null) process.destroy();
	     }
	 }


}
