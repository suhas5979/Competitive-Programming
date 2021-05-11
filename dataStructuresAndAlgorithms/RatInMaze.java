package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class RatInMaze {

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
		int sol[][] = new int[n][n];
		if (ratInMaze(arr, 0, 0, n, sol)) {
			for (int i = 0; i < sol.length; i++) {
				for (int j = 0; j < sol.length; j++) {
					System.out.print(sol[i][j] + " ");
				}
				System.out.println();

			}
		}

	}

	static boolean ratInMaze(int[][] arr, int x, int y, int n, int[][] sol) {
		if (x == n - 1 && y == n - 1) {
			sol[x][y] = 1;
			return true;
		}
		if (isSafe(arr, x, y, n)) {
			sol[x][y] = 1;
			if (ratInMaze(arr, x + 1, y, n, sol)) {
				sol[x + 1][y] = 1;
				return true;
			}
			if (ratInMaze(arr, x, y + 1, n, sol)) {
				sol[x][y + 1] = 1;
				return true;
			}
			sol[x][y] = 0;
			return false;
		}
		return false;

	}

	static boolean isSafe(int[][] arr, int x, int y, int n) {
		if (x < n && y < n && arr[x][y] == 1) {
			return true;
		}
		return false;
	}

}

//1 1 0 1 0 0
//0 1 0 1 0 1
//0 1 0 0 0 0
//0 1 1 1 0 0
//0 0 0 1 1 0
//1 0 0 0 1 1
