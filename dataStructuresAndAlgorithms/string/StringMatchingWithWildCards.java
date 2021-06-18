package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class StringMatchingWithWildCards {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		sc.close();
		System.out.println(isMatch(str1, str2));

	}

	static boolean isMatch(String str1, String str2) {
		return isMatch(str1, str2, str1.length(), str2.length());
	}

	static boolean isMatch(String str1, String str2, int n1, int n2) {

		if (n1 == 0 && n2 == 0)
			return true;

		if (n1 > 1 && str1.charAt(0) == '*' && n2 == 0)
			return isMatch(str1.substring(1), str2, n1 - 1, n2);

		if ((n1 > 1 && str1.charAt(0) == '?') || (n1 != 0 && n2 != 0 && str1.charAt(0) == str2.charAt(0)))
			return isMatch(str1.substring(1), str2.substring(1), n1 - 1, n2 - 1);

		if (n1 > 0 && str1.charAt(0) == '*')
			return isMatch(str1.substring(1), str2, n1 - 1, n2) || isMatch(str1, str2.substring(1), n1, n2 - 1);
		return false;
	}

}
