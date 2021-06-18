package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Scanner;

public class CountInversions {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(countInversion(arr));

	}
	static int countInversion(int[] arr) {
		int n = arr.length;
		return mergeSort(arr, 0, n-1);	
	}
	static int mergeSort(int[] arr,int left ,int right) {
		int count = 0;
		if(left < right) {
			int mid = (left + right) >> 1;
			count += mergeSort(arr, left, mid);
			count += mergeSort(arr, mid +1, right);
			count += merge(arr,left ,mid,right);
		}
		return count;
	}
	private static int merge(int[] arr, int left, int mid, int right) {
		int count =0;
		int i = left;
		int j = mid + 1;
		int k = 0;
		int len = right - left + 1;
		int[] temp = new int[len];
		while (i <= mid && j <= right) {
			if (arr[i] <= arr[j]) {
				temp[k] = arr[i];
				i++;
			} else {
				count += (mid -i +1);
				temp[k] = arr[j];
				j++;
			}
			k++;
		}
		while (i <= mid) {
			temp[k] = arr[i];
			i++;
			k++;
		}
		while (j <= right) {
			temp[k] = arr[j];
			j++;
			k++;
		}
		int index = left;
		for (i = 0; i < len; i++) {
			arr[index++] = temp[i];
		}
		return count;
	}

}

// Test Case 1

//9
//6 4 2 7 8 4 9 1 5
