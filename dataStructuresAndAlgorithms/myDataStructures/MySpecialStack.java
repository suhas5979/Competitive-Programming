package dataStructuresAndAlgorithms.myDataStructures;

public class MySpecialStack {
	Node top;
	int size = 0;
	Node middle;

	static class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
		}
	}

	MySpecialStack() {
		top = null;
		middle = null;
	}

	void push(int data) {
		Node toAdd = new Node(data);
		if (top == null) {
			top = toAdd;
			size++;
			return;
		}
		top.next = toAdd;
		toAdd.prev = top;
		top = top.next;
		size++;
		if (size == 2) {
			middle = toAdd;
		} else if (size > 2 && size % 2 == 0) {
			middle = middle.next;
		}
	}

	int peek() {
		return top.data;
	}

	int middleElement() {
		return middle.data;
	}

	int deleteMiddle() {
		int data = middle.data;
		if (size % 2 == 0) {
			Node nextNode = middle.next;
			System.out.println(nextNode.data);
			middle.prev.next = nextNode;
			nextNode.prev = middle.prev;
			middle = nextNode;
		} else {
			Node prevNode = middle.prev;
			prevNode.next = middle.next;
			middle.next.prev = prevNode;
			middle = prevNode;
		}

		return data;
	}

	int pop() {
		if (top == null) {
			return -1;
		} else {
			top = top.prev;
			top.next = null;
			size--;
			if (size % 2 == 1) {
				middle = middle.prev;
			}
		}

		return -1;
	}

	void print() {

		for (Node ptr = this.top; ptr != null; ptr = ptr.prev) {
			System.out.print(ptr.data + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		MySpecialStack st = new MySpecialStack();
		st.push(1);
		st.push(5);
		st.push(12);
		st.push(8);
		st.push(23);
		st.push(25);
		st.push(100);
		
		st.print();
		st.deleteMiddle();
		st.deleteMiddle();
	
		st.print();
		System.out.println(st.middleElement());
	}

}
