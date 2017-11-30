package com;

public class ThreadTest {
	static String firstName = "The first";

	public static void main(String[] args) {
		MultiThread mul = new MultiThread(firstName);
		Thread[] threads = new Thread[10];
		for(int i=0; i < 10; i++) {
			threads[i] = new Thread(mul);
		}
		for(Thread t : threads) {
			t.start();
		}
	}
}

class MultiThread implements Runnable {
	int count = 0;
	MultiThread(String name) {
		System.out.println(name);
		ThreadTest.firstName = ThreadTest.firstName + Thread.currentThread().getName();
	}
	
	public synchronized void setCount () {
		count++;
	}
	public synchronized int getCount () {
		return this.count;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		setCount();
		System.out.println("Thread:" + Thread.currentThread().getName() + "-" + Thread.currentThread().getId() + "=" + getCount());
	}
}
