package io.kaluh.java8.basic.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * http://codepumpkin.com/cyclicbarrier-java-concurrency-utilities/
 * 
 * There are scenarios in concurrent programming when you want set of threads to
 * wait for each other at a common point until all threads in the set have
 * reached that common point.
 * 
 * The java.util.concurrent.CyclicBarrier class is a barrier that all threads
 * must wait at, until all threads reach it, before any of the threads can
 * continue.
 * 
 * The barrier is called cyclic because it can be re-used after the waiting
 * threads are released.
 * 
 * @author Z462725
 *
 */
public class CyclicBarrierSample {

	public static void main(String args[]) {

		// creating CyclicBarrier (checkPoint) with
		// 4 parties (Bikers) threads that need to call await()
		final CyclicBarrier checkPoint = new CyclicBarrier(4, new Runnable() {
			@Override
			public void run() {
				// This task will be executed once all biker threads will reach barrier
				System.out.println("\nAll bikers have arrived to checkpoint. Lets refill the petrol\n");
			}
		});

		// starting each of thread
		Thread biker1 = new Thread(new Biker(checkPoint), "Biker Thread 1");
		Thread biker2 = new Thread(new Biker(checkPoint), "Biker Thread 2");
		Thread biker3 = new Thread(new Biker(checkPoint), "Biker Thread 3");
		Thread biker4 = new Thread(new Biker(checkPoint), "Biker Thread 4");

		biker1.start();
		biker2.start();
		biker3.start();
		biker4.start();

	}
}

class Biker implements Runnable {

	private CyclicBarrier checkPoint;

	public Biker(CyclicBarrier checkPoint) {
		this.checkPoint = checkPoint;
	}

	// Code to be executed by each biker
	@Override
	public void run() {
		try {
			System.out.println(Thread.currentThread().getName() + " has left Manali");

			checkPoint.await();
			System.out.println(Thread.currentThread().getName() + " has left the first checkpoint / barrier");

			checkPoint.await();
			System.out.println(Thread.currentThread().getName() + " has left the second checkpoint / barrier");

			checkPoint.await();
			System.out.println(Thread.currentThread().getName() + " has reached Leh");

		} catch (InterruptedException | BrokenBarrierException ex) {
			ex.printStackTrace();
		}
	}
}
