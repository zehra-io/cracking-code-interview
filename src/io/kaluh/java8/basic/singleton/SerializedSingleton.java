package io.kaluh.java8.basic.singleton;

import java.io.Serializable;

/**
 * we need to implement Serializable interface in Singleton class so that we can
 * store it’s state in file system and retrieve it at later point of time
 * 
 * The problem with above serialized singleton class is that whenever we
 * deserialize it, it will create a new instance of the class.
 * 
 * 
 * @author Z462725
 *
 */
public class SerializedSingleton implements Serializable {

	private static final long serialVersionUID = -7604766932017737115L;

	private SerializedSingleton() {
	}

	private static class SingletonHelper {
		private static final SerializedSingleton instance = new SerializedSingleton();
	}

	public static SerializedSingleton getInstance() {
		return SingletonHelper.instance;
	}

	// Use this method to avoid destroy singleton
	protected Object readResolve() {
	    return getInstance();
	}
}
