package com.aaron.utils.sort;

import com.aaron.utils.StringUtils;

/**
 * 归并排序(未完)
 * @author aaron
 *
 */
public class MergeSort {
	
	
	public static int[] mergeSort(int[] dataA, int[] dataB){
		int[] data = new int[dataA.length + dataB.length];
		
		int i = 0;  //A数组游标
		int j = 0;  //B数组游标
		int x = 0;  //新数组游标
		while(i < dataA.length){
			if(j < dataB.length){
				if (dataA[i] <= dataB[j]) {  //A组当前元素符合条件放入新数组
					data[x++] = dataA[i++];
				}else {
					//寻找B组符合条件的元素放入新数组
					while(j < dataB.length && dataA[i] > dataB[j]){
						data[x++] = dataB[j++];
					}
				}
			}else{ //B循环完A没有 循环完
				data[x++] = dataA[i++];
			}
			if(i == dataA.length && j < dataB.length){  //A循环完B没有 循环完
				while(j < dataB.length){
					data[x++] = dataB[j++];
				}
			}
		}
		
		return data;
	}
	
	
	public static void main(String[] args) {
		int[] dataB = new int[]{10,14,15,17};
		int[] dataA = new int[]{2,7,8,9};
		System.out.println("----------TO SORT---------");
		System.out.println(StringUtils.toString(mergeSort(dataA, dataB)));
		
		
		int n = 15;
		int y = n * (n - 1)/2;
	}

}
