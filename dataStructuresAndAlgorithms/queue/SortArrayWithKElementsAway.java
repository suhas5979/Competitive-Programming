package dataStructuresAndAlgorithms.queue;

import java.util.*;
import java.lang.*;
import java.io.*;

public class SortArrayWithKElementsAway {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			sort(arr, n, k);
			for (int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
		}
	}

	static void sort(int[] arr, int n, int k) {
		PriorityQueue<Integer> q = new PriorityQueue<>();
		int i = 0;
		int start = 0;
		while (i < n) {
			while (i < n && q.size() != k)
				q.add(arr[i++]);
			while (!q.isEmpty()) {
				arr[start++] = q.poll();
			}
		}
	}
}
