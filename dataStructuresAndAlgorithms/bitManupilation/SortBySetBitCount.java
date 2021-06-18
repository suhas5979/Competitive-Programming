package dataStructuresAndAlgorithms.bitManupilation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SortBySetBitCount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		sortByBits(arr);
		for (int num : arr) {
			System.out.print(num + " ");
		}

	}

	static class pair {
		int x, y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static void sortByBits(int[] arr) {
		ArrayList<pair> list = new ArrayList<>();
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			int count = Integer.bitCount(arr[i]);
			list.add(new pair(arr[i], count));
		}
		Collections.sort(list, (o1, o2) -> {
			return o2.y - o1.y;
		});
		System.out.println(list);
		for (int i = 0; i < n; i++) {
			arr[i] = list.get(i).x;
		}
	}

}

//9
//5 2 3 9 4 6 7 15 32
