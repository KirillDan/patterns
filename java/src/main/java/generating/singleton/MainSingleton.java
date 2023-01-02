package generating.singleton;

import java.util.Random;

class Singleton {
	private static Singleton instance;
	private Integer value = new Random().nextInt();
	private Singleton() {
	}
	public static Singleton getInstance() {
		if (instance == null) {
			synchronized (Singleton.class) {
				if (instance == null) {
					instance = new Singleton();
				}
			}
		}
		return instance;
	}
	public Integer getValue() {
		return this.value;
	}
}

public class MainSingleton {
	public static void main(String[] args) {
		Singleton singleton1 = Singleton.getInstance();
		System.out.println(singleton1.getValue());
		Singleton singleton2 = Singleton.getInstance();
		System.out.println(singleton2.getValue());
		System.out.println(singleton2 == singleton1);
	}
}
