package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Scanner;

public class SmallestFactorialNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		System.out.println(smallestFactorial(n));

	}

	static int smallestFactorial(int n) {
		int right = n * 5;
		int left = 1;
		int res = Integer.MAX_VALUE;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (isPossible(mid, n)) {
				res = Math.min(res, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return res;
	}

	static boolean isPossible(int mid, int n) {
		int res = 0;
		int t = mid;
		while (t != 0) {
			res = res + t / 5;
			t = t / 5;
		}
		return res >= n;
	}

}
