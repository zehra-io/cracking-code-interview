package io.kaluh.java8.basic.threads;

import java.util.concurrent.CountDownLatch;

/**
 * http://codepumpkin.com/countdownlatch-java-concurrency/
 * 
 * 
 * CountDownLatch in Java Concurrency is a type of synchronizer which allows one
 * Thread to wait for one or more Threads before it starts processing.
 * 
 * One point to remember is CountDown Latch cannot be reused. Once the countdown
 * reaches zero any further call to await() method won't block any thread. It
 * won't throw any exception either.
 * 
 * 
 * @author Z462725
 *
 */
public class CountDownLatchSample {

	public static void main(String args[]) {

		final CountDownLatch latch = new CountDownLatch(4);
		Thread emp1 = new Thread(new Employee("EMP 1", 1000, latch));
		Thread emp2 = new Thread(new Employee("EMP 2", 1000, latch));
		Thread emp3 = new Thread(new Employee("EMP 3", 1000, latch));
		Thread emp4 = new Thread(new Employee("EMP 4", 1000, latch));

		// separate threads will start moving all four employees
		// from their office to car parking.

		emp1.start();
		emp2.start();
		emp3.start();
		emp4.start();

		// Driver should not start car until all 4 employees take their seats in the
		// car.

		try {
			// carDriver thread is waiting on CountDownLatch to finish
			latch.await();
			System.out.println("All employees have taken their seat, Driver started the car");
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}

/**
 * Employee class which will be executed by Thread using CountDownLatch.
 */
class Employee implements Runnable {
	private final String name;
	private final int timeToReachParking;
	private final CountDownLatch latch;

	public Employee(String name, int timeToReachParking, CountDownLatch latch) {
		this.name = name;
		this.timeToReachParking = timeToReachParking;
		this.latch = latch;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(timeToReachParking);
		} catch (InterruptedException ex) {
			System.err.println("Error : ");
			ex.printStackTrace();
		}
		System.out.println(name + " has taken his seat");
		latch.countDown(); // reduce count of CountDownLatch by 1
	}

}