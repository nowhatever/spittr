package com.aaron.thread;

import com.aaron.bo.Info;

class Consumer implements Runnable{
	private Info info = null ;
	public Consumer(Info info){
		this.info = info ;
	}
	public void run(){
		for(int i=0;i<10;i++){
			this.info.get() ;
		}
	}
}