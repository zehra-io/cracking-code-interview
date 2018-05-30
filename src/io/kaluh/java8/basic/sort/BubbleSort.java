package io.kaluh.java8.basic.sort;

import java.util.Arrays;
import java.util.List;

// Having a collection, takes the first and compare it with the second and switched if the second one is less that the first one
// Time O(n2), Space O(1) 
public class BubbleSort {

	public static List<Integer> sort(List<Integer> a) {
		int t = 0;
		for (int i = 0; i < a.size(); i++) {
			for (int j = 0; j < a.size()-i-1; j++) {		
				t = a.get(j);
				if (t > a.get(j+1)) {
					// Change
					a.set(j, a.get(j+1));
					a.set(j+1, t);
				}
			}
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(BubbleSort.sort(Arrays.asList(10,10, 9,9, 8, 7, 6, 5, 4, 3, 2, 1)));
	}

}
