package test;

import java.util.*;

public class PractiseSecond {
	HashMap<String, Integer> map = new HashMap<String, Integer>();
	List<String> arraylist = new ArrayList<String>();
	LinkedList<String> linklist = new LinkedList<String>();
	
	public PractiseSecond() {
		init();
	}
	
	public void init() {
		map.put("A", 100);
		map.put("B", 90);
		map.put("C", 80);
		arraylist.add("A");
		arraylist.add("B");
		arraylist.add("C");
		arraylist.add(1, "D");
		linklist.add("A");
		linklist.add("B");
		linklist.addFirst("C");
		linklist.addLast("D");
	}
	public void test() throws InterruptedException {
		for(Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
//		for(String ele : arraylist) {
//			System.out.println(ele);
//		}
		
		for(int i=0; i < linklist.size(); ) {
			System.out.println(linklist.remove(i));
		}
	}
	
	public static void main(String[] args) {
		PractiseSecond p = new PractiseSecond();
		try{ 
			p.test();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
