package dataStructuresAndAlgorithms.stack;

import java.util.Scanner;

public class CelebrityProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		System.out.println(findCelebrity(arr, n));
	}

	static int celebrity(int M[][], int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == j)
					continue;
				if (M[i][j] == 1 && check(M, j))
					return j;
			}
		}
		return -1;
	}

	static boolean check(int M[][], int j) {
		for (int i = 0; i < M.length; i++) {
			if (M[j][i] == 1)
				return false;
		}
		return true;
	}

	static int findCelebrity(int[][] m, int n) {
		int[] indegree = new int[n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (m[i][j] == 1)
					indegree[j]++;
			}
		}
		for (int i = 0; i < n; i++)
			if (indegree[i] == n - 1)
				return i;

		return -1;
	}

}

// Test case

//5
//0 0 1 0 0
//1 0 1 0 0
//0 0 0 0 0
//1 0 1 0 0
//1 0 1 0 0 
