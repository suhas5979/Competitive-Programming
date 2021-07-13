package dataStructuresAndAlgorithms.stack;

import java.util.Scanner;
import java.util.Stack;

public class MaxAreaInHistogram {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(maxArea(arr, n));
	}

	static int maxArea(int[] hist, int n) {
		Stack<Integer> st = new Stack<>();
		int max = 0;
		int tp;
		int area;
		int i = 0;
		while (i < n) {
			if (st.empty() || hist[st.peek()] <= hist[i])
				st.push(i++);
			else {
				tp = st.peek();
				st.pop();
				area = hist[tp] * (st.empty() ? i : i - st.peek() - 1);
				max = Math.max(area, max);
			}
		}
		while (!st.empty()) {
			tp = st.peek();
			st.pop();
			area = hist[tp] * (st.empty() ? i : i - st.peek() - 1);
			max = Math.max(area, max);
		}
		return max;
	}

}

// Test Case

//7
//6 2 5 4 5 1 6
