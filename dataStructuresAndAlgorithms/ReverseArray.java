package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class ReverseArray {

	// Reverse Array
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		reverseArray(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();

	}

	static void reverseArray(int[] arr, int n) {
		int left = 0;
		int right = n - 1;
		while (left < right) {
			int temp = arr[left];
			arr[left] = arr[right];
			arr[right] = temp;
			left++;
			right--;
		}
	}

}

// Sample Test case 1

//10 
//4 6 5 32 75 3 1 44 12 7
