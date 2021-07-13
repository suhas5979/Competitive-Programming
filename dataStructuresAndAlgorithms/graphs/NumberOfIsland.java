package dataStructuresAndAlgorithms.graphs;

import java.util.Scanner;

public class NumberOfIsland {

	public static void main(String[] args) {

		char[][] grid = { { '0', '1', '1', '1', '0', '0', '0' } };

		System.out.println(numberOfIsland(grid));

	}

	static int numberOfIsland(char[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int count = 0;
		boolean[][] visited = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					count++;
					expand(grid, visited, i, j);
				}
			}
		}
		return count;
	}

	private static void expand(char[][] grid, boolean[][] visited, int row, int col) {
		if (row < grid.length && col < grid[0].length && row >= 0 && col >= 0 && grid[row][col] == '1'
				&& !visited[row][col]) {
			visited[row][col] = true;
			expand(grid, visited, row + 1, col);
			expand(grid, visited, row, col + 1);

			expand(grid, visited, row + 1, col + 1);
			expand(grid, visited, row - 1, col);

			expand(grid, visited, row, col - 1);
			expand(grid, visited, row - 1, col - 1);

			expand(grid, visited, row + 1, col - 1);
			expand(grid, visited, row - 1, col + 1);

		}

	}

}

