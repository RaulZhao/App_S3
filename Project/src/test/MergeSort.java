package test;

import java.util.*;

public class MergeSort {
	public ArrayList<Integer> merge (ArrayList<Integer> list1, ArrayList<Integer> list2) {
		ArrayList<Integer> tmp = new ArrayList<Integer>();
		list1 = (ArrayList) list1.clone();
		list2 = (ArrayList) list2.clone();
		
		while(list1.size() > 0 && list2.size() > 0) {
			if(list1.get(0) > list2.get(0)) {
				tmp.add(list2.remove(0));
			} else {
				tmp.add(list1.remove(0));
			}
		}
		tmp.addAll(list1);
		tmp.addAll(list2);
		return tmp;
	}
	
	public ArrayList<Integer> sort (ArrayList<Integer> inputList) {
		if (inputList.size() < 2) {
			return inputList;
		}
		int midIndex = inputList.size()/2;
		ArrayList<Integer> left = (ArrayList) inputList.subList(0, midIndex);
		ArrayList<Integer> right = (ArrayList) inputList.subList(midIndex, inputList.size());
		return merge(sort(left), sort(right));
	}
	
	public static void main(String[] args) {
		MergeSort ms = new MergeSort();
		ArrayList<Integer> list = new ArrayList();
		list.add(4);
		list.add(-4);
		list.add(2);
		list.add(7);
		list.add(9);
		list.add(4);
		list.add(3);
		list.add(4);
		list.add(56);
		list.add(33);
		System.out.println(ms.sort(list));
	}
}
