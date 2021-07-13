package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

import builtInDatastructuresTest.UtilityFunctions;

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
		System.out.println(solveKnapsack(profits, weights, capacity));

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

	static int solveKnapsack(int[] profits, int[] weights, int capacity) {
		if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) // Base case
			return 0;

		int numberOfRows = profits.length + 1;// adding a dummy row to avoid array index issues
		int[][] dp = new int[numberOfRows][capacity + 1];// Create a 2D Array to store all the results

		for (int i = 0; i < numberOfRows; i++) { // Insert 0 in 1st column as it is dummy column to avoid array index
													// issues
			dp[i][0] = 0;
		}

		for (int i = 0; i <= capacity; i++) {// Insert 0 in last row as it is dummy column to avoid array index issues
			dp[numberOfRows - 1][i] = 0;
		}
		UtilityFunctions.printArray(dp);
		for (int row = numberOfRows - 2; row >= 0; row--) {
			for (int column = 1; column <= capacity; column++) {
				int profit1 = 0, profit2 = 0;
				if (weights[row] <= column) { // column represents current capacity
					profit1 = profits[row] + dp[row + 1][column - weights[row]]; // Taking current element
				}
				profit2 = dp[row + 1][column]; // Not taking current element
				dp[row][column] = Math.max(profit1, profit2);
			}
		} // end of loop
		UtilityFunctions.printArray(dp);
		return dp[0][capacity];
	}// end of method

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
