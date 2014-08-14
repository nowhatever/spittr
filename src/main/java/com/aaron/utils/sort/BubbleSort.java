package com.aaron.utils.sort;

import com.aaron.utils.DataUtils;
import com.aaron.utils.StringUtils;

/**
 * 冒泡排序：两两比较 每次选出最大的向后移动（或选出最小的向前移动）
 * @author aaron
 *
 */
public class BubbleSort {
	
	public static int[] sort(int[] data){
		int tempMax;
		int j;
		for (int i = 0; i < data.length; ++i) {
			j = 0;
			while(j < data.length - i - 1){
				if(data[j] < data[j + 1]){
					tempMax = data[j + 1];
					data[j + 1] = data[j];
					data[j] = tempMax;
				}
				++j;
			}
			System.out.println(StringUtils.toString(data));
		}
		return data;
	}
	
	public static void main(String[] args) {
		int[] data = DataUtils.randomIntArray(1000, 10);
		System.out.println(StringUtils.toString(data));
		System.out.println("-------TO SORT--------");
		BubbleSort.bubbleSortMin(data);
	}
		
	/**
	 * 每轮选出最小的向前移动
	 * @param data
	 * @return
	 */
	public static int[] bubbleSortMin(int[] data){
		//将小的移到前面
		for(int i = data.length - 1; i > 0; i--){
			Boolean isOver = true;
			for(int j = data.length - 1; j > data.length - 1 -i; j--){
				if(data[j] < data[j - 1]){
					DataUtils.swap(data, j, j - 1);
					isOver = false;
				}
			}
			if(isOver){
				break;
			}
			System.out.println(StringUtils.toString(data));
		}
		
		return data;
	}
	
	/**
	 * 每轮选出最大的向后移动
	 * @param data
	 * @return
	 */
	public static int[] bubbleSortMax(int[] data){
		//将大的移到后面
		for(int i = 0; i < data.length - 1; i++){
			Boolean isOver = true;
			for(int j = 0; j < data.length - 1 - i; j++){
				if(data[j] > data[j + 1]){
					DataUtils.swap(data, j, j - 1);
					isOver = false;
				}
			}
			if(isOver){
				break;
			}
			System.out.println(StringUtils.toString(data));
		}
		
		return data;
	}
}
