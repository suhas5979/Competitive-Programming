package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.List;
import java.util.Scanner;

public class NumberOfWaysToGet {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		int[] memo = new int[n + 1];
		System.out.println(numWays(n));

	}

	static int numWays(int n, int[] memo) {
		System.out.println(" n= " + n);
		if (n <= 2)
			return 1;
		if (n == 3)
			return 2;
		if (memo[n] == 0) {
			int n1 = numWays(n - 1, memo);
			int n2 = numWays(n - 3, memo);
			int n3 = numWays(n - 4, memo);
			memo[n] = n1 + n2 + n3;
		}

		return memo[n];
	}

	static int numWays(int n) {
		System.out.println(" n= " + n);
		if (n <= 2)
			return 1;
		if (n == 3)
			return 2;
		int n1 = numWays(n - 1);
		int n2 = numWays(n - 3);
		int n3 = numWays(n - 4);
		return n1 + n2 + n3;
	}

}
