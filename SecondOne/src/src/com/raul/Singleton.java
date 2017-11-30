package src.com.raul;

public class Singleton {
	private static Singleton singleton = null;
	private Singleton() {}
	private static int times = 0;
	public void speak() {
		System.out.println("Hello World!" + times);
	}
	
	public static Singleton getInstance() {
		if (singleton == null) {
			times += 1;
			singleton = new Singleton();
		}
		return singleton;
	}
	
	public static void main(String[] args) {
		Singleton.getInstance().speak();
		Singleton.getInstance().speak();
		Singleton.getInstance().speak();
		Singleton.getInstance().speak();
	}
}

