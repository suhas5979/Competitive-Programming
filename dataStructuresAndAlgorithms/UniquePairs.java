package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class UniquePairs {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		find(arr, n);

	}

	static void find(int[] arr, int n) {
		HashMap<Integer, ArrayList<pair>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int sum = arr[i] + arr[j];
				if (map.containsKey(sum)) {
					map.get(sum).add(new pair(arr[i], arr[j]));
				} else {
					map.put(sum, new ArrayList<>());
					map.get(sum).add(new pair(arr[i], arr[j]));
				}
			}
		}
		for (Map.Entry<Integer, ArrayList<pair>> entry : map.entrySet()) {
			if (entry.getValue().size() == 2) {
				System.out.println(entry.getKey() + " =>" + entry.getValue());
			}

		}
	}

	static class pair {
		int first, second;

		pair(int f, int s) {
			this.first = f;
			this.second = s;
		}

		@Override
		public String toString() {
			return "[" + first + "," + second + "]";
		}
	}

}
