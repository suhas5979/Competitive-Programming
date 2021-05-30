package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class NumberOfJumps {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(numJumps(arr, n, 0));
	}

	static int numJumps(int[] arr, int n, int cur) {
		if (arr[0] == 0)
			return 0;
		if (cur + arr[cur] >= n - 1)
			return 1;
		int max = 0;
		for (int i = cur; i < n && i <= cur + arr[cur]; i++) {
			if (max < arr[i]) {
				max = i;
			}
		}
		return 1 + numJumps(arr, n, max);
	}

}

// Sample Test Case 1

//8
//1 3 7 8 9 2 5 4
