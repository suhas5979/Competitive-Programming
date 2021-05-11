package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GenerateSubsets {

	// Runner
	public static void main(String[] args) {

		int arr[] = new int[] { 1, 2, 3 };
		List<List<Integer>> res = new ArrayList<>();
		generate(arr, 0, new ArrayList<>(), res);
		System.out.println(res);

	}

	public static void generate(int[] arr, int n, List<Integer> set, List<List<Integer>> result) {
		if (n == arr.length) {
			result.add(new ArrayList<>(set));
			return;
		}

		set.add(arr[n]);
		generate(arr, n + 1, set, result);
		set.remove(set.size() - 1);
		generate(arr, n + 1, set, result);

	}

}
