package com.aaron.thread.test;

import java.util.HashSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证count内存可见性（同counterTest）
 * @author aaron
 *
 */
public class ThreadTest implements Runnable{

	private CountDownLatch cdl;
	public ThreadTest(CountDownLatch cdl) {
		this.cdl = cdl;
	}
	private volatile int count = 0;
	//private volatile AtomicInteger count = new AtomicInteger(0);
	
	HashSet<Integer> hs = new HashSet<Integer>();
	public void run() {
		//count.incrementAndGet();
		count++;
		cdl.countDown();
	}
	
	public static void main(String[] args) {
		final CountDownLatch cdl = new CountDownLatch(1000);
		ThreadTest tt = new ThreadTest(cdl);
		for(int i = 0; i < 1000; ++i){
			new Thread(tt, String.valueOf(i)).start();
		}
		try {
			cdl.await();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.print("count:" + tt.count);
	}

}
