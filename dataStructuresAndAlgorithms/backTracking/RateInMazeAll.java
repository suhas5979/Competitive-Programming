package dataStructuresAndAlgorithms.backTracking;

import java.util.ArrayList;
import java.util.Scanner;

public class RateInMazeAll {
	static String path = "";
	static ArrayList<String> possiblePaths = new ArrayList<>();

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
		boolean[][] visited = new boolean[n][n];
		printPathUtil(0, 0, arr, n, visited);
		System.out.println(possiblePaths);

	}

	static boolean isSafe(int row, int col, int m[][], int n, boolean visited[][]) {
		if (row == -1 || row == n || col == -1 || col == n || visited[row][col] || m[row][col] == 0)
			return false;

		return true;
	}

	static void printPathUtil(int row, int col, int m[][], int n, boolean visited[][]) {
		if (row == -1 || row == n || col == -1 || col == n || visited[row][col] || m[row][col] == 0)
			return;
		if (row == n - 1 && col == n - 1) {
			possiblePaths.add(path);
			return;
		}
		visited[row][col] = true;
		if (isSafe(row + 1, col, m, n, visited)) {
			path += 'D';
			printPathUtil(row + 1, col, m, n, visited);
			path = path.substring(0, path.length() - 1);
		}
		if (isSafe(row, col - 1, m, n, visited)) {
			path += 'L';
			printPathUtil(row, col - 1, m, n, visited);
			path = path.substring(0, path.length() - 1);
		}
		if (isSafe(row, col + 1, m, n, visited)) {
			path += 'R';
			printPathUtil(row, col + 1, m, n, visited);
			path = path.substring(0, path.length() - 1);
		}

		if (isSafe(row - 1, col, m, n, visited)) {
			path += 'U';
			printPathUtil(row - 1, col, m, n, visited);
			path = path.substring(0, path.length() - 1);
		}

		visited[row][col] = false;
	}

}

//4
//1 0 0 0
//1 1 0 1
//1 1 0 0
//0 1 1 1

//2
//4
//1 0 0 0
//1 1 1 1
