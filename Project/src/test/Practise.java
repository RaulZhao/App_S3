package test;

import java.util.*;

public class Practise {
//	int[] array = new int[10];
	double num = Math.pow(2, 3);
	int[] array = {1,2,3,4,5};
	String str = "abcedabcd";
	LinkedList<Integer> linkedList = new LinkedList<Integer>();
	ArrayList<Student> students = new ArrayList<Student>();
	ArrayList<Double> testList = new ArrayList();
	StringBuilder sb = new StringBuilder("Hello Raul");
	HashMap<Character, Integer> hs = new HashMap<Character, Integer>();

	public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
	
	public void comapreStudent() {
		Student s1 = new Student(100, "Zhang San");
		Student s2 = new Student(127, "Li Si");
		Student s3 = new Student(46, "Zhang Alali");
		Student s4 = new Student(88, "Wang Wu");
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
		System.out.println("Before Print:" + students);
		Collections.sort(students);
		System.out.println("After Print:" + students);
		System.out.println(s1.equals(s3));
	}
	
	  public float calculate(int n) {
		 long[] total_sum = new long[n+1];
	     total_sum[0] = 0;
	
	     for(int i=1; i <= n; i++) {
	       total_sum[i] = (long) Math.pow(2, i);
	     }
	     
	     if (n % 2 == 0) {
	    	   long a = total_sum[n/2];
	    	   long b = total_sum[n];
	    	   return (float) a/b ;
	     }
	     return 0;
	  }
	
	public void operate() {
		List <Double> tmp = new LinkedList<Double>();
		tmp.add(4.0);
		tmp.add(5.0);
		tmp.add(4.0);
		
		testList.add(0.5);
	    testList.add(0.2);
	    testList.add(0.9);
	    testList.addAll(tmp);
	    testList.add(0.1);
	    testList.add(0.1);
	    testList.add(0.1);
	    testList.add(0.54);
	    testList.add(0.71);
	    testList.add(0.71);
	    testList.add(0.71);
	    testList.add(0.92);
	    testList.add(0.12);
	    testList.add(0.65);
	    testList.add(0.34);
	    testList.add(0.62);
	    Collections.sort(testList);
	    Collections.reverse(testList);
		List<List<String>> result = new ArrayList<List<String>>();
	    LinkedList<String> item = new LinkedList<String>();
//		System.out.println(str.substring(1, 2));
	    String a = "abc";
		linkedList.add(1);
		linkedList.add(2);
		linkedList.add(3);
		linkedList.add(4);
		System.out.println(linkedList.removeFirst());
		System.out.println(linkedList.removeLast());
		System.out.println(isPalindrome("abcba"));
		System.out.println("num:" + (long)num);
		System.out.println("Invoke calculate:" + calculate(10));
		System.out.println(testList.subList(0,3));
		System.out.println(testList);
		int[] arr = new int[10];
		System.out.println(str.replace("ab", "WOOO"));
		sb.insert(5, 'W');
		System.out.println(sb.toString());
	}
	public static void main (String[] arges) {
		Practise p = new Practise();
		p.operate();
//		p.comapreStudent();
	}
}

class Student implements Comparable<Student>{
	int id;
	String name;
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
	}
	@Override
	public int compareTo(Student o) {
		return this.id > o.id ? 1 : -1;
	}
	public boolean equals(Student s) {
		return this.name.charAt(0) == s.name.charAt(0);
	}
	public String toString() {
		return "Name is:" + name;
	}
	
}
