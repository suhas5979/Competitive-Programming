package dataStructuresAndAlgorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class SmallestWindowHavingAllCharacters {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(smallestWindow(str));

	}

	static String smallestWindow(String str) {
		if (str.length() == 1) {
			return ""+str.charAt(0);
		}
		int n = str.length();
		HashSet<Character> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(str.charAt(i));
		}
		int total = set.size();
		int count = 1;
		int left = 0;
		String res = "";
		HashMap<Character, Integer> freq = new HashMap<>();
		freq.put(str.charAt(0), 1);
		int min = Integer.MAX_VALUE;
		for (int right = 1; right < n; right++) {
			if (!freq.containsKey(str.charAt(right))) {
				count++;
				freq.put(str.charAt(right), 1);
			} else {
				freq.put(str.charAt(right), freq.get(str.charAt(right)) + 1);
			}
			int len = right - left + 1;
			if (count == total && len < min) {
				min = Math.min(right - left + 1, min);
				res = str.substring(left, right + 1);
			}
			while (left < right && freq.get(str.charAt(left)) > 1) {
				freq.put(str.charAt(left), freq.get(str.charAt(left)) - 1);
				left++;
				len = right - left + 1;
				if (count == total && len < min) {
					min = Math.min(right - left + 1, min);
					res = str.substring(left, right + 1);
				}
			}
		}

		return res;
	}

}
