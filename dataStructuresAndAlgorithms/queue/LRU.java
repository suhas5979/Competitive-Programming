package dataStructuresAndAlgorithms.queue;

import java.util.HashMap;

public class LRU {
	int capacity;
	Node head;
	Node tail;
	HashMap<Integer, Node> map = new HashMap<>();

	LRU(int cap) {
		this.capacity = cap;
	}

	static class Node {
		int key, val;
		Node next, prev;

		Node(int key, int value) {
			this.key = key;
			this.val = value;
		}
	}

	void set(int key, int value) {
		if (map.containsKey(key)) {
			map.get(key).val = value;
		} else if (head == null) {
			Node toAdd = new Node(key, value);
			head = toAdd;
			tail = toAdd;
			map.put(key, toAdd);
		} else if (map.size() == capacity) {
			map.remove(tail.key);
			tail.prev.next = null;
			Node toAdd = new Node(key, value);
			toAdd.next = head;
			head.prev = toAdd;
			head = toAdd;
			map.put(key, toAdd);
		} else {
			Node toAdd = new Node(key, value);
			toAdd.next = head;
			head.prev = toAdd;
			head = toAdd;
			map.put(key, toAdd);
		}
	}

	int get(int key) {
		if (map.containsKey(key)) {
			Node toDelete = map.get(key);
			if(toDelete.prev == null && toDelete.next == null) {
				return toDelete.val;
			}
			if (toDelete.prev == null) {
				head = head.next;
				head.prev = null;
				toDelete.next = head;
				head.prev = toDelete;
				head = toDelete;
				return head.val;
			} else if (toDelete.next == null) {
				tail = tail.prev;
				tail.next = null;

				toDelete.next = head;
				head.prev = toDelete;
				head = toDelete;
				return head.val;
			} else {
				toDelete.prev.next = toDelete.next;
				toDelete.next.prev = toDelete.prev;

				toDelete.next = head;
				head.prev = toDelete;
				head = toDelete;
				return head.val;
			}

		} else {
			return -1;
		}
	}

	public static void main(String[] args) {

		LRU l = new LRU(3);
		l.set(1, 10);
		l.set(3, 15);
		l.set(2, 12);
//		System.out.println(l.get(1));
		System.out.println(l.get(2));
	}

}
