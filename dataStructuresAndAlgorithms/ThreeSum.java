package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int k = sc.nextInt();
		sc.close();
		System.out.println(threeSum(arr, n, k));

	}

	static List<List<Integer>> threeSum(int[] arr, int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(arr);
		for (int i = 0; i < n-1; i++) {
			int find = k - arr[i];
			int left = i+1;
			int right = n - 1;
			while (left < right && arr[left] < find) {
				if (arr[left] + arr[right] == find) {
					List<Integer> t = new ArrayList<>();
					t.add(arr[i]);
					t.add(arr[left]);
					t.add(arr[right]);
					res.add(t);
					left++;
					right--;
				}
				if (arr[left] + arr[right] > find)
					right--;
				else
					left++;
			}
		}

		return res;
	}

}

// Sample Test case 1

//11
//3 5 15 1 2 8 9 7 6 12 17
//20
