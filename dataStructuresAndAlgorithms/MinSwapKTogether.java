package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MinSwapKTogether {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		System.out.println(minSwap(arr, n, k));

	}

	static int minSwap(int arr[], int n, int k) {
		int goods = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] <= k)
				goods++;
		}
		int bads = 0;
		for (int i = 0; i < goods; i++) {
			if (arr[i] > k)
				bads++;
		}
		int ans = bads;
		for (int i = 0, j = goods; j < n; i++, j++) {
			if (arr[i] <= k)
				bads++;
			if (arr[j] <= k)
				bads--;
			ans = Math.min(ans, bads);

		}

		return goods - bads;
	}

}
