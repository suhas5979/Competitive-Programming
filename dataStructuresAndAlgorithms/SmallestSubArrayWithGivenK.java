package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class SmallestSubArrayWithGivenK {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(smallest(arr, n, k));

	}

	static int smallest(int[] arr, int n, int k) {
		int sum = 0;
		int max = Integer.MAX_VALUE;
		int left = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			count++;
			while(sum >= k) {
				max = Math.min(max, count);
				sum -= arr[left];
				left++;
				count--;
			}
		}
		return max;
	}

}
//10
//14
//8 2 4 7 2 4 8 6 -1 14
