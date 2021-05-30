package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class ZeroOneKnapsack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int capacity = sc.nextInt();
		int profits[] = new int[n];
		int weights[] = new int[n];
		for (int i = 0; i < n; i++) {
			profits[i] = sc.nextInt();
		}
		for (int i = 0; i < n; i++) {
			weights[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(maxProfit(profits, weights, 0, capacity));

	}

	static int maxProfit(int[] prices, int[] weights, int pos, int capacity) {
		if (pos > prices.length)
			return 0;
		if (pos == prices.length - 1 && weights[pos] <= capacity)
			return prices[pos];
		if (weights[pos] <= capacity) {
			int curInclude = prices[pos] + maxProfit(prices, weights, pos + 1, capacity - weights[pos]);
			int curSkip = maxProfit(prices, weights, pos + 1, capacity);
			return Math.max(curInclude, curSkip);

		}
		return 0;
	}

}

// Sample Test case 1

//4
//7
//31 26 72 17
//3 1 5 2

//Sample Test case 1

//8
//12
//31 26 72 17 32 22 13 21
//3 1 5 2 3 1 4 5


