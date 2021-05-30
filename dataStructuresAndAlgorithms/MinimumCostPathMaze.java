package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MinimumCostPathMaze {

	// Runner
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
		System.out.println(minimumCost(arr, n, 0, 0));

	}

	static int minimumCost(int[][] maze, int n, int x, int y) {
		if (x >= n || y >= n)
			return Integer.MAX_VALUE / 4;
		if (x == n - 1 && y == n - 1) {
			return maze[x][y];
		}
		int min1 = maze[x][y] + minimumCost(maze, n, x + 1, y);
		int min2 = maze[x][y] + minimumCost(maze, n, x, y + 1);
		return Math.min(min1, min2);
	}
}

// Sample Test Case

//3
//1 2 3
//1 2 6
//3 5 1
