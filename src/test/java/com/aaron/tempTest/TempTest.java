package com.aaron.tempTest;

import com.aaron.bo.AlertImpl;

/**
 * 暂时结论：对象访问成员变量的速度比数组访问其元素快
 * @author aaron
 *
 */
public class TempTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AlertImpl alert = new AlertImpl();
		alert.setId(1);
		alert.setId1(1);
		alert.setId2(1);
		alert.setId3(1);
		alert.setId4(1);
		alert.setId5(1);
		int x = 0;
		long start = System.nanoTime();
		int[] arr = new int[]{1,1,1,1,1,1};
		for(int i = 0; i < 10000000; ++i){
//			x = alert.getId();
//			x = alert.getId1();
//			x = alert.getId2();
//			x = alert.getId3();
//			x = alert.getId4();
//			x = alert.getId5();
			x = alert.id;
			x = alert.id1;
			x = alert.id3;
			x = alert.id2;
			x = alert.id4;
			x = alert.id1;
//			x = arr[0];
//			x = arr[1];
//			x = arr[2];
//			x = arr[3];
//			x = arr[4];
//			x = arr[5];
		}
		long end = System.nanoTime();
		System.out.print("cost " + (end - start) / 1000000 + "ms");
		
		
		
	}

}
