package dataStructuresAndAlgorithms.matrices;

import java.util.Scanner;

public class BinarySearchInMetrics {

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
		int x = sc.nextInt();
		sc.close();
		int[] res = binarySearch(arr, n, m, x);
		for (int i : res) {
			System.out.print(i +" ");
		}
	}

	static int[] binarySearch(int[][] arr, int n, int m, int target) {
		int left = 0;
		int right = (n * m) - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			int x = mid / m;
			int y = mid % m;
			if (arr[x][y] == target)
				return new int[] { x, y };
			else if (arr[x][y] > target) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return new int[] { -1 };
	}

}

//3 4
//1  2  3  4
//5  6  7  8 
//9 10 11 12
//10
