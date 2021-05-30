package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class ShiftNegetives {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		shiftNegetives(arr, n);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}

	}

	static void shiftNegetives(int[] arr, int n) {
		int left = 0;
		int right = n - 1;
		while (left < right) {
			if (arr[left] < 0)
				left++;
			if(arr[right] > 0) right--;
			if(arr[left] >0 && arr[right] <0) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				right--;
				left++;
			}
		}
	}

}

// Sample Test Case 1

//10
//4 -2 23 -12 -24 -32 23 3 -1 10
