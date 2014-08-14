package com.aaron.utils.sort;

import com.aaron.utils.DataUtils;
import com.aaron.utils.StringUtils;

/**
 * 若想得到升序，则建立大顶堆，若想得到降序，则建立小顶堆
 * @author aaron
 *
 */
public class HeapSort {

	/**
	 * 调整堆
	 * 若想得到升序，则建立大顶堆，若想得到降序，则建立小顶堆(此处创建大根堆)
	 * @param data
	 * @param pos  有序区长度（偏移）
	 * @return
	 */
	public static int[] adjustHeap(int[] data, int pos){
		
		int length = data.length - 1 - pos;
		for(int i = length; i > 0; --i){
			if(data[i] > data[(i - 1) / 2]){
				if((i % 2 == 0)){ //右孩子
					int swapSibling = data[i] > data[(i - 1)] ? i : (i - 1);
					DataUtils.swap(data, (i - 1) / 2, swapSibling);
					--i;
					int j = swapSibling;
					while((2 * j + 1) < length || (2 * j + 2) < length){  //有左右孩子
						if(data[(2 * j + 1)] > data[j] || data[(2 * j + 2)] > data[j]){ //孩子中有比j大的则交换孩子中的最大值
							int swapSiblingTwo = -1;
							if((2 * j + 2) < length){
								swapSiblingTwo = data[2 * j + 1] > data[2 * j + 2] ? (2 * j + 1) : (2 * j + 2);
								DataUtils.swap(data, j, swapSiblingTwo);
							}else {
								DataUtils.swap(data, j, 2 * j + 1);
								swapSiblingTwo = 2 * j + 1;
							}
							j = swapSiblingTwo;
						}else { //没有的话就跳出
							break;
						}
					}
				}else { //最后一个左叶子
					DataUtils.swap(data, i / 2, i);
				}
			}
		}
		System.out.println(StringUtils.toString(data));
		return data;
	}
	
	/**
	 * 堆排序
	 * @param data
	 * @return
	 */
	public static int[] heapSort(int[] data){
		int lastPos = data.length - 1;  //有序区偏移（数组反向偏移）
		
		while (lastPos > 0){
			data = adjustHeap(data, data.length - 1 - lastPos);
			DataUtils.swap(data, 0, lastPos);	
			lastPos--;
		}
		
		return data;
	}
	
	
	public static void main(String[] args) {
		int[] data = DataUtils.randomIntArray(100, 10);
		//int[] data = new int[]{91,43,51,70,68,59,68,4,56,34};;
		System.out.println(StringUtils.toString(data));
		System.out.println("----------TO SORT---------");
		System.out.println(StringUtils.toString(heapSort(data)));
	}
}
