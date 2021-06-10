package dataStructuresAndAlgorithms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class FindAllPairWithGivenSum {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(findAll(arr, n, k));

	}

	static int findAll(int[] arr, int n,int k) {
		int count = 0;
		HashMap<Integer,Integer> freq = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int toFind = k - arr[i];
			if(toFind  < 0) continue;
			
			if (freq.containsKey(toFind)) {
				count += freq.get(toFind);
			}
			freq.put(arr[i], freq.getOrDefault(arr[i], 0)+ 1);
		}

		return count;
	}

}
