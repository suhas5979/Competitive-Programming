package dataStructuresAndAlgorithms;

import java.util.Scanner;
import java.util.Stack;

public class MaxRectangularArea {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		System.out.println(maxArea(arr, n));

	}

	static int maxArea(int[] buildings, int n) {
		Stack<Integer> st = new Stack<>();
		st.push(0);
		int max = 0;
		for (int i = 0; i < n; i++) {
			int length = 1;
			max = Math.max(max, buildings[i]);
			while (!st.isEmpty() && st.peek() >= buildings[i]) {
				int height = Math.min(st.peek(), buildings[i]);
				length++;
				max = Math.max(max, length * height);
				st.pop();
			}
			st.push(buildings[i]);
		}
		int length = 1;
		while (!st.empty()) {
			max = Math.max(max, st.peek() * length);
			st.pop();
			length++;
		}
		return max;
	}

}

// Sample Test cases

//4
//2 3 4 2

// Sample Test case 2

//4
//1 2 3 4

// Sample Test case 3

//8
//4 9 6 0 1 2 3 5
