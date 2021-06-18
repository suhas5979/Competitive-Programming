package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Arrays;
import java.util.Scanner;

public class FindTripletsWithSumSmallerThanValue {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(findTripletsEfficient(arr, x));

	}

	static int findTriplets(int[] arr, int x) {
		int n = arr.length;
		int count = 0;
		Arrays.sort(arr);
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int find = x - (arr[i] + arr[j]);
				for (int k = j + 1; k < n && arr[k] < find; k++)
					count++;

			}
		}

		return count;
	}

	static int findTripletsEfficient(int[] arr, int x) {
		int n = arr.length;
		int count = 0;
		for (int i = 0; i < n; i++) {
			int left = i + 1, right = n - 1;
			while (left < right) {
				if (arr[left] + arr[right] + arr[i] >= 12)
					right--;
				else {
					count += (right - left);
					left++;
				}
			}
		}
		return count;
	}

}
