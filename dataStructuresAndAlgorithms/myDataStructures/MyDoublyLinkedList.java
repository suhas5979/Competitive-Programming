package dataStructuresAndAlgorithms.myDataStructures;

public class MyDoublyLinkedList {
	class Node {
		int data;
		Node next, prev;

		Node(int data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static Node reverseDLL(Node head) {
		if (head == null || head.next == null)
			return head;
		Node ptr = head;
		while (ptr != null) {
			Node temp = ptr.next;
			ptr.next = ptr.prev;
			ptr.prev = temp;
			if (temp == null)
				return ptr;
			ptr = temp;
		}
		return ptr;
	}

}
