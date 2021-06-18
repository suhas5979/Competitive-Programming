package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int arr2[] = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		mergeTwoSorted(arr1, arr2, n, m);
		for (int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < m; i++) {
			System.out.print(arr2[i] + " ");
		}

	}

	static void merge(int[] arr1, int n, int[] arr2, int m) {
		for (int i = m - 1; i >= 0; i--) {
			if (arr1[n - 1] > arr2[i]) {
				int temp = arr1[n - 1];
				arr1[n - 1] = arr2[i];
				arr2[i] = temp;
				int ptr = n - 1;
				while (ptr > 0 && arr1[ptr] < arr1[ptr - 1]) {
					int temp2 = arr1[ptr];
					arr1[ptr] = arr1[ptr - 1];
					arr1[ptr - 1] = temp2;
					ptr--;
				}
			}
		}
	}

	static void merge2(int[] arr1, int n, int[] arr2, int m) {
		for (int i = m - 1; i >= 0; i--) {
			int j;
			int last = arr1[n - 1];
			for (j = n - 2; j >= 0 && arr1[j] > arr2[i]; j--) {
				arr1[j + 1] = arr1[j];
			}
			if (j != n - 2 && arr2[i] < last) {
				arr1[j + 1] = arr2[i];
				arr2[i] = last;
			}

		}
	}

	private static int nextGap(int gap) {
		if (gap <= 1)
			return 0;
		return (gap / 2) + (gap % 2);
	}

	private static void mergeTwoSorted(int[] arr1, int[] arr2, int n, int m) {
		int i, j, gap = n + m;
		for (gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {

			for (i = 0; i + gap < n; i++)
				if (arr1[i] > arr1[i + gap]) {
					int temp = arr1[i];
					arr1[i] = arr1[i + gap];
					arr1[i + gap] = temp;
				}
			for (j = gap > n ? gap - n : 0; i < n && j < m; i++, j++)
				if (arr1[i] > arr2[j]) {
					int temp = arr1[i];
					arr1[i] = arr2[j];
					arr2[j] = temp;
				}

			if (j < m) {
				for (j = 0; j + gap < m; j++)
					if (arr2[j] > arr2[j + gap]) {
						int temp = arr2[j];
						arr2[j] = arr2[j + gap];
						arr2[j + gap] = temp;
					}
			}
		}
	}

}

// Sample Test Case 1

//6
//1 3 5 6 11 14
//5 
//0 2 7 8 9
