package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class AlienDictionary {

	public static void main(String[] args) {
		String arr[] = { "baa", "abcd", "abca", "cab" };
		System.out.println(find(arr, arr.length));

	}

	static String find(String[] dict, int n) {
		ArrayList<pair> order = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			check(dict[i], dict[i + 1], order);
		}
		String res = "";
		HashMap<Character, Integer> indegree = new HashMap<>();
		for (pair cur : order) {
			indegree.putIfAbsent(cur.first, 0);
			if (indegree.containsKey(cur.second)) {
				indegree.put(cur.second, indegree.get(cur.second) + 1);
			} else {
				indegree.put(cur.second, 1);
			}
		}
		ArrayList<indegree> t = new ArrayList<>();
		for (Map.Entry<Character, Integer> e : indegree.entrySet()) {
			t.add(new indegree(e.getKey(), e.getValue()));
		}
		Collections.sort(t, (o1, o2) -> {
			return o1.in - o2.in;
		});
		for (int i = 0; i < t.size(); i++) {
			res += t.get(i).node;
		}
		return res;
	}

	static class indegree {
		char node;
		int in;

		indegree(char n, int i) {
			this.in = i;
			this.node = n;
		}
	}

	private static void check(String str1, String str2, ArrayList<pair> order) {
		int ptr1 = 0;
		int ptr2 = 0;
		while (ptr1 < str1.length() && ptr2 < str2.length()) {
			if (str1.charAt(ptr1) != str2.charAt(ptr2)) {
				order.add(new pair(str1.charAt(ptr1), str2.charAt(ptr2)));
				return;
			}
			ptr1++;
			ptr2++;
		}

	}

	static class pair {
		char first, second;

		pair(char f, char s) {
			this.first = f;
			this.second = s;
		}
	}

}

// Test case

//4
//baa 
//abcd 
//abca 
//cab
