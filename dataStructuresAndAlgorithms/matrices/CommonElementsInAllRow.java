package dataStructuresAndAlgorithms.matrices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class CommonElementsInAllRow {

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
		System.out.println(commonElements(arr, n, m));

	}

	static ArrayList<Integer> commonElements(int[][] arr, int n, int m) {
		ArrayList<Integer> res = new ArrayList<>();
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int i = 0; i < m; i++) {
			freq.put(arr[0][i], 1);
		}
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (freq.containsKey(arr[i][j])) {
					if(freq.get(arr[i][j]) == i) {
						freq.replace(arr[i][j], i + 1);	
					}
				}
			}
		}
		freq.forEach((key, value) -> {
			if (value == n) {
				res.add(key);
			}
		});

		return res;
	}

}

// Sample Test Case 1

//4 5
//1 3 5 6 7
//3 6 8 2 3
//4 2 7 9 8 
//1 2 6 7 8

//Sample Test Case 2

//4 10
//1 3 5 6 7 3 6 8 2 3 
//4 2 7 9 8 1 2 6 7 8
//1 3 5 6 7 3 6 8 2 3
//4 2 7 9 8 1 2 6 7 8
