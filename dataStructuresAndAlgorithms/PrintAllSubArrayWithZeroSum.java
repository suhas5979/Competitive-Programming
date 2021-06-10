package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PrintAllSubArrayWithZeroSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(findAll(arr, n));

	}

	static ArrayList<ArrayList<Integer>> findAll(int[] arr, int n) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		// to store sum with corresponding index
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (arr[i] == 0) {
				ArrayList<Integer> t = new ArrayList<>();
				t.add(arr[i]);
				res.add(t);
			} else if (sum == 0) {
				ArrayList<Integer> t = new ArrayList<>();
				for (int k = 0; k <= i; k++) {
					t.add(arr[k]);
				}
				res.add(t);
			} else if (map.containsKey(arr[i])) {
				int start = map.get(arr[i]);
				ArrayList<Integer> t = new ArrayList<>();
				for (int k = start; k <= i; k++) {
					t.add(arr[k]);
				}
				res.add(t);
			}
			map.put(sum, i);
		}

		return res;
	}

}
