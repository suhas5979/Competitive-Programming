package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		sc.close();
		System.out.println(longestCommonSequenceBottomUp(str1, str2,str1.length(),str2.length()));
	}

	static int longestCommon(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		int[][] memo = new int[n1][n2];
		int res = longestCommonSequence(str1, str2, n1, n2, 0, 0, memo);

		for (int[] nums : memo) {
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

		return res;
	}

	static int longestCommonSequence(String str1, String str2, int n1, int n2, int first, int second, int[][] memo) {
		if (first >= n1 || second >= n2) {
			return 0;
		}
		if (memo[first][second] == 0) {
			if (str1.charAt(first) == str2.charAt(second)) {

				memo[first][second] = longestCommonSequence(str1, str2, n1, n2, first + 1, second + 1, memo) + 1;
			} else {
				memo[first][second] = Math.max(longestCommonSequence(str1, str2, n1, n2, first + 1, second, memo),
						longestCommonSequence(str1, str2, n1, n2, first, second + 1, memo));
			}
		}
		return memo[first][second];

	}

	static int longestCommonSequenceBottomUp(String str1, String str2, int n1, int n2) {
		int[][] res = new int[n1 + 1][n2 + 1];
		for (int i = n1 - 1; i >= 0; i--) {
			for (int j = n2 - 1; j >= 0; j--) {
				if(str1.charAt(i) == str2.charAt(j)) {
					res[i][j] = 1 + res[i+1][j+1];
				}else {
					res[i][j] = Math.max(res[i+1][j], res[i][j+1]);
				}
			}
		}

		return res[0][0];

	}

}

// Test Case 1

//aqfhwelkrtyuljhiop
//qzxwmnvertyucvioxcvp
