package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MedianOfTwoSortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] arr2 = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(median(arr, arr2, n, m));
	}

	static int median(int[] arr1, int[] arr2, int n1, int n2) {
		int total = n1 + n2;
		int mid = total / 2;
		int ptr1 = 0;
		int ptr2 = 0;
		int count = 0;
		while (ptr1 < n1 && ptr2 < n2) {
			if (arr1[ptr1] > arr2[ptr2]) {
				ptr2++;
			} else if (arr1[ptr1] <= arr2[ptr2]) {
				ptr1++;
			}
			count++;
			if (count == mid - 1) {
				if (total % 2 == 0)
					return (arr1[ptr1] + arr2[ptr2]) / 2;
			} else if (count == mid) {
				if (total % 2 != 0) {
					return Math.min(arr1[ptr1], arr2[ptr2]);
				}
			}
		}
		while (ptr1 < n1) {
			count++;
			ptr1++;
			if (count == mid - 1) {
				if (total % 2 == 0)
					return (arr1[ptr1] + arr1[ptr1 + 1]) / 2;
			} else if (count == mid) {
				if (total % 2 != 0) {
					return arr1[ptr1];
				}
			}
		}
		while (ptr2 < n2) {
			count++;
			ptr2++;
			if (count == mid - 1) {
				if (total % 2 == 0)
					return (arr2[ptr2] + arr2[ptr2 + 1]) / 2;
			} else if (count == mid) {
				if (total % 2 != 0) {
					return arr2[ptr2];
				}
			}
		}
		return -1;
	}

}

// Test Case 1

//5 5
//-5 3 6 12 15
//-12 -10 -6 -3 4

// Test Case 2

//2 5
//-9 -6
//2 4 6 8 12

// Test Case 3

//5 3
//-4 2 5 8 12
//2 3 6
