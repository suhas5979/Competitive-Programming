package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class LongesCommonSubsequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		sc.close();
		System.out.println(longest(str1, str2));

	}

	static String longest(String str1, String str2) {
		return longestCommonSub(str1, str2, str1.length(), str2.length(), 0, 0, "");
	}

	static String longestCommonSub(String str1, String str2, int n1, int n2, int p1, int p2, String cur) {
		if (p1 == n1 || p2 == n2) {
			return cur;
		}
		if (str1.charAt(p1) == str2.charAt(p2)) {
			return longestCommonSub(str1, str2, n1, n2, p1 + 1, p2 + 1, cur + str1.charAt(p1));
		} else {
			String s1 = longestCommonSub(str1, str2, n1, n2, p1 + 1, p2, cur);
			String s2 = longestCommonSub(str1, str2, n1, n2, p1, p2 + 1, cur);
			return s1.length() > s2.length() ? s1 : s2;
		}
	}

}
