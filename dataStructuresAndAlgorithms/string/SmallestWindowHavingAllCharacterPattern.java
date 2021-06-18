package dataStructuresAndAlgorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SmallestWindowHavingAllCharacterPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String pattern = sc.nextLine();

		sc.close();
		System.out.println(findSubString(str, pattern));

	}

	static String findSubString(String str, String pat) {
		int len1 = str.length();
		int len2 = pat.length();

		if (len1 < len2) {
			return "";
		}

		int hash_pat[] = new int[256];
		int hash_str[] = new int[256];
		for (int i = 0; i < len2; i++)
			hash_pat[pat.charAt(i)]++;

		int start = 0;
		int start_index = -1;
		int min_len = Integer.MAX_VALUE;

		int count = 0;
		for (int j = 0; j < len1; j++) {

			hash_str[str.charAt(j)]++;

			if (hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)])
				count++;
			if (count == len2) {

				while (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] || hash_pat[str.charAt(start)] == 0) {

					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)])
						hash_str[str.charAt(start)]--;
					start++;
				}
				int len = j - start + 1;
				if (min_len > len) {
					min_len = len;
					start_index = start;
				}
			}
		}
		if (start_index == -1) {
			return "";
		}

		return str.substring(start_index, start_index + min_len);
	}

}
