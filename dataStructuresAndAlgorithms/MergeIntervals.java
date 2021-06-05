package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MergeIntervals {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = 2;
		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		System.out.println(merge(arr, n));
	}

	static ArrayList<ArrayList<Integer>> merge(int[][] intervals, int n) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		Arrays.sort(intervals, (o1, o2) -> {
			return o1[0] - o2[0];
		});
		int startTime = intervals[0][0];
		int endTime = intervals[0][1];
		for (int i = 1; i < n; i++) {
			if (endTime >= intervals[i][0]) {
				endTime = Math.max(endTime, intervals[i][1]);
			} else {
				ArrayList<Integer> temp = new ArrayList<>();
				temp.add(startTime);
				temp.add(endTime);
				res.add(temp);
				startTime = intervals[i][0];
				endTime = intervals[i][1];
			}
		}
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(startTime);
		temp.add(endTime);
		res.add(temp);

		return res;
	}

}

// Test Case 1

//5 
//3 5 
//6 8
//2 4
//7 9
//8 11

// Test Case 2

//10
//7 9 
//12 16
//3 7
//5 9
//8 12
//15 17
//18 20
//21 25
//23 24
//1 3
