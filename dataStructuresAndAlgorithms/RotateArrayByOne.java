package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class RotateArrayByOne {

	// Runner
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		sc.close();
		rotate(arr, n);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

	}

	static void rotate(long arr[], int n) {
		long prev = arr[0];
		for (int i = 1; i < n; i++) {
			long cur = arr[i];
			arr[i] = prev;
			prev = cur;
		}
		arr[0] = prev;
	}

}

// Sample Test Case

//10
//1 2 34 56 78 12 23 233 1222 245
