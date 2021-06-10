package dataStructuresAndAlgorithms.string;

import java.util.ArrayList;

public class FindStringinCharacterGrid {

	public static void main(String[] args) {
		String str = "DON";
		char[][] arr = { 
				{ 'D', 'D', 'D', 'G', 'D', 'D' }, 
				{ 'B', 'O', 'D', 'E', 'B', 'O' },
				{ 'B', 'S', 'N', 'E', 'B', 'N' }, 
				{ 'D', 'O', 'D', 'D', 'D', 'E' }, 
				{ 'D', 'D', 'D', 'D', 'D', 'E' },
				{ 'D', 'S', 'K', 'E', 'E', 'G' }, };
		int[][] te = searchWord(arr, str);
		for (int[] nums : te) {
			for (int num : nums) {
				System.out.print(num + ",");
			}
			System.out.println();
		}
		System.out.println(te.length);
	}

	static int[][] searchWord(char[][] grid, String word) {
		int n = grid.length;
		int m = grid[0].length;
		ArrayList<int[]> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (find(grid, n, m, word, 0, i, j)) {
					res.add(new int[] { i, j });
				}
			}
		}
		int size = res.size();
		int[][] result = new int[size][2];
		for (int i = 0; i < size; i++) {
			result[i] = res.get(i);
		}
		return result;

	}

	static boolean find(char[][] arr, int n, int m, String str, int cur, int x, int y) {
		int ptr = 0;
		// For lower right diagonal
		for (int i = x, j = y; i < n && j < m; i++, j++) {
			if (str.charAt(ptr) == arr[i][j]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		ptr = 0;
		// for upper left diagonal
		for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
			if (str.charAt(ptr) == arr[i][j]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		ptr = 0;
		// for upper right diagonal
		for (int i = x, j = y; i >= 0 && j < m; i--, j++) {
			if (str.charAt(ptr) == arr[i][j]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		ptr = 0;
		// for lower left diagonal
		for (int i = x, j = y; i < n && j >=0; i++, j--) {
			if (str.charAt(ptr) == arr[i][j]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		ptr = 0;
		// For down
		for (int i = x; i < n; i++) {
			if (str.charAt(ptr) == arr[i][y]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		ptr = 0;
		// For up
		for (int i = x; i >= 0; i--) {
			if (str.charAt(ptr) == arr[i][y]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		ptr = 0;
		// For left
		for (int i = y; i >= 0; i--) {
			if (str.charAt(ptr) == arr[x][i]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		ptr=0;
		// For right
		for (int i = y; i < m; i++) {
			if (str.charAt(ptr) == arr[x][i]) {
				ptr++;
				if (ptr == str.length())
					return true;
			} else {
				break;
			}
		}
		return false;

	}

}
