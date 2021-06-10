package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MaxProductSubarray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

	}

//	static int maxProduct(int[] arr, int n) {
//		int product = 1;
//		int maxProduct = Integer.MIN_VALUE;
//		for (int i = 0; i < n; i++) {
//			product *= arr[i];
//			if(product ==0) {
//				product = 1;
//				continue;
//			}
//			
//		}
//	}

}
