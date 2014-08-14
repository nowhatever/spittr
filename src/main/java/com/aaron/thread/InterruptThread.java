package com.aaron.thread;

public class InterruptThread implements Runnable {

	private String name;
	private Object prev;
	private Object self;

	private InterruptThread(String name, Object prev, Object self) {
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
		InterruptThread pa = new InterruptThread("A", c, a);
		InterruptThread pb = new InterruptThread("B", a, b);
		InterruptThread pc = new InterruptThread("C", b, c);

		new Thread(pa).start();
		new Thread(pb).start();
		new Thread(pc).start();
	}
}
