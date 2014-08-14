package com.aaron.utils;

import java.util.Random;

public class DataUtils {

	/**
	 * 交换数组中两数值
	 * @param data
	 * @param posa
	 * @param posb
	 * @return
	 */
	public static int[] swap(int[] data, int posa, int posb){
		data[posa] ^= data[posb];
		data[posb] ^= data[posa];
		data[posa] ^= data[posb];
		return data;
	}
	
	/**
	 * 随机一个int数组
	 * @param max
	 * @param count
	 * @return
	 */
	public static int[] randomIntArray(int max, int count){
		int[] data = new int[count];
		Random random = new Random();
		for(int i = 0; i < data.length; ++i){
			data[i] = random.nextInt(max);
		}
		return data;
	}
}
