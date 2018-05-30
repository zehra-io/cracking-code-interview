package io.kaluh.java8.basic.singleton;

// https://www.journaldev.com/1377/java-singleton-design-pattern-best-practices-examples
/**
 * Singleton pattern restricts the instantiation of a class and ensures that
 * only one instance of the class exists in the java virtual machine. The
 * singleton class must provide a global access point to get the instance of the
 * class. Singleton pattern is used for logging, drivers objects, caching and
 * thread pool. Singleton design pattern is also used in other design patterns
 * like Abstract Factory, Builder, Prototype, Facade etc. Singleton design
 * pattern is used in core java classes also, for example java.lang.Runtime,
 * java.awt.Desktop.
 * 
 * Private constructor to restrict instantiation of the class from other
 * classes. Private static variable of the same class that is the only instance
 * of the class. Public static method that returns the instance of the class,
 * this is the global access point for outer world to get the instance of the
 * singleton class.
 * 
 * @author Z462725
 *
 */
// Singleton Class is created at the time of class loading
// Singleton classes are created for resources such as File System, Database
// connections etc and we should avoid the instantiation until unless client
// calls the getInstance method. Also this method doesn’t provide any options
// for exception handling.
public class EagerSingleton {

	// Create the instance
	private static final EagerSingleton instance = new EagerSingleton();

	// private constructor to avoid client applications to use constructor
	private EagerSingleton() {
	}

	public static EagerSingleton getInstance() {
		return instance;
	}
}
