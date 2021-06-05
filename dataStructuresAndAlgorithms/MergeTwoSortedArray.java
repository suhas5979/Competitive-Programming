package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MergeTwoSortedArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr1[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int arr2[] = new int[m];
		for (int i = 0; i < m; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		merge2(arr1, n, arr2, m);
		for (int i = 0; i < n; i++) {
			System.out.print(arr1[i] + " ");
		}
		System.out.println();
		for (int i = 0; i < m; i++) {
			System.out.print(arr2[i] + " ");
		}

	}

	static void merge(int[] arr1, int n, int[] arr2, int m) {
		for (int i = m - 1; i >= 0; i--) {
			if (arr1[n - 1] > arr2[i]) {
				int temp = arr1[n - 1];
				arr1[n - 1] = arr2[i];
				arr2[i] = temp;
				int ptr = n - 1;
				while (ptr > 0 && arr1[ptr] < arr1[ptr - 1]) {
					int temp2 = arr1[ptr];
					arr1[ptr] = arr1[ptr - 1];
					arr1[ptr - 1] = temp2;
					ptr--;
				}
			}
		}
	}
	static void merge2(int [] arr1,int n,int[] arr2,int m) {
		for(int i=m-1;i >= 0;i--) {
			int j;
			int last = arr1[n-1];
			for( j =n-2;j>=0 && arr1[j] > arr2[i];j--) {
				arr1[j+1] =arr1[j];
			}
			if(j != n-2 && arr2[i] <last ) {
				arr1[j+1] = arr2[i];
				arr2[i] = last;
			}
				
				
		}
	}

}

// Sample Test Case 1

//6
//1 3 5 6 11 14
//5 
//0 2 7 8 9
