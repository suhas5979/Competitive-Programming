package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Scanner;

public class FirstAndLastOccuranceInSortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int target = sc.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for (long num : find(arr, target)) {
			System.out.print(num + " ");
		}

	}

	static long[] find(long[] arr, int target) {
		long[] res = new long[2];
		res[0] = findFirst(arr, target);
		res[1] = findLast(arr, target);
		return res;
	}

	static long findFirst(long[] arr, int target) {
		int index = -1;
		int right = arr.length - 1;
		int left = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target)
				index = mid;
			if (arr[mid] >= target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return index;
	}

	static long findLast(long[] arr, int target) {
		int index = -1;
		int right = arr.length - 1;
		int left = 0;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (arr[mid] == target)
				index = mid;
			if (arr[mid] <= target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return index;
	}

}

//12
//5
//1 2 3 4 5 5 5 5 5 6 7 8