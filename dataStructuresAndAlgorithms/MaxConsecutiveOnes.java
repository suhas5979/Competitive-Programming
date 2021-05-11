package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MaxConsecutiveOnes {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		System.out.println(maxOnes(arr));
	}

	static int maxOnes(int[] arr) {
		int n = arr.length;
		int max = 0;
		int curMax = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 1) {
				curMax++;
				max = Math.max(curMax, max);
			} else {
				curMax = 0;
			}
		}

		return max;

	}

}
