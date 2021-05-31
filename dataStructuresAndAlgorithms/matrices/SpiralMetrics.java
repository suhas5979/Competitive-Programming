package dataStructuresAndAlgorithms.matrices;

import java.util.Scanner;

public class SpiralMetrics {

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
		spiral(arr, n, m);

	}

	static void spiral(int[][] arr, int n, int m) {
		int left = 0;
		int right = m - 1;
		int up = 0;
		int down = n - 1;
		while (left <= right && up <= down) {
			for (int i = left; i < m && i <= right; i++) {
				System.out.print(arr[up][i] + " ");
			}
			up++;
			for (int i = up; i < n && i <= down; i++) {
				System.out.print(arr[i][right] + " ");
			}
			right--;
			if (up <= down) {
				for (int i = right; i >= 0 && i >= left; i--) {
					System.out.print(arr[down][i] + " ");
				}
				down--;
			}
			if (left <= right) {
				for (int i = down; i >= 0 && i >= up; i--) {
					System.out.print(arr[i][left] + " ");
				}
				left++;
			}

		}
	}

}

//4 5
//12 73 84 36 28
//19 23 45 21 78
//34 76 89 13 35
//23 56 75 14 56