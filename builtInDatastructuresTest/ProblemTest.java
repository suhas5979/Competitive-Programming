package builtInDatastructuresTest;

import java.util.Scanner;

public class ProblemTest {

	static void selectionSort(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++) {
				if (arr[minIndex] > arr[j])
					minIndex = j;
			}
			swap(arr, minIndex, i);
		}
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void insertionSort(int[] arr, int n) {
		for (int i = 1; i < n; i++) {
			int pick = arr[i];
			int j =i-1;
			while(j>= 0 && arr[j] > pick) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = pick;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		insertionSort(arr, n);
		System.out.println("Sorted Array");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
