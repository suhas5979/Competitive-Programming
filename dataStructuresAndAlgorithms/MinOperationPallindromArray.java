package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MinOperationPallindromArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(minOps(arr, n));

	}

	static int minOps(int[] arr, int n) {
		int res = 0;
		for (int i = 0, j = n - 1; i < j;) {
			if (arr[i] == arr[j]) {
				i++;
				j--;
			}
			if (arr[i] > arr[j]) {
				arr[j - 1] += arr[j];
				j--;
				res++;
			}
			if (arr[j] > arr[i]) {
				arr[i + 1] += arr[i];
				i++;
				res++;
			}
		}
		return res;
	}

}

// Sample Test Case 1

//5
//11 23 45 21 11

// Sample Test Case 2

//6
//18 5 7 10 12 18
