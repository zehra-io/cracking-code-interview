package io.kaluh.java8.basic.singleton;

public class ThreadSafeDoubleCheckedSingleton {

	private static ThreadSafeDoubleCheckedSingleton instance;

	private ThreadSafeDoubleCheckedSingleton() {
	}

	public static ThreadSafeDoubleCheckedSingleton getInstanceUsingDoubleLocking() {
		if (instance == null) {
			synchronized (ThreadSafeDoubleCheckedSingleton.class) {
				if (instance == null) {
					instance = new ThreadSafeDoubleCheckedSingleton();
				}
			}
		}
		return instance;
	}
}
