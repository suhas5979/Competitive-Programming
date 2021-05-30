package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumberDivisibleByThree {

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
		System.out.println(divisible(arr, n, k));

	}

	static List<List<Integer>> divisible(int[] arr, int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		int sum = 0;
		for (int i = 0; i < k; i++) {
			sum += digitSum(arr[i]);
		}
		for (int i = k; i < n; i++) {
			sum += digitSum(arr[i]) - digitSum(i - k);
			if (sum % 3 == 0) {
				List<Integer> t = new ArrayList<>();
				for (int j = 0; j < k; j++) {
					t.add(arr[i - j - 1]);
				}
				res.add(t);
			}
		}
		return res;
	}

	static int digitSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}

}

// Sample Test case 1

//10
//2 34 34 46 1 23 6 87 9 16
//4
