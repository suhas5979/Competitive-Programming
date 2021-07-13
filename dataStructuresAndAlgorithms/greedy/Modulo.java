package dataStructuresAndAlgorithms.greedy;

import java.util.Arrays;

public class Modulo {

	public static void main(String[] args) {
		
		System.out.println((int)1e9+7);
	}

	int Maximize(int arr[], int n) {
		int mod = (int) 1e9 + 7;
		Arrays.sort(arr);
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum = (sum + (long) arr[i] * i) % mod;
		}
		return (int) sum;
	}

}
