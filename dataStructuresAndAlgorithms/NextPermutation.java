package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class NextPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		nextPermutation(arr, n);
		for(int num :arr) {
			System.out.print(num + " ");
		}

	}

	static void nextPermutation(int[] arr, int n) {
		int pivot = -1;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				pivot = i;
			}
		}
		if (pivot == -1) {
			int left = 0;
			int right = n - 1;
			while (left < right) {
				int t = arr[left];
				arr[left] = arr[right];
				arr[right] = t;
				left++;
				right--;
			}
			return;
		}
		int pivot2 = -1;
		for (int i = 0; i < n; i++) {
			if (arr[i] > arr[pivot]) {
				pivot2 = i;
			}
		}
		System.out.println(arr[pivot]);
		int temp = arr[pivot];
		arr[pivot] = arr[pivot2];
		arr[pivot2] = temp;
		int left = pivot + 1;
		int right = n - 1;
		while (left < right) {
			int t = arr[left];
			arr[left] = arr[right];
			arr[right] = t;
			left++;
			right--;
		}
	}

}

// Sample  1 2 5 4 3

// Test Case 1

//5
//2 1 3 5 4
