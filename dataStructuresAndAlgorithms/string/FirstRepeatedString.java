package dataStructuresAndAlgorithms.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class FirstRepeatedString {

	public static void main(String[] args) {

		String[] a = { "aaa", "bbb", "ccc", "aaa", "aaa", "ddd", "bbb", "ddd", "eee", "aaa", "ccc", "ccc" };

		System.out.println(secFrequent(a, a.length));

	}

	static String secFrequent(String arr[], int N) {
		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			if (map.containsKey(arr[i])) {
				map.replace(arr[i], map.get(arr[i]) + 1);
			} else {
				map.put(arr[i], 1);
			}
		}
		int first = Integer.MIN_VALUE;
		int second = Integer.MIN_VALUE;
		String max = "";
		String secmax = "";
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if (value > first) {
				second = first;
				first = value;
				secmax = max;
				max = key;
				continue;
			}
			if (value > second) {
				second = value;
				secmax = key;
			}
		}
		return secmax;
	}

}




// Illustration

// racecar
// rsdfesdr
