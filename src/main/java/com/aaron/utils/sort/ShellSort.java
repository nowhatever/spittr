package com.aaron.utils.sort;

import com.aaron.utils.DataUtils;
import com.aaron.utils.StringUtils;

public class ShellSort {

	public static void shellSort(int[] data, int length) {
		int increment = length / 2;

		if (increment < 1) {
			return;
		}
		
		for (int i = 0; i < increment; ++i) {
			for (int j = i + increment; j < data.length; j += increment) {
				int temp = data[j];
				int x = j;
				while ((x - increment) >= 0 && temp < data[x - increment]) {
					data[x] = data[x - increment];
					x -= increment;
				}
				data[x] = temp;
			}
		}

		System.out.println(StringUtils.toString(data));
		shellSort(data, increment);
	}

	public static void main(String[] args) {
		int[] data = DataUtils.randomIntArray(100, 30);
		System.out.println(StringUtils.toString(data));
		System.out.println("----------TO SORT---------");
		shellSort(data, data.length);
	}
}
