package com.aaron.utils.sort;

import com.aaron.utils.DataUtils;
import com.aaron.utils.StringUtils;

/**
 * 直接插入排序:
 * 
 * 第一趟比较前两个数，然后把第二个数按大小插入到有序表中；
 * 第二趟把第三个数据与前两个数从前向后扫描，把第三个数按大小插入到有序表中；
 * 依次进行下去，进行了(n-1)趟扫描以后就完成了整个排序过程。
 * 
 * @author aaron
 *
 */
public class StraightInsertionSort {

	/**
	 * 直接插入排序
	 * @param data
	 * @return
	 */
	public static int[] straightInsertionSort(int[] data){
		int temp;
		int j;    //无序区游标
		for(int i = 0; i < data.length - 1; ++i){ 
			j = i + 1;
			if(data[j] < data[i]){
				temp = data[j];
				int index = 0;
				for(int x = i; x >= 0; --x){
					if(data[x] > temp){
						data[x + 1] = data[x];
						continue;
					}
					index = x + 1;
					break;
				}
				data[index] = temp;
			}
			System.out.println(StringUtils.toString(data));
		}
		
		return data;
	}
	
	public static void main(String[] args) {
		int[] data = DataUtils.randomIntArray(100, 10);
		System.out.println(StringUtils.toString(data));
		System.out.println("----------TO SORT---------");
		StringUtils.toString(straightInsertionSort(data));
	}
}
