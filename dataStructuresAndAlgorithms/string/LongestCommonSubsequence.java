package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class LongestCommonSubsequence {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		sc.close();
		System.out.println(longest(str1, str2));
	}

	static String longest(String str1, String str2) {
		int n1 = str1.length();
		int n2 = str2.length();
		int start = 0;
		String res = "";
		for (int i = 0; i < n1; i++) {
			char ch = str1.charAt(i);
			for (int j = start; j < n2; j++) {
				if (ch == str2.charAt(j)) {
					start = j + 1;
					res += ch;
					j = n2;
				}
			}
		}
		return res;
	}

}
