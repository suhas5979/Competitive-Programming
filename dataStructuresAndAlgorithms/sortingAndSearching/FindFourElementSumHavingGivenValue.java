package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class FindFourElementSumHavingGivenValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		ArrayList<Integer> tt = new ArrayList<>();
		tt.add(1);
		System.out.println(tt.get(tt.size() - 1));

		sc.close();
		System.out.println(find(arr, x));
	}

	static ArrayList<ArrayList<Integer>> find(int[] arr, int x) {
		int n = arr.length;
		Comparator<ArrayList<Integer>> comparator = new Comparator<ArrayList<Integer>>() {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				if (a.get(0) > b.get(0)) {
					return 1;
				} else if (a.get(0) == b.get(0)) {
					if (a.get(1) > b.get(1)) {
						return 1;
					} else if (a.get(1) == b.get(1)) {
						if (a.get(2) > b.get(2)) {
							return 1;
						} else if (a.get(2) == b.get(2)) {
							if (a.get(3) > b.get(3)) {
								return 1;
							} else if (a.get(3) == b.get(3)) {
								return 0;
							} else {
								return -1;
							}
						} else {
							return -1;
						}
					} else {
						return -1;
					}
				} else {
					return -1;
				}
			}
		};
		TreeSet<ArrayList<Integer>> res = new TreeSet<>(comparator);
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int left = j + 1, right = n - 1;
				while (left < right) {
					int sum = arr[i] + arr[j] + arr[left] + arr[right];
					if (sum == x) {
						ArrayList<Integer> t = new ArrayList<>();
						t.add(arr[i]);
						t.add(arr[j]);
						t.add(arr[left]);
						t.add(arr[right]);
						res.add(t);
						left++;
						right--;
					} else if (sum > x) {
						right--;
					} else {
						left++;
					}
				}
			}
		}
		return new ArrayList<>(res);
	}
}

// Test Case

//27 179
//88 84 3 51 54 99 32 60 76 68 39 12 26 86 94 39 95 70 34 78 67 1 97 2 17 92 52
