package dataStructuresAndAlgorithms.myDataStructures;

public class MyStack {
	class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	Node top;
	int size = 0;

	void push(int value) {
		Node toAdd = new Node(value);
		if (top == null && size == 0) {
			top = toAdd;
			size++;
			return;
		}
		toAdd.next = top;
		top = toAdd;
		size++;

	}

	int peek() throws Exception {
		if (top == null)
			throw new Exception("stack is empty");
		return top.data;
	}

	int pop() throws Exception {
		if (top == null)
			throw new Exception("Stack is Empty");
		int data = top.data;
		top = top.next;
		return data;

	}
	int size() {
		return size;
	}

	void printStack() {
		Node ptr = top;
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.println();
	}

	public static void main(String[] args) throws Exception {

		MyStack st = new MyStack();
		st.push(12);
		st.push(32);
		st.push(6);
		st.push(8);
		st.push(10);
		st.printStack();
		System.out.println(st.size());
		System.out.println(st.pop());
		st.printStack();

	}

}
