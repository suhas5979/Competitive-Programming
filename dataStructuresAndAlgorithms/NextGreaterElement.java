package dataStructuresAndAlgorithms;

import java.util.Stack;

public class NextGreaterElement {

	// Runner
	public static void main(String[] args) {
		
		int[] arr = new int[] {2,4,3,6,1,0,4,8,5,4};
		nextGreaterElement(arr);
		for(int n : arr) {
			System.out.print(n+",");
		}

	}
	public static void nextGreaterElement(int[] arr) {
		Stack<Integer> st = new Stack<>();
		for(int i=0;i<arr.length;i++) {
			while(!st.isEmpty() && arr[st.peek()] < arr[i]) {
				arr[st.pop()] = arr[i];
			}
			st.push(i);
		}
		while(!st.isEmpty()) {
			arr[st.pop()] = -1;
		}
	}

}
