package com.aaron.thread.demo;

/**
 * 简单的循环同步通知demo
 * @author aaron
 *
 */
public class WaitNotifyDemo implements Runnable {

	private String name;
	private Object prev;
	private Object self;

	private WaitNotifyDemo(String name, Object prev, Object self) {
		this.name = name;
		this.prev = prev;
		this.self = self;
	}

	public void run() {
		int count = 3;
		while (count > 0) {
			synchronized (prev) {
				synchronized (self) {
					System.out.println(name);
					count--;
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					self.notify();
				}
				try {
					prev.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void main(String[] args) throws Exception {
		Object a = new Object();
		Object b = new Object();
		Object c = new Object();
		WaitNotifyDemo pa = new WaitNotifyDemo("A", c, a);
		WaitNotifyDemo pb = new WaitNotifyDemo("B", a, b);
		WaitNotifyDemo pc = new WaitNotifyDemo("C", b, c);

		new Thread(pa).start();
		new Thread(pb).start();
		new Thread(pc).start();
	}
}
