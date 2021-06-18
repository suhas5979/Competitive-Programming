package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Scanner;

public class PaintersPartition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(paintersPartition(arr, k));

	}
	static int paintersPartition(int[] boards,int k) {
		int n= boards.length;
		int res = Integer.MAX_VALUE;
		int left = 0;
		int right = 0;
		for(int i=0;i<n;i++) {
			right += boards[i];
			left = Math.max(left, boards[i]);
		}
		
		
		while(left <= right) {
			int mid  = (left+right) >>1;
			if(isPossible(boards,k,mid)) {
				res = Math.min(res, mid);
				right = mid -1;
			}else {
				left = mid +1;
			}
		}
		return left;
	}
	private static boolean isPossible(int[] boards, int k, int mid) {
		int n = boards.length;
		int paintersRequired = 1;
		int cur = 0;
		for(int i =0;i<n;i++) {
			if(boards[i] > mid)
				return false;
			if(cur + boards[i] > mid) {
				cur = boards[i];
				paintersRequired++;
			}else {
				cur += boards[i];
			}
		}
		if(paintersRequired > k)
			return false;
		return true;
	}

}

// Test case 1

//4
//2
//10 20 30 40

// Test Case 2

//4
//2
//10 10 10 10
