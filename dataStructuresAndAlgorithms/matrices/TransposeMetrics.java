package dataStructuresAndAlgorithms.matrices;

import java.util.Scanner;

public class TransposeMetrics {

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
		rotateMetrics(arr, n, n);
		for (int[] nums : arr) {
			for (int num : nums) {
				System.out.print(num + " ");
			}
			System.out.println();
		}

	}

	static void transpose(int[][] arr, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < m; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}
	}

	static void rotateMetrics(int[][] arr, int n, int m) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < m; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp;
			}
		}

		for (int i = 0; i < n; i++) {
			int left = 0;
			int right = m - 1;
			while (left < right) {
				int temp = arr[i][left];
				arr[i][left] = arr[i][right];
				arr[i][right] = temp;
				right--;
				left++;
			}
		}
	}

}

//4 4
// 1  2 -3  1
// 4 -2 -6 -7
//-4  5  8 -2
//-9  6 -3 -8
