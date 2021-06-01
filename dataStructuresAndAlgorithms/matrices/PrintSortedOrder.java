package dataStructuresAndAlgorithms.matrices;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class PrintSortedOrder {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		ArrayList<Integer> res = new ArrayList<>();
		for (int nums[] : arr) {
			for (int num : nums) {
				res.add(num);
			}
		}
		res.sort((o1, o2) -> {
			return o1 - o2;
		});
		System.out.println(res);
	}

}

//3 4
//2 4 6 9
//4 7 8 11
//-4 2 4 6
