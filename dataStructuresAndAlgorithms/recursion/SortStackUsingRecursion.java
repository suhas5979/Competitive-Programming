package dataStructuresAndAlgorithms.recursion;

import java.util.Stack;

public class SortStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer>();
		st.push(45);
		st.push(6);
		st.push(7);
		st.push(-3);
		st.push(9);
		st.push(22);
		st.push(52);
		st.push(36);
		System.out.println(st);
		sortStack(st);
		System.out.println(st);
	}
	static void sortStack(Stack<Integer> st) {
		if(st.isEmpty())
			return;
		else {
			int temp = st.pop();
			sortStack(st);
			insertAtRight(st, temp);
		}
	}
	static void insertAtRight(Stack<Integer> st,int n) {
		if(st.isEmpty())
		{
			st.push(n);
			return;
		}
		if(st.peek() < n) {
			st.push(n);
		}else {
			int temp = st.pop();
			insertAtRight(st, n);
			st.push(temp);
		}
	}

}
