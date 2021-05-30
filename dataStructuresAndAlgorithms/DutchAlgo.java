package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class DutchAlgo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		sort(arr,n);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}

	}

	static void sort(int[] arr, int n) {
		int start = 0;
		int mid = 0;
		int end = n - 1;
		while (mid < end) {
			if (arr[mid] == 0) {
				int temp = arr[start];
				arr[start] = arr[mid];
				arr[mid] = temp;
				mid++;
				start++;
			}
			if (arr[mid] == 2) {
				int temp = arr[end];
				arr[end] = arr[mid];
				arr[mid] = temp;
				end--;
			}
			if (arr[mid] == 1)
				mid++;
		}
	}

}

// Sample Test Case

//10
//1 0 1 2 2 2 1 0 0 1




