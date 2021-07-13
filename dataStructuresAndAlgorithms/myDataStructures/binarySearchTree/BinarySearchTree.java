package dataStructuresAndAlgorithms.myDataStructures.binarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	TreeNode root;

	static class TreeNode {
		int data;
		TreeNode left, right;

		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	// Creating BST
	public BinarySearchTree() {
		this.root = null;
	}

	// Get BST root
	TreeNode getRoot() {
		return this.root;
	}

	// Insert data into BST
	void insert(int data) {
		this.root = insert(this.root, data);
	}

	// Insert data Recursive function
	private TreeNode insert(TreeNode root, int data) {
		if (root == null)
			root = new TreeNode(data);
		else if (data > root.data) {
			root.right = insert(root.right, data);
		} else {
			root.left = insert(root.left, data);
		}
		return root;

	}

	//
	boolean contains(int data) {
		return contains(this.root, data);
	}

	private boolean contains(TreeNode root, int data) {
		if (root == null)
			return false;
		else if (root.data == data)
			return true;
		else if (data > root.data) {
			return contains(root.right, data);
		} else {
			return contains(root.left, data);
		}

	}

	// Level Order Traversal
	void levelOrder() {
		TreeNode root = this.root;
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			System.out.print(cur.data + " ");
			if (cur.left != null)
				q.add(cur.left);
			if (cur.right != null)
				q.add(cur.right);
		}
		System.out.println();
	}

	// Get Minimum element in BST
	int getMinimum() {
		if (this.root == null)
			return -1;
		return getMinimum(root);
	}

	private int getMinimum(TreeNode root) {
		if (root.left == null)
			return root.data;
		return getMinimum(root.left);
	}

	// Get Maximum element in BST
	int getMaximum() {
		if (this.root == null)
			return -1;
		return getMaximum(this.root);
	}

	private int getMaximum(TreeNode root) {
		if (root.right == null)
			return root.data;
		return getMaximum(root.right);
	}

	void delete(int data) {
		this.root = delete(this.root, data);
	}

	TreeNode delete(TreeNode root, int data) {
		if (root == null)
			return null;
		else if (data > root.data) {
			root.right = delete(root.right, data);
		} else if (data < root.data) {
			root.left = delete(root.left, data);
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left != null && root.right != null) {
				int successor = getSuccessor(root.right);
				root.data = successor;
				root.right = delete(root.right, successor);
			} else {
				if (root.left != null)
					return root.left;
				else
					return root.right;
			}

		}
		return root;
	}

	int getSuccessor(TreeNode root) {
		if (root.left == null)
			return root.data;
		else
			return getSuccessor(root.left);
	}

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(100);
		bst.insert(80);
		bst.insert(200);
		bst.insert(70);
		bst.insert(50);
		bst.insert(40);
		bst.insert(60);
		bst.insert(90);
		bst.insert(150);
		bst.insert(300);
		bst.insert(140);
		bst.insert(160);
		bst.insert(400);
		bst.insert(350);
		bst.insert(410);
		bst.levelOrder();
		System.out.println(bst.getMinimum());
		bst.delete(100);
		bst.levelOrder();
	}

}
