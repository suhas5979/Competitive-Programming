package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class NumWaysCoinExchange {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int coins[] = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = sc.nextInt();
		}
		int amt = sc.nextInt();
		sc.close();
		int t[][] = new int[n+1][n+1];
		System.out.println(coinExchange(coins, n - 1, amt,t));

	}

	static int coinExchange(int[] coins, int n, int amt,int[][] t) {
		if (amt == 0)
			return 1;
		if (amt < 0)
			return 0;
		if (n < 0)
			return 0;
		return coinExchange(coins, n, amt - coins[n],t) + coinExchange(coins, n - 1, amt,t);
	}

}

//3
//1 2 3
//4