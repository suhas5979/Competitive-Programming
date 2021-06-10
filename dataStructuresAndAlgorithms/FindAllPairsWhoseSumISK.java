package dataStructuresAndAlgorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class FindAllPairsWhoseSumISK {

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

	static ArrayList<ArrayList<Integer>> findAll(int[] arr, int n, int k) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		int sum = 0;
		int i;
		int left = 0;
		ArrayDeque<Integer> pair = new ArrayDeque<>();
		for (i = 0; i < n; i++) {
			sum += arr[i];
			System.out.println("i= " + i + " " + "sum =" + sum);
			pair.addLast(arr[i]);
			if (sum == k) {
				res.add(new ArrayList<Integer>(pair));
			}
			while (sum > k) {
				sum -= pair.removeFirst();
				if (sum == k) {
					res.add(new ArrayList<Integer>(pair));
				}
			}
		}

		return res;
	}

}

//10
//5
//2 3 1 1 4 5 6 7 8 3
