package com.aaron.thread.test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 验证内存可见性 因为count++不是原子操作，所以存在这个存在这个问题；
 * @author aaron
 *
 */
public class CounterTest {
    //public static AtomicInteger count = new AtomicInteger(0);
    public static Integer count = 0;
    public static void inc() {
        //这里延迟1毫秒，使得结果明显
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
        }
        count++;
        //count.incrementAndGet();
    }
    public static void main(String[] args) {
        //同时启动1000个线程，去进行i++计算，看看实际结果
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(new Runnable() {
                public void run() {
                    new CounterTest().inc();
                }
            });
            thread.start();
//            try {
//				thread.start();
//				thread.join();
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
        }
        //这里每次运行的值都有可能不同,可能不为1000
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }
        System.out.println("运行结果:Counter.count=" + CounterTest.count);
    }
}
