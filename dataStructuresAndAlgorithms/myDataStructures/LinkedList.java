package dataStructuresAndAlgorithms.myDataStructures;

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList {
	Node head, tail;

	LinkedList() {
		this.head = null;
		this.tail = null;
	}

	LinkedList(int data) {
		Node toAdd = new Node(data);
		this.head = toAdd;
		this.tail = toAdd;
	}

	public void add(int data) {
		Node toAdd = new Node(data);
		if (head == null) {
			head = toAdd;
			tail = toAdd;
		}
		if (tail != null) {
			tail.next = toAdd;
			tail = tail.next;
		}

	}

	public int deleteAt(int index) throws Exception {
		if (index == 0) {
			int data = head.data;
			head = head.next;
			return data;
		}
		Node ptr = head;
		Node prev = null;
		while (ptr != null && index-- > 0) {
			prev = ptr;
			ptr = ptr.next;
		}
		if (ptr == null) {
			throw new Exception("No such index");
		}
		int data = prev.next.data;
		prev.next = prev.next.next;
		return data;
	}

	public void addAt(int data, int index) throws Exception {
		Node toAdd = new Node(data);
		if (index == 0) {
			toAdd.next = head;
			head = toAdd;
			return;
		}
		Node ptr = head;
		Node prev = null;
		while (ptr != null && index-- > 0) {
			prev = ptr;
			ptr = ptr.next;
		}
		if (ptr == null) {
			throw new Exception("No such index");
		}
		if (ptr != null) {
			prev.next = toAdd;
			prev.next.next = ptr;
		}
	}

	public void show() {
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	Node getHead() {
		return head;
	}

	public static void printList(Node head) {
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}
		System.out.print("null");
		System.out.println();
	}

	@Override
	public String toString() {
		return "LinkedList [head=" + head + ", tail=" + tail + "]";
	}

	// Runner
	public static void main(String[] args) throws Exception {

		LinkedList ll = new LinkedList();
		ll.add(3);
		ll.add(13);
		ll.add(31);
		ll.add(56);
		ll.add(7);
		ll.addAt(100, 1);
		ll.show();
//		Node revListNode = reverseList(ll.getHead());
//		printList(revListNode);
		
//		printList(cycledLinkedList());
		
		System.out.println(detectCycle(cycledLinkedList()));

	}

	static Node reverseList(Node head) {
		if (head == null || head.next == null)
			return head;
		
		Node prev = null;
		Node ptr = head;
		Node next = null;
		while(ptr != null) {
			next = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = next;
		}
		return prev;

	}
	static Node cycledLinkedList() {
		Node n1 = new Node(21);
		Node n2 = new Node(5);
		Node n3 = new Node(1);
		Node n4 = new Node(9);
		Node n5= new Node(11);
		Node n6= new Node(14);
		Node n7= new Node(6);
		Node n8= new Node(22);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n4;
		return n1;
		
	}
	static int detectCycle(Node head) {
		if(head == null || head.next == null ) return -1; 
		Node slow = head;
		Node fast = head.next;
		
		while(fast != null && slow != fast) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if(slow == fast) {
			return slow.data;
		}
		return -1;
		
	}

}
