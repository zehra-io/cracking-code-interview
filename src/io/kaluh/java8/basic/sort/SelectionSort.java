package io.kaluh.java8.basic.sort;

import java.util.Arrays;
import java.util.List;

// Selecciona el menor de toda la lista y lo pone al frente
//Time O(n2), Space O(1) 
public class SelectionSort {

	public static List<Integer> sort(List<Integer> a) {
		int t = 0, lo = 0;
		for (int i = 0; i < a.size(); i++) {
			t = a.get(i);
			// Find lowest
			lo = i;
			for (int j = i; j < a.size(); j++) {
				if (t > a.get(j)) {
					lo = j;
				}
			}
			a.set(i, a.get(lo));
			a.set(lo, t);
		}
		return a;
	}

	public static void main(String[] args) {
		System.out.println(SelectionSort.sort(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1)));
	}
}