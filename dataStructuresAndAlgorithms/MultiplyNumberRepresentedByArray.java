package dataStructuresAndAlgorithms;

import java.util.ArrayList;

public class MultiplyNumberRepresentedByArray {

	public static void main(String[] args) {

		ArrayList<Integer> res = new ArrayList<>();
		int n = 500;
		int[] arr = new int[n];
		arr[n - 1] = 1;
		for (int i = 2; i <= 5; i++) {
			multiplyNumber(arr, n, i);
		}
		boolean flag = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0 && flag) {
				continue;
			} else if (arr[i] > 0) {
				flag = false;
			}
			res.add(arr[i]);
		}
		System.out.println(res);
	}

	static void multiplyNumber(int[] arr, int n, int x) {
		int carry = 0;
		for (int i = n - 1; i >= 0; i--) {
			int cur = arr[i] * x + carry;
			arr[i] = cur % 10;
			carry = cur / 10;
		}
	}

}
