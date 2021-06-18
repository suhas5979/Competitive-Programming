package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class IsomorphicStrings {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		sc.close();
		System.out.println(isIsomorphic(str1, str2));
	}

	static boolean isIsomorphic(String str1, String str2) {
		int n = str1.length();
		if (n != str2.length())
			return false;

		int[] countChars1 = new int[26];
		int[] countChars2 = new int[26];

		for (int i = 0; i < n; i++) {
			countChars1[str1.charAt(i) - 'a']++;
			countChars2[str2.charAt(i) - 'a']++;

			if (countChars1[str1.charAt(i) -'a'] != countChars2[str2.charAt(i)-'a']) {
				return false;
			}
		}
		return true;
	}

}
