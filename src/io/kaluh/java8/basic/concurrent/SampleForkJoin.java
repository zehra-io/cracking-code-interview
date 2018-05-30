package io.kaluh.java8.basic.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class SampleForkJoin extends RecursiveTask<Long>{

	int low, high;
	int[] array;
	
	SampleForkJoin (int [] arr, int lo, int hi) {
		array = arr;
		low = lo;
		high = hi;
	}
	
	protected Long compute() {
		System.out.println("compute :" + low + ", " + high);
		if (high - low  <= 4) {
			long sum = 0;
			for (int i=low; i < high; ++i) {
				sum += array[i];
			}
			return sum;
		} else {
			int mid = low + (high - low)/2;
			SampleForkJoin left = new SampleForkJoin(array, low, mid);
			SampleForkJoin right = new SampleForkJoin(array, mid, high);
			left.fork();
			long rightAns = right.compute();
			long leftAns = left.join();
			return leftAns + rightAns;
		}
	}
	
	public static long sumArray(int[] array) {
		return new ForkJoinPool().invoke(new SampleForkJoin(array,0,array.length));
	}

	public static void main(String[] args) {
		System.out.println(SampleForkJoin.sumArray(new int[]{1,2,3,4,5,6,7,8,87,67,5,4,454,454,45,34,2,2,446,54,4,9}));
	}
}
