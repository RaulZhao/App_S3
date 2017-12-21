package test;

import java.util.concurrent.*;

public class MultiThread implements Runnable{
	String name = "";
	
	static Semaphore locker = new Semaphore(2);
	
	public MultiThread(String name) {
		this.name = name;
	}
	
	public void run() {
		try {
			locker.acquire();
			System.out.println(name + ", acquire locker." );
			
			Thread.currentThread().sleep(1000);
			System.out.println(name + ", has available permits:" + locker.availablePermits());
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			System.out.println(name + ", release locker.");
			locker.release();
		}
	}
	
	public static void main(String[] args) {
		Thread thread1 = new Thread(new MultiThread("A"));
		Thread thread2 = new Thread(new MultiThread("B"));
		Thread thread3 = new Thread(new MultiThread("C"));
		Thread thread4 = new Thread(new MultiThread("D"));
		Thread thread5 = new Thread(new MultiThread("E"));
		Thread thread6 = new Thread(new MultiThread("F"));
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		thread6.start();
	}
}
