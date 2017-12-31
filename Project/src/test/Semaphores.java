package test;

import java.util.*;
import java.util.concurrent.*;

public class Semaphores {
	public static Semaphore sem = new Semaphore(1);
	public static Semaphore initSem = new Semaphore(0);
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		Thread c = new Thread(new Consumer("comsmer", list));
		Thread p = new Thread(new Producer("producer", list));
		c.start();
		p.start();
	}
}

class Consumer implements Runnable {
	public String name;
	LinkedList<String> list;
	Consumer(String name, LinkedList<String> list) {
		this.name = name;
		this.list = list;
	}
	public void run() {
		try {
			while(true) {
				Semaphores.initSem.acquire(1);
				Semaphores.sem.acquire();
				System.out.println(name + ": fetch one from list - " + list.removeFirst());
				Semaphores.sem.release();
				Thread.sleep(1500);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable{
	public String name;
	LinkedList<String> list;
	Producer(String name, LinkedList<String> list) {
		this.name = name;
		this.list = list;
	}
	public void run() {
		int n = 0;
		try {
			while(true) {
				Semaphores.sem.acquire();
				String productItem = "item"+n;
				list.add(productItem);
				System.out.println(name + ": generate product - " + productItem);
				Semaphores.initSem.release(1);
				Semaphores.sem.release();
				Thread.sleep(1000);
				n++;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
