package com.aaron.thread;

/**
 * 验证线程在sleeping的时候不会被唤醒，只能被Interrupted
 * @author aaron
 *
 */
public class Sleeping implements Runnable {

	public Object lock = new Object();
	
	public void run() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			System.out.println("sleeping in");
		}
		System.out.println("sleeping out");
	}
	
	public static void main(String[] args) {

		Sleeping sp = new Sleeping();
		Thread thread = new Thread(sp);
		thread.run();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		synchronized(sp){
			sp.notifyAll();
		}
	}

}
