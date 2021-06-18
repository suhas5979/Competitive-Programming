package dataStructuresAndAlgorithms.backTracking;

public class SudukoSolver {

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		printBoard(board);
		System.out.println();
		sudukoSolver(board, 0);
		printBoard(board);

	}

	static void printBoard(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	static boolean sudukoSolver(char[][] board, int pos) {
		char[] numbers = { '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		int row = pos / 9;
		int col = pos % 9;
		if (row == 9)
			return true;
		if (board[row][col] != '.')
			return sudukoSolver(board, pos + 1);
		else {
			for (int i = 0; i < 9; i++) {
				if(isValid(board, row, col, numbers[i])) {
					board[row][col] = numbers[i];
					if(sudukoSolver(board, pos+1))
						return true;
					board[row][col] = '.';
				}
			}
		}
		return false;

	}

	static boolean isValid(char[][] board, int row, int col, char c) {
		for (int i = 0; i < 9; i++) {
			if (board[row][i] == c)
				return false;
		}
		for (int i = 0; i < 9; i++) {
			if (board[i][col] == c)
				return false;
		}
		int sqRow = (row / 3) * 3;
		int sqCol = (col / 3) * 3;
		for (int i = sqRow; i < sqRow + 3; i++) {
			for (int j = sqCol; j < sqCol + 3; j++) {
				if (board[i][j] == c)
					return false;
			}
		}
		return true;
	}

}
