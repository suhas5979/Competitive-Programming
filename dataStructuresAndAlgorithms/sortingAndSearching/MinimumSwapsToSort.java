package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

public class MinimumSwapsToSort {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(findMinSwap(arr,n));

	}

	static int minSwaps(int[] arr) {
		int n = arr.length;
		int[] duplicate = Arrays.copyOf(arr, n);
		Arrays.sort(duplicate);
		int count = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(arr[i], i);
		}
		for (int i = 0; i < n; i++) {
			System.out.println(i);
			if (arr[i] != duplicate[i]) {
				int index = map.get(duplicate[i]);
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
				i--;
				count++;
			}
		}

		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		for (int num : duplicate) {
			System.out.print(num + " ");
		}
		return count;
	}

	static class pair {

		public int x, y;

		public pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int findMinSwap(int[] arr, int n) {
		ArrayList<pair> vec = new ArrayList<>();

		for (int i = 0; i < n; i++)
			vec.add(new pair(arr[i], i));
		Collections.sort(vec, (o1, o2) -> {
			return o1.x - o2.x;
		});
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (vec.get(i).y != i) {
				pair temp = vec.get(vec.get(i).y);
				System.out.println("temp pair"+ "x =" +temp.x +" y=" + temp.y);
				vec.set(vec.get(i).y, vec.get(i));
				vec.set(i, temp);
				if (i != vec.get(i).y)
					--i;
				count++;
			}
		}
		return count;
	}

}

// Test Case

//9
//7 16 14 17 6 9 5 3 18
