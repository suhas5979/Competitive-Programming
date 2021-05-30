package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class LongestPallindrom {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = str.length();
		sc.close();
		int[][] memo = new int[n + 1][n + 1];

		System.out.println(longestPalindrom(str, 0, n - 1, memo));
	}

	static int longestPalindrom(String str, int start, int end) {
		if (start > end)
			return 0;
		if (start == end)
			return 1;
		int c1 = 0, c2, c3;
		if (str.charAt(start) == str.charAt(end)) {
			int rem = end - start - 1;
			if (rem == longestPalindrom(str, start + 1, end - 1)) {
				c1 = 2 + longestPalindrom(str, start + 1, end - 1);
			}
		}
		c2 = longestPalindrom(str, start + 1, end);
		c3 = longestPalindrom(str, start, end - 1);
		return Math.max(c1, Math.max(c2, c3));
	}

	static int longestPalindrom(String str, int start, int end, int[][] memo) {
		if (start > end)
			return 0;
		if (start == end)
			return 1;
		int c1 = 0, c2, c3;
		if (memo[start][end] == 0) {
			if (str.charAt(start) == str.charAt(end)) {
				int rem = end - start - 1;
				if (rem == longestPalindrom(str, start + 1, end - 1, memo)) {
					c1 = 2 + rem;
				}
			}
			c2 = longestPalindrom(str, start + 1, end, memo);
			c3 = longestPalindrom(str, start, end - 1, memo);
			memo[start][end] = Math.max(c1, Math.max(c2, c3));
		}
		return memo[start][end];

	}

}

// Sample Test Case 1

//abcsracecaridsfsfsfsggdfggdsgsgsdsdgdgsdgsdgsdgdgsdgsgddsgdgdgsdsgs
