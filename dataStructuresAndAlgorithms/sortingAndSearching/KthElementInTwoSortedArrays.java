package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Scanner;

public class KthElementInTwoSortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int arr1[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		int arr2[] = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(kthElement(arr1, arr2, n, m, k));

	}
	static int kthElement(int[] arr1,int[] arr2,int n,int m,int k) {
		int left =Math.max(0, k -n);
		int right = Math.min(k, n);
		while(left <= right) {
			int cut1 = (left +right) /2;
			int cut2 = k - cut1;
			
			int l1 = cut1<=0?Integer.MIN_VALUE:arr1[cut1-1];
			int r1 = cut1>=n?Integer.MAX_VALUE:arr1[cut1];
			int l2 = cut2<=0?Integer.MIN_VALUE:arr2[cut2-1];
			int r2 = cut2>=m?Integer.MAX_VALUE:arr2[cut2];
			if(l1 <= r2 && l2 <= r1) {
				return Math.max(l2, l1);
			}
			if(l1 > r2) {
				right = cut1 -1;
			}if(l2 > r1) {
				left = cut1+1;
			}
		}
		return -1;
	}

}

// Test Case 1

//10
//12
//16
//2 4 6 8 12 23 45 47 62 70
//1 3 7 9 15 20 32 35 52 53 56 60
