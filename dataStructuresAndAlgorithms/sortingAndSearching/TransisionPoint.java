package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Scanner;

public class TransisionPoint {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(transitionPoint(arr, n));

	}

	static int transitionPoint(int arr[], int n) {
		if (n == 1)
			return arr[0] == 1 ? 0 : -1;
		if (arr[0] == arr[n - 1])
			return arr[0] == 0 ? -1 : 0;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (mid < n - 1 && arr[mid] < arr[mid + 1])
				return mid + 1;
			if (mid > 0 && arr[mid] > arr[mid - 1])
				return mid;
			else if (arr[mid] < arr[right]) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}

}
