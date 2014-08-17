package com.aaron.thread.demo;

class ThreadBasicDemo extends Thread{
	private int ticket = 5;
	public void run(){
		for (int i=0;i<10;i++)
		{
			if(ticket > 0){
				System.out.println("ticket = " + ticket--);
			}
		}
	}
	
	public static void main(String[] args){
		new ThreadBasicDemo().start();
		new ThreadBasicDemo().start();
		new ThreadBasicDemo().start();
	}
}
