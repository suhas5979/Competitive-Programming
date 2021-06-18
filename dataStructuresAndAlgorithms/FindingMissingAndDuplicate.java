package dataStructuresAndAlgorithms;

import java.util.Scanner;


public class FindingMissingAndDuplicate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		for(int num :find(arr)) {
			System.out.print(num+" ");
		}
	}

	static int[] find(int[] arr) {
		int[] res = new int[2];
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int index = Math.abs(arr[i]) - 1;
			if (arr[index] < 0) {
				res[0] = index +1;
			} else {
				arr[index] = arr[index] * -1;
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] > 0) {
				res[1] = i + 1;
				return res;
			}
		}

		return res;
	}

}
