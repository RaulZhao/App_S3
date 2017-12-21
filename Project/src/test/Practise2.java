package test;

import java.util.*;

public class Practise2 {
	LinkedList<Integer> originList = new LinkedList<Integer>();
	public int[] generateArray(int[] arr, int n) {
		int[] result = new int[n];
		for (int i=0; i < n; i++) {
			originList.add(i);
		}
		for(int i=arr.length -1; i >= 0; i--) {
			int index = originList.size() - arr[i] - 1;
			result[i] = originList.remove(index) + 1;
		}
		return result;
	}
	
	public int binarySearch(int[] arr, int target) {
		int left = 0;
		int right = arr.length-1;
		
		while (left <= right) {
			int mid = left + (right - left)/2;
			if (target == arr[mid]) {
				return mid;
			} else if (target < arr[mid]) {
				right = mid-1;
			} else {
				left = mid+1;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Practise2 p = new Practise2();
		int[] testingGenerateAarray = {0,1,2,1,0};
		int[] result = p.generateArray(testingGenerateAarray, 5);
		
		int[] testingSearch = {3,9,5,4,-34,93,435,-3,0,2,1};
		for (int i=0; i < testingSearch.length; i++) {
			int index = p.binarySearch(testingSearch, testingSearch[i]);
			if (index != -1) {
				System.out.println(testingSearch[i] + ":" + index);
			}
		}
	}
}
