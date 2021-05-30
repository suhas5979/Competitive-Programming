package dataStructuresAndAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class PaintersProblem {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		sc.close();

	}

//	static int minimumPainter(int[] boards, int n, int m) {
//		Arrays.sort(boards);
//		int sum = 0;
//		for (int i = 0; i < n; i++) {
//			sum += boards[i];
//		}
//		int left = 0;
//		int right = sum;
//		while(left <= right) {
//			int mid = (left+right)/2;
//			if(isPossible(boards,n,mid)) {
//				
//			}
//		}
//	}

}
