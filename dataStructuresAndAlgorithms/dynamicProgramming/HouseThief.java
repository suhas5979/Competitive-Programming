package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class HouseThief {

	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int[] memo = new int[n + 1];

		System.out.println(maxProfitBottomUp(arr));

	}

	static int maxProfitFromHouse(int n, int[] houses, int[] memo) {
		count++;
		if (n == houses.length - 1)
			return houses[n];
		if (n >= houses.length)
			return 0;
		if (memo[n] == 0) {
			int current = houses[n] + maxProfitFromHouse(n + 2, houses, memo);
			int currentSkip = maxProfitFromHouse(n + 1, houses, memo);
			memo[n] = Math.max(current, currentSkip);
		}

		return memo[n];
	}

	static int maxProfitFromHouse(int n, int[] houses) {
		count++;
		if (n == houses.length - 1)
			return houses[n];
		if (n >= houses.length)
			return 0;
		int current = houses[n] + maxProfitFromHouse(n + 2, houses);
		int currentSkip = maxProfitFromHouse(n + 1, houses);
		return Math.max(current, currentSkip);
	}

	static int maxProfitBottomUp(int[] houses) {
		int n = houses.length;
		int[] res = new int[n + 1];
		res[n] = 0;
		res[n - 1] = houses[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			res[i] = Math.max(houses[i] + res[i + 2], res[i + 1]);
		}
		for (int i = n - 2; i >= 0; i--) {
			res[i] = Math.max(houses[i] + res[i + 2], res[i + 1]);
		}
		return res[0];
	}

}

// Sample Test Case 1

//30
//6 7 1 30 8 2 4 23 3 8 10 55 32 14 10 6 7 1 30 8 2 4 23 3 8 10 55 32 14 10
