package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class CountInversions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(countInversions(arr, n));

	}

	static int countInversions(int[] arr, int n) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for(int j=i+1;j<n;j++) {
				if(arr[i] > arr[j]) {
					count++;
				}
			}
		}
		return count;
	}

}
