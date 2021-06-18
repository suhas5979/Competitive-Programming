package dataStructuresAndAlgorithms.string;

import java.util.*;

public class PrintGroupOfAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static List<List<String>> Anagrams(String[] string_list) {
		int n = string_list.length;
		boolean[] flags = new boolean[n];
		List<List<String>> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			if (flags[i])
				continue;
			flags[i] = true;
			ArrayList<String> t = new ArrayList<>();
			t.add(string_list[i]);
			for (int j = i + 1; j < n; j++) {
				if (flags[j]) {
					continue;
				} else if (isAna(string_list[i], string_list[j])) {
					t.add(string_list[j]);
					flags[j] = true;
				}
			}
			res.add(t);
		}
		return res;
	}

	static boolean isAna(String str1, String str2) {
		if (str1.length() != str2.length()) {
			return false;
		}
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char cur = str1.charAt(i);
			if (map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
			} else {
				map.put(cur, 1);
			}
		}
		for (int i = 0; i < str1.length(); i++) {
			char cur = str2.charAt(i);
			int count = map.getOrDefault(cur, 0);
			if (count > 0) {
				map.put(cur, count - 1);
			} else {
				return false;
			}
		}
		return true;
	}

}
