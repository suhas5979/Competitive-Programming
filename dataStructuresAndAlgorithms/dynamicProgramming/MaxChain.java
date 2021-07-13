package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

import builtInDatastructuresTest.UtilityFunctions;

public class MaxChain {
	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public String toString() {
			return " [" + x + "," + y + "]";
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Pair arr[] = new Pair[n];
		for (int i = 0; i < n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[i] = new Pair(a, b);
		}
		sc.close();
		System.out.println(maxChainLengthBottom(arr, n));

	}

	static int maxChainLength(Pair arr[], int n) {
		Arrays.sort(arr, (o1, o2) -> {
			return o1.x - o2.x;
		});
		return maxChain(arr, 0, 0);
	}

	static int maxChain(Pair arr[], int cur, int length) {
		if (arr.length == cur)
			return 0;
		int ans = 0;
		if (arr[cur].x > length) {
			ans = 1 + maxChain(arr, cur + 1, arr[cur].y);
		}
		int ansDoNotSelect = maxChain(arr, cur + 1, length);
		return Math.max(ans, ansDoNotSelect);
	}

	static int maxChainLengthBottom(Pair arr[], int n) {
		int i, j, max = 0;
		int mcl[] = new int[n];

		/*
		 * Initialize MCL (max chain length) values for all indexes
		 */
		for (i = 0; i < n; i++)
			mcl[i] = 1;

		/*
		 * Compute optimized chain length values in bottom up manner
		 */
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++)
				if (arr[i].x > arr[j].y && mcl[i] < mcl[j] + 1)
					mcl[i] = mcl[j] + 1;
			UtilityFunctions.printArray(mcl);
		}

		// mcl[i] now stores the maximum
		// chain length ending with pair i

		/* Pick maximum of all MCL values */
		for (i = 0; i < n; i++)
			if (max < mcl[i])
				max = mcl[i];

		return max;
	}

}

// Test Case

//5
//5 24 39 60 15 28 27 40 50 90
