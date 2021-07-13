package dataStructuresAndAlgorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;

public class ChocolateDistribution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public long findMinDiff(ArrayList<Long> a, long n, long m) {
		int left = 0;
		int right = (int) m - 1;
		long diff = 0;
		Collections.sort(a);
		diff = a.get(right) - a.get(left);
		for (int i = left + 1, j = right + 1; j < n; i++, j++) {
			long cur = a.get(j) - a.get(i);
			diff = Math.min(diff, cur);
		}
		return diff;
	}

}
