package dataStructuresAndAlgorithms.myDataStructures;

import java.util.*;
import java.util.LinkedList;

class TreeNode {
	int data;
	TreeNode left, right;

	public TreeNode(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class MyTree {

	public static void main(String[] args) {

		System.out.println(diameterOfTree(unBalancedBuild().left.left));
	}

	static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	static void levelOrder(TreeNode root) {
		if (root == null)
			return;
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
	}

	static void reverseLevelOrder(TreeNode root) {
		if (root == null)
			return;
		Stack<Integer> st = new Stack<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			st.push(cur.data);
			if (cur.right != null)
				q.add(cur.right);
			if (cur.left != null)
				q.add(cur.left);
		}
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}

	}

	static int maxDepth(TreeNode root) {
		if (root == null)
			return -1;
		if (root.left == null && root.right == null)
			return 1;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

	static int diameterOfTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		int curDiameter = left + right + 1;
		int leftDiameter = diameterOfTree(root.left);
		int rightDiameter = diameterOfTree(root.right);
		int max;
		max = Math.max(curDiameter, leftDiameter);
		max = Math.max(rightDiameter, max);
		return max;
	}

	static TreeNode build() {
		TreeNode root = new TreeNode(10); // level 0
		// level 1
		root.left = new TreeNode(12);
		root.right = new TreeNode(78);
		// level 2
		root.left.left = new TreeNode(100);
		root.left.right = new TreeNode(26);
		root.right.left = new TreeNode(89);
		root.right.right = new TreeNode(45);
		// level 3
		root.left.left.left = new TreeNode(39);
		root.left.left.right = new TreeNode(93);
		root.left.right.left = new TreeNode(26);
		root.left.right.right = new TreeNode(62);
		root.right.left.left = new TreeNode(89);
		root.right.left.right = new TreeNode(98);
		root.right.right.left = new TreeNode(45);
		root.right.right.right = new TreeNode(54);

		return root;
	}

	static TreeNode unBalancedBuild() {
		TreeNode root = new TreeNode(10); // level 0
		// level 1
		root.left = new TreeNode(12);
		root.right = new TreeNode(78);
		// level 2
		root.left.left = new TreeNode(100);
		root.left.right = new TreeNode(26);
		root.right.left = new TreeNode(89);
		root.right.right = new TreeNode(45);
		// level 3
		root.left.left.left = new TreeNode(39);
		root.left.left.right = new TreeNode(93);
		root.left.right.left = new TreeNode(26);
		root.left.right.right = new TreeNode(62);
		root.right.left.left = new TreeNode(89);
		root.right.left.right = new TreeNode(98);
		root.right.right.left = new TreeNode(45);
		root.right.right.right = new TreeNode(54);
		// level 4
		root.right.right.left.right = new TreeNode(123);
		root.right.left.left.right = new TreeNode(345);
		// level 5
		root.right.left.left.right.left = new TreeNode(345);
		//level 6
		root.right.left.left.right.left.right = new TreeNode(345);

		return root;
	}

}
