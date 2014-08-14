package com.aaron.utils.sort;

import com.aaron.utils.DataUtils;
import com.aaron.utils.StringUtils;

/**
 * 选择排序
 * 每一趟从待排序的数据元素中选出最小（或最大）的一个元素，顺序放在已排好序的数列的最后，直到全部待排序的数据元素排完。
 * @author aaron
 *
 */
public class SelectSort {
	
	public static int[] selectSort(int[] data){
	
		int minIndex;
		for(int i = 0; i < data.length; ++i){
			minIndex = i;
			for(int j = i + 1; j < data.length; ++j){
				if(data[j] < data[minIndex]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				DataUtils.swap(data, minIndex, i);
			}
			
			System.out.println(StringUtils.toString(data));
		}
		
		return data;
	}
	
	
	public static void main(String[] args) {
		int[] data = DataUtils.randomIntArray(100, 10);
		System.out.println(StringUtils.toString(data));
		System.out.println("----------TO SORT---------");
		StringUtils.toString(selectSort(data));
	}
}
