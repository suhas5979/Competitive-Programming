package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class CountStringPresentInMetrix {

	public static void main(String[] args) {
		String str = "GEEKS";
		char [][] arr = {
				{'D','D','D','G','D','D'},
				{'B','B','D','E','B','S'},
				{'B','S','K','E','B','K'},
				{'D','D','D','D','D','E'},
				{'D','D','D','D','D','E'},
				{'D','S','K','E','E','G'},
		};
		System.out.println(count(arr, arr.length, str));

	}

	static int count(char[][] arr, int n, String str) {

		int count = 0;
		for(int i=0;i <n;i++) {
			for(int j=0;j<n;j++) {
				if(str.charAt(0) == arr[i][j]) {
					count += find(arr, n, str, 0, i, j);
				}
				}
			}
		return count;

	}

	static int find(char[][] arr, int n, String str, int cur, int x, int y) {
		if (x == n || y == n || x == -1 || y == -1) {
			return 0;
		}
		if (cur == str.length() -1 && str.charAt(cur) == arr[x][y] ) {
			return 1;
		}
		if (str.charAt(cur) == arr[x][y]) {
			int count = find(arr, n, str, cur + 1, x + 1, y) + find(arr, n, str, cur + 1, x - 1, y)
					+ find(arr, n, str, cur + 1, x, y + 1) + find(arr, n, str, cur + 1, x, y - 1);

			return count;
		} else {
			return 0;
		}
	}

}

// Test case 1

//6
//GEEKS
//D D D G D D
//B B D E B S
//B S K E B K
//D D D D D E
//D D D D D E
//D D D D D G
