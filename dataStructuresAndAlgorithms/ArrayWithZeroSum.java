package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ArrayWithZeroSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long arr[] = new long[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextLong();
		}
		sc.close();
		System.out.println(findSubArrays(arr, n));
	}

	static int find(long[] arr, int n) {
		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				count++;
			sum += arr[i];
			if (map.containsKey(sum)) {
				int freq = map.get(sum);
				if (sum != 0)
					count += freq;
				else
					count++;
				map.put(sum, freq + 1);
			} else {
				map.put(sum, 1);
			}
		}
		return count;
	}

	static int findSubArrays(long[] arr, int n) {
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
		int count = 0;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0)
				count++;
			ArrayList<Integer> al = new ArrayList<>();
			if (map.containsKey(sum)) {
				al = map.get(sum);
				for (int j = 0; j < al.size(); j++) {
					count++;
				}
			}
			al.add(i);
			System.out.println(al);
			map.put(sum, al);
		}
		return count;
	}
}
