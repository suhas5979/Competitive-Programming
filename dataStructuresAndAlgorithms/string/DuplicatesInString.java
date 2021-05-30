package dataStructuresAndAlgorithms.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DuplicatesInString {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int hash[] = new int[256];
		sc.close();
//		findDuplicates(str, hash);

		System.out.println(findDuplicates(str));

	}

	static void findDuplicates(String str, int[] hash) {
		int n = str.length();
		for (int i = 0; i < n; i++) {
			hash[str.charAt(i)]++;
		}
		for (int i = 0; i < hash.length; i++) {
			if (hash[i] > 1) {
				char cur = (char) (i);
				System.out.println(cur + " =>" + hash[i]);
			}

		}
	}

	static Map<Character, Integer> findDuplicates(String str) {
		Map<Character, Integer> freq = new HashMap<>();
		int n = str.length();
		for (int i = 0; i < n; i++) {
			char cur = str.charAt(i);
			if (freq.containsKey(cur)) {
				freq.replace(str.charAt(i), freq.get(cur) + 1);
			} else {
				freq.put(cur, 1);
			}

		}
		return freq;
	}

}

// Sample Test case 1

//dsgfgerrhfdfbcvxcv
