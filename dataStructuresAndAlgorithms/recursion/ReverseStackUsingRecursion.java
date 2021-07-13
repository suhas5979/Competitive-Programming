package dataStructuresAndAlgorithms.recursion;

import java.util.Stack;

public class ReverseStackUsingRecursion {

	public static void main(String[] args) {
		Stack<Integer> st = new Stack<Integer> ();
		st.push(5);
		st.push(2);
		st.push(7);
		st.push(9);
		System.out.println(st);
		reverseStack(st);
		System.out.println(st);
	}
	static void insertAtBottom(Stack<Integer> st,int n) {
		if(st.isEmpty())
			st.push(n);
		else
		{
			int temp = st.pop();
			insertAtBottom(st, n);
			st.push(temp);
		}
	}
	static void reverseStack(Stack<Integer> st) {
		if(st.isEmpty())
			return;
		else {
			int temp = st.pop();
			reverseStack(st);
			insertAtBottom(st, temp);
		}
	}

}
