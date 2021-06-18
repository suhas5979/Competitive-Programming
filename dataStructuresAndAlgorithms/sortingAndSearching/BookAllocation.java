package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class BookAllocation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(allocate(arr, k));

	}

	static int allocate(int[] books, int k) {
		int n = books.length;
		int res = Integer.MAX_VALUE;
		int left = Integer.MAX_VALUE;
		int right = 0;
		for (int i = 0; i < n; i++) {
			left = Math.min(left, books[i]);
			right += books[i];
		}
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (isAllocationPossible(books, k, mid)) {
				res = Math.min(res, mid);
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return res;
	}

	private static boolean isAllocationPossible(int[] books, int k, int mid) {
		int n = books.length;
		int studentRequired = 1;
		int cur = 0;
		int i;
		for (i = 0; i < n; i++) {
			if(books[i] > mid)
				return false;
			if (cur + books[i] > mid) {
				studentRequired++;
				cur = books[i];
			} else {
				cur += books[i];
			}
		}

		if (studentRequired > k) {
			return false;
		}
		return true && i==n ;
	}

}

//8
//6
//250 74 159 181 23 45 129 174
