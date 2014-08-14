package com.aaron.utils.sort;

import com.aaron.utils.DataUtils;
import com.aaron.utils.StringUtils;

/**
 * 快速排序
 * 
 * @author aaron
 * 
 */
public class QuickSort {

	public static void swap(int a,int b){int t;t =a ;a =b ;b =t ;} 
   
	public static int Partition(int [] arr,int low,int high) 
    { 
        int pivot=arr[low];//采用子序列的第一个元素作为枢纽元素 
        while (low < high) 
        { 
            //从后往前栽后半部分中寻找第一个小于枢纽元素的元素 
            while (low < high && arr[high] >= pivot) 
            { 
                --high; 
            } 
            //将这个比枢纽元素小的元素交换到前半部分 
            swap(arr[low], arr[high]); 
            //从前往后在前半部分中寻找第一个大于枢纽元素的元素 
            while (low <high &&arr [low ]<=pivot ) 
            { 
                ++low ; 
            } 
            swap (arr [low ],arr [high ]);//将这个枢纽元素大的元素交换到后半部分 
        } 
        return low ;//返回枢纽元素所在的位置 
    } 
//    public static int[] quickSort(int [] a,int low,int high) 
//    { 
//        if (low <high) 
//        { 
//            int n=Partition (a ,low ,high ); 
//            quickSort (a ,low ,n); 
//            quickSort (a ,n +1, high ); 
//        } 
//        return a;
//    } 
    
    //快速排序
    public static void quick_sort(int s[], int l, int r)
    {
        if (l < r)
        {
    		//Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
    				j--;  
                if(i < j) 
    				s[i++] = s[j];
    			
                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
    				i++;  
                if(i < j) 
    				s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用 
            quick_sort(s, i + 1, r);
        }
    }

	public static void main(String[] args) {
		int[] data = DataUtils.randomIntArray(100, 10);
		System.out.println(StringUtils.toString(data));
		System.out.println("----------TO SORT---------");
		quick_sort(data, 0, data.length - 1);
	}
	
}
