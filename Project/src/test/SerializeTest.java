package test;

import java.io.*;
import java.util.*;

public class SerializeTest implements Serializable, Cloneable{
	String name;
	int age;
	public SerializeTest(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = (SerializeTest) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("name:");
		sb.append(name);
		sb.append(",");
		sb.append("age:");
		sb.append(age);
		return sb.toString();
	}
	public void writeObject(FileOutputStream fop, Object obj) {
		try {
			ObjectOutputStream objWriter = new ObjectOutputStream(fop);
			objWriter.writeObject(obj);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readObject(File f) {
		try {
			FileInputStream fis = new FileInputStream(f);
			ObjectInputStream reader = new ObjectInputStream(fis);
			Object obj = reader.readObject();
			String obj_str = obj.toString();
			System.out.println("Object is - " + obj_str);
			fis.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		String path = "/Users/rzhao/workspace/personal/App_S3/";
		File f = new File(path, "java_test.txt");
		SerializeTest st = new SerializeTest("James", 30);
		
		try {
			SerializeTest st2 = (SerializeTest) st.clone();
			st2.age = 50;
			st2.name = "Owen";
			FileOutputStream ops = new FileOutputStream(f);
			OutputStreamWriter writer = new OutputStreamWriter(ops, "utf-8");
			st.writeObject(ops, st2);
			st.writeObject(ops, st);
			ops.close();
			st.readObject(f);
//			writer.write("支持中文\r\n");
//			writer.write("Hello Raul");
//			writer.close();
//			ops.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
