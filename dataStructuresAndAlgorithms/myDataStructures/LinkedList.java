package dataStructuresAndAlgorithms.myDataStructures;

import java.util.HashSet;

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
		ll.add(12);
		ll.add(5);
		ll.add(21);
		ll.add(8);
		ll.add(12);
		ll.add(21);
		ll.add(8);
		ll.add(100);
		ll.add(200);
		ll.add(222);
		ll.show();
//		Node revListNode = removeDuplicatesInUnSorted(ll.getHead());
//		printList(revListNode);

		splitTest();

//		printList(cycledLinkedList());

//		System.out.println(detectCycle(cycledLinkedList()));

//		deleteCycle(cycledLinkedList());

	}

	static void additionOfLLTest() {
		LinkedList ll1 = new LinkedList();
		ll1.add(4);
		ll1.add(5);

		LinkedList ll2 = new LinkedList();
		ll2.add(3);
		ll2.add(4);
		ll2.add(5);

		Node res = addToLL(ll1.getHead(), ll2.getHead());
		printList(res);

	}

	static void addOneToLLTest() {
		LinkedList ll1 = new LinkedList();
		ll1.add(4);
		ll1.add(3);
		ll1.add(1);

		Node res = addOneToLL(ll1.getHead());
		printList(res);

	}

	static Node reverseList(Node head) {
		if (head == null || head.next == null)
			return head;

		Node prev = null;
		Node ptr = head;
		Node next = null;
		while (ptr != null) {
			next = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = next;
		}
		return prev;

	}
	
	/*

	static void splitList(Node head) {
		if (list.head == null || list.head.next == null) {
			return;
		}
		int count = 0;
		Node head = list.head;
		Node ptr = head;
		// count all nodes;
		do{
		    count++;
		    ptr = ptr.next;
		}while(ptr != head);
		// calculate middle of nodes
		int temp = (count+1) /2;
		while(temp >1){
		    ptr = ptr.next;
		    temp--;
		}
		// secure next node
		Node temp1 = ptr.next;
		// connect middle to head in order to create first circular linkedlist
		ptr.next = head;
		// saving head to head 1
		list.head1 = head;
		// saving head 2 
		list.head2 = temp1;
		// iterate over next half of the linked list and connect last node 
		// to 
		while(temp1.next != head){
		    temp1 = temp1.next;
		}
        temp1.next = list.head2;
	}
	
	*/

	static Node reverseGroup(Node head, int k) {
		if (head == null || head.next == null)
			return head;
		Node prev = null;
		Node ptr = head;
		Node next = null;
		int count = 0;
		while (ptr != null && count < k) {
			next = ptr.next;
			ptr.next = prev;
			prev = ptr;
			ptr = next;
			count++;
		}
		head.next = reverseGroup(ptr, k);
		return prev;
	}

	static Node removeDuplicates(Node head) {
		if (head == null || head.next == null)
			return head;
		if (head.next.data == head.data) {
			head.next = removeDuplicates(head.next);
			return head.next;
		} else {
			head.next = removeDuplicates(head.next);
			return head;
		}
	}

	static Node removeDuplicatesInUnSorted(Node head) {
		if (head == null || head.next == null)
			return head;
		HashSet<Integer> set = new HashSet<>();
		Node prev = null;
		Node ptr = head;
		while (ptr != null) {
			if (set.contains(ptr.data)) {
				prev.next = ptr.next;
			} else {
				set.add(ptr.data);
				prev = ptr;
			}
			ptr = ptr.next;
		}
		return head;
	}

	static Node middleOFLinkedList(Node head) {
		if (head == null || head.next == null)
			return head;
		Node slow = head;
		Node fast = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}

	static Node removeDuplicatesInSorted(Node head) {
		if (head == null || head.next == null)
			return head;
		Node ptr = head;
		while (ptr != null && ptr.next != null) {
			if (ptr.data == ptr.next.data) {
				ptr.next = ptr.next.next;
			} else {
				ptr = ptr.next;
			}
		}
		return head;
	}

	// Split Test
	static void splitTest() {
		Node n1 = new Node(21);
		Node n2 = new Node(5);
		Node n3 = new Node(1);
		Node n4 = new Node(9);
		Node n5 = new Node(11);
		Node n6 = new Node(14);
		Node n7 = new Node(6);
		Node n8 = new Node(22);
		Node n9 = new Node(152);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n1;
//		splitList(n1);

	}

	static Node cycledLinkedList() {
		Node n1 = new Node(21);
		Node n2 = new Node(5);
		Node n3 = new Node(1);
		Node n4 = new Node(9);
		Node n5 = new Node(11);
		Node n6 = new Node(14);
		Node n7 = new Node(6);
		Node n8 = new Node(22);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n1;
		return n1;

	}

	static int detectCycle(Node head) {
		if (head == null || head.next == null)
			return -1;
		Node slow = head;
		Node fast = head.next;

		while (fast != null && slow != fast) {
			fast = fast.next.next;
			slow = slow.next;
		}
		if (slow == fast) {
			return slow.data;
		}
		return -1;

	}

	static Node addToLL(Node head1, Node head2) {
		if (head1 == null)
			return head2;
		if (head2 == null)
			return head1;

		Node dummy = new Node(0);
		Node ptr1 = reverseList(head1);
		Node ptr2 = reverseList(head2);
		Node ptr = dummy;
		int carry = 0;
		while (ptr1 != null && ptr2 != null) {
			int sum = ptr1.data + ptr2.data + carry;
			ptr.next = new Node(sum % 10);
			carry = sum / 10;
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
			ptr = ptr.next;
		}
		while (ptr1 != null) {
			int sum = carry + ptr1.data;
			ptr.next = new Node(sum % 10);
			carry = sum / 10;
			ptr1 = ptr1.next;
			ptr = ptr.next;
		}
		while (ptr2 != null) {
			int sum = carry + ptr2.data;
			ptr.next = new Node(sum % 10);
			carry = sum / 10;
			ptr2 = ptr2.next;
			ptr = ptr.next;
		}
		if (carry == 1)
			ptr.next = new Node(1);
		return reverseList(dummy.next);
	}

	static Node addOneToLL(Node head) {
		if (head == null)
			return head;
		Node ptr = reverseList(head);
		int carry = 1;
		Node save = ptr;
		Node prev = null;
		while (ptr != null) {
			int sum = ptr.data + carry;
			ptr.data = sum % 10;
			carry = sum / 10;
			if (carry == 0)
				break;
			prev = ptr;
			ptr = ptr.next;
		}
		if (carry == 1) {
			prev.next = new Node(1);
		}

		return reverseList(save);

	}

	static void deleteCycle(Node head) {
		if (head == null)
			return;
		Node slow = head;
		Node fast = head.next;
		while (fast != null) {
			System.out.println("ss");
			if (fast == slow) {
				fast = head;
				break;
			}
			if (slow.next == head) {
				slow.next = null;
				return;
			}
			fast = fast.next.next;
			slow = slow.next;
		}
		System.out.println(fast.data);
		System.out.println(slow.data);

		Node prev = slow;
		while (slow != null && fast != null && fast != slow) {
			prev = slow;
			slow = slow.next;
			fast = fast.next;
		}
		System.out.println(slow.data);
		prev.next = null;
		Node ptr = head;
		while (ptr != null) {
			System.out.print(ptr.data + "->");
			ptr = ptr.next;
		}

	}


}
