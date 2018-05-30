package io.kaluh.java8.basic.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(nlogn)
//Mergesort sorts in worst case in O(n log n) time. Due to the required 
//copying of the collection Mergesort is in the average case slower than Quicksort.
public class MergeSort {

	// Mezclar dos listas ordenadas
	// Ej. x =0; mid = 3; y = 6, entonces l = 3-0+1
	public static void merge(List<Integer> a, int x, int mid, int y) {
		// recorrer las dos listas, se supone si son disparejas, la primera es mayor por
		// 1
		for (int i = x, j = mid + 1; i <= mid;) {
			if (a.get(i).intValue() >= a.get(j).intValue()) {
				// Cambiar
				int t = a.get(i);
				a.set(i, a.get(j));
				a.set(j, t);
				j++;
			} else {
				i++;
			}
		}
		System.out.println("merge: x:" + x + ", y:" + y + ", mid:" + mid + ", a:" + a);
	}

	public static void sort(List<Integer> a, int x, int y) {
		if (x < y) {
			int mid = (x + y) / 2;
			System.out.println("x:" + x + ", y:" + y + ", mid: " + mid + ", a:" + a);
			sort(a, x, mid);
			sort(a, mid + 1, y);
			merge(a, x, mid, y);
		}
	}

	public static void main(String[] args) {
		// List<Integer> a = Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		List<Integer> a = Arrays.asList(4, 3, 2, 1);
		MergeSort.sort(a, 0, 3);
		System.out.println(a);
	}
}

// 10,9,8,7,6,5,4,3,2,1
// 10,9,8,7,6 || 5,4,3,2,1
// 10,9 || 8,7,6 merge 5,4,3 || 2,1
// 10 || 9 || 8,7,6 merge 5,4,3 || 2,1
// 9 , 10 || 8,7||6
// 9 , 10 || 7,8||6

// 6,7,8,9,10 || 1,2,3,4,5
// 1,2


// 3, 4 ||  1, 2
// 1, 4 ||  3, 2
// 1, 3, 4, 2