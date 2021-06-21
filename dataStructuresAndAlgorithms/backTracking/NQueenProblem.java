package dataStructuresAndAlgorithms.backTracking;

import java.util.Scanner;

public class NQueenProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		int[][] board = new int[n][n];
		solve(board, 0);

	}

	static void printBoard(int[][] board) {
		int size = board.length;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void solve(int[][] board, int row) {
		if (row == board.length)
			printBoard(board);
		else {
			for (int i = 0; i < board.length; i++) {
				if (isSafe(board, row, i)) {
					board[row][i] = 1;
					solve(board, row + 1);
					board[row][i] = 0;
				}
			}
		}
	}

	private static boolean isSafe(int[][] board, int row, int col) {
		int size = board.length;
		// row
		for (int i = 0; i < size; i++) {
			if (board[row][i] == 1)
				return false;
		}
		// column
		for (int i = 0; i < size; i++) {
			if (board[i][col] == 1)
				return false;
		}
		// Diagonal
		for (int i = row, j = col; i < size && j < size; i++, j++)
			if (board[i][j] == 1)
				return false;
		for (int i = row, j = col; i >= 0 && j < size; i--, j++)
			if (board[i][j] == 1)
				return false;
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
			if (board[i][j] == 1)
				return false;
		for (int i = row, j = col; i < size && j >= 0; i++, j--)
			if (board[i][j] == 1)
				return false;
		return true;
	}

}
