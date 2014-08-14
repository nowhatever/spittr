package com.aaron.utils;

public class StringUtils {

	public static String toString(int[] data){
		StringBuilder sb = new StringBuilder();
		for(int i : data){
			sb.append(i).append(",");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}
}
