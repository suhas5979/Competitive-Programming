package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class LongestPalindromicSubString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(longest(str, str.length()));

	}

	static String longest(String str, int n) {
		if (n == 0)
			return "";
		if (n == 1)
			return str.charAt(0) + "";
		int max = 0;
		int count;
		int ptr1=0;
		int ptr2=0;
		for (int i = 1; i < n; i++) {
			int start = i - 1;
			int end = i;
			count = 0;
			while (start >= 0 && end < n && str.charAt(start) == str.charAt(end)) {
				count += 2;
				start--;
				end++;
			}
			if (max < count) {
				max = count;
				ptr1 = start + 1;
				ptr2 = end - 1;
			}
			count = 1;
			start = i - 1;
			end = i + 1;
			while (start >= 0 && end < n && str.charAt(start) == str.charAt(end)) {
				count += 2;
				start--;
				end++;
			}
			if (max < count) {
				max = count;
				ptr1 = start + 1;
				ptr2 = end - 1;
			}

		}
		System.out.println(max);
		return str.substring(ptr1, ptr2+1);
	}

}
