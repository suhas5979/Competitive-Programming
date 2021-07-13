package dataStructuresAndAlgorithms.stack;

import java.util.Stack;

public class SpecialStack {
	Stack<Integer> st = new Stack<>();
	int min = -1;

	void push(int data) {
		if (st.isEmpty()) {
			st.add(data);
			min = data;
		} else {
			if (data >= min) {
				st.add(data);
			} else {
				st.push((2 * data) - min);
				min = data;
			}
		}
	}

	void pop() {
		if(st.isEmpty())
			return;
		if (st.peek() >= min) {
			st.pop();
		} else {
			min = (2 * min) - st.peek();
			st.pop();
		}
	}
	int getMin() {
		return min;
	}

	public static void main(String[] args) {
		SpecialStack st = new SpecialStack();
		st.push(3);
		System.out.println(st.getMin());
		st.push(2);
		System.out.println(st.getMin());
		st.push(5);
		System.out.println(st.getMin());
		st.push(1);
		System.out.println(st.getMin());
		st.pop();
		st.pop();
		st.pop();
		System.out.println(st.getMin());
	}

}
