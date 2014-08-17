package com.aaron.thread.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore可以控制某个资源被同时访问的任务数
 * 通过acquire（）获取一个许可，release（）释放一个许可。
 * 但不会保证线程安全，因此，在访问的时候，要自己控制线程的安全访问。
 * @author aaron
 *
 */
public class SemaphoreDemo{
	public static void main(String[] args) {
	//采用新特性来启动和管理线程——内部使用线程池
	ExecutorService exec = Executors.newCachedThreadPool();
	//只允许5个线程同时访问
	final Semaphore semp = new Semaphore(5);
	//模拟10个客户端访问
	for (int index = 0; index < 10; index++){
		final int num = index;
		Runnable run = new Runnable() {
			public void run() {
				try {
					//获取许可
					semp.acquire();
					System.out.println("线程" + 
						Thread.currentThread().getName() + "获得许可："  + num);
					//模拟耗时的任务
					for (int i = 0; i < 999999; i++) ;
					//释放许可
					semp.release();
					System.out.println("线程" + 
						Thread.currentThread().getName() + "释放许可："  + num);
					System.out.println("当前允许进入的任务个数：" +
						semp.availablePermits());
				}catch(InterruptedException e){
					e.printStackTrace();
				}
			}
		};
		  exec.execute(run);
	}
	//关闭线程池
	exec.shutdown();
	}
}
