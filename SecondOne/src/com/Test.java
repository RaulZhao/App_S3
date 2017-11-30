package com;

import java.util.*;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.print("abc");
		List<String> arrayList = new ArrayList<String>();
		List<String> linkedList = new LinkedList<String>();
		String[] array = new String[10];
		int[][] dp = new int[10][];
		
		double a = 1.0;
		double b = 0.334;
		System.out.println(b * 51);
		System.out.println(Math.round (b * 51));
		arrayList.add("Testing one");
		arrayList.add("Testing two");
		arrayList.add(2, "The first String");
		linkedList.add(0, "The first String");
		double[] arr = new double[10];
		System.out.println(arr[0]);
	}
	
	public void print(String obj) {
		double i = 0;
		i++;
		i++;
		System.out.println("aaa" + i/3);
	}

}
