package dataStructuresAndAlgorithms.matrices;

public class NearestCellHavingOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int[][] nearest(int[][] grid) {
		int r = grid.length;
		int c = grid[0].length;
		int ans[][] = new int[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1)
					ans[i][j] = 0;
				else
					ans[i][j] = Integer.MAX_VALUE - 1;
			}
		}
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (i - 1 >= 0) {
					ans[i][j] = Math.min(ans[i - 1][j] + 1, ans[i][j]);
				}
				if (j - 1 >= 0) {
					ans[i][j] = Math.min(ans[i][j - 1] + 1, ans[i][j]);
				}

				if (i + 1 < r) {
					ans[i][j] = Math.min(ans[i + 1][j] + 1, ans[i][j]);
				}

				if (j + 1 < c) {
					ans[i][j] = Math.min(ans[i][j + 1] + 1, ans[i][j]);
				}
			}
		}

		for (int i = r - 1; i >= 0; i--) {
			for (int j = c - 1; j >= 0; j--) {
				if (i - 1 >= 0) {
					ans[i][j] = Math.min(ans[i - 1][j] + 1, ans[i][j]);
				}
				if (j - 1 >= 0) {
					ans[i][j] = Math.min(ans[i][j - 1] + 1, ans[i][j]);
				}
				if (i + 1 < r) {
					ans[i][j] = Math.min(ans[i + 1][j] + 1, ans[i][j]);
				}
				if (j + 1 < c) {
					ans[i][j] = Math.min(ans[i][j + 1] + 1, ans[i][j]);
				}
			}
		}

		return ans;
	}

}
