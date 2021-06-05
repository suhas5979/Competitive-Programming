package dataStructuresAndAlgorithms.myDataStructures;

import java.util.*;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

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

//		int[] in = { 4, 8, 2, 5, 1, 6, 3, 7 };
//		int[] post = { 8, 4, 5, 2, 6, 7, 3, 1 };

		levelOrder(buildTree(new int[] { 5, 3, 4, 8, 2 }, new int[] { 4, 3, 8, 5, 2 }));

	}

	static TreeNode mirror(TreeNode root) {
		if (root == null) {
			return root;
		}
		TreeNode left = mirror(root.left);
		TreeNode right = mirror(root.right);
		root.left = right;
		root.right = left;
		return root;

	}

	static void inOrder(TreeNode root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
	}

	static void preOrder(TreeNode root) {
		if (root == null)
			return;
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	static void postOrder(TreeNode root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
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
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return Math.max(left, right) + 1;
	}

	static int diameter(TreeNode root) {
		AtomicInteger res = new AtomicInteger();
		diameter(root, res);
		return res.get();
	}

	static int diameter(TreeNode root, AtomicInteger res) {
		if (root == null)
			return 0;
		int leftHeight = diameter(root.left, res);
		int rightHeight = diameter(root.right, res);
		res.set(Math.max(res.get(), leftHeight + rightHeight + 1));
		return Math.max(leftHeight, rightHeight) + 1;

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
		root.right.left.left.right.left = new TreeNode(145);
		// level 6
		root.right.left.left.right.left.right = new TreeNode(445);

		return root;
	}

	static TreeNode smallBuild() {
		TreeNode root = new TreeNode(5); // level 0
		// level 1
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		// level 2
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		// level 3
		root.left.left.right = new TreeNode(9);
		return root;
	}

	static ArrayList<Integer> inOrderIterative(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		TreeNode ptr = root;
		while (!st.isEmpty() || ptr != null) {
			if (ptr != null) {
				st.push(ptr);
				ptr = ptr.left;
			} else {
				TreeNode cur = st.pop();
				res.add(cur.data);
				ptr = cur.right;
			}
		}
		return res;
	}

	static ArrayList<Integer> preOrderIterative(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		TreeNode ptr = root;
		while (!st.isEmpty() || ptr != null) {
			if (ptr != null) {
				res.add(ptr.data);
				st.push(ptr);
				ptr = ptr.left;

			} else {
				TreeNode cur = st.pop();
				ptr = cur.right;
			}
		}
		return res;
	}

	static ArrayList<Integer> postOrderIterative(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		Stack<TreeNode> st = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
		st.push(root);
		while (!st.isEmpty()) {
			TreeNode cur = st.pop();
			output.push(cur);
			if (cur.left != null) {
				st.push(cur.left);
			}
			if (cur.right != null) {
				st.push(cur.right);
			}
		}
		while (!output.isEmpty()) {
			res.add(output.pop().data);
		}
		return res;
	}

	static ArrayList<Integer> leftView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.peek();
			res.add(cur.data);
			Queue<TreeNode> t = new LinkedList<>();
			while (!q.isEmpty()) {
				TreeNode c = q.poll();
				if (c.left != null) {
					t.add(c.left);
				}
				if (c.right != null) {
					t.add(c.right);

				}
			}
			q = t;
		}
		return res;
	}

	static ArrayList<Integer> rightView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		while (!q.isEmpty()) {
			TreeNode cur = q.peek();
			res.add(cur.data);
			Queue<TreeNode> t = new LinkedList<>();
			while (!q.isEmpty()) {
				TreeNode c = q.poll();
				if (c.right != null) {
					t.add(c.right);
				}
				if (c.left != null) {
					t.add(c.left);
				}
			}
			q = t;
		}
		return res;
	}

	static ArrayList<Integer> topView(TreeNode root) {
		HashSet<Integer> visited = new HashSet<>();
		visited.add(0);
		ArrayDeque<Integer> res1 = new ArrayDeque<>();
		res1.add(root.data);
		topView(root.left, -1, res1, visited);
		topView(root.right, 1, res1, visited);
		return new ArrayList<Integer>(res1);
	}

	static void topView(TreeNode root, int cur, ArrayDeque<Integer> res, HashSet<Integer> visited) {
		if (root == null) {
			return;
		}
		if (visited.contains(cur)) {
			return;
		}
		if (cur > 0) {
			res.addLast(root.data);
		} else {
			res.addFirst(root.data);
		}
		visited.add(cur);
		topView(root.left, cur - 1, res, visited);
		topView(root.right, cur + 1, res, visited);

	}

	static ArrayList<Integer> topView2(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		TreeMap<Integer, pair> m = new TreeMap<>();
		fill(root, 0, 0, m);
		for (Map.Entry<Integer, pair> entry : m.entrySet()) {
			res.add(entry.getValue().first);
		}
		return res;
	}

	static void fill(TreeNode root, int d, int l, TreeMap<Integer, pair> m) {
		if (root == null)
			return;
		if (m.get(d) == null) {
			m.put(d, new pair(root.data, l));
		} else if (m.get(d).second > l) {
			m.put(d, new pair(root.data, l));
		}
		fill(root.left, d - 1, l + 1, m);
		fill(root.right, d + 1, l + 1, m);
	}

	static class pair {
		int first, second;

		public pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
	}

	static ArrayList<Integer> bottomView(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		TreeMap<Integer, pair> map = new TreeMap<>();
		fillMap(root, 0, 0, map);
		for (Map.Entry<Integer, pair> entry : map.entrySet()) {
			res.add(entry.getValue().first);
		}

		return res;
	}

	static void fillMap(TreeNode root, int d, int l, TreeMap<Integer, pair> map) {
		if (root == null) {
			return;
		}
		if (map.get(d) == null) {
			map.put(d, new pair(root.data, l));
		}
		if (map.get(d).second <= l) {
			map.put(d, new pair(root.data, l));
		}

		fillMap(root.left, d - 1, l + 1, map);
		fillMap(root.right, d + 1, l + 1, map);

	}

	static ArrayList<Integer> zigZag(TreeNode root) {
		ArrayList<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<Integer> st = new Stack<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		boolean rev = false;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				TreeNode cur = q.poll();
				if (cur.left != null) {
					q.add(cur.left);
				}
				if (cur.right != null) {
					q.add(cur.right);
				}
				if (rev) {
					st.push(cur.data);
				} else {
					res.add(cur.data);
				}
			}
			if (rev) {
				while (!st.isEmpty()) {
					res.add(st.pop());
				}
			}
			rev = !rev;

		}
		return res;

	}

	static class MyBoolean {
		boolean data = true;

		boolean get() {
			return this.data;
		}

		void set(boolean data) {
			this.data = data;
		}
	}

	static boolean isBalanced(TreeNode root) {
		MyBoolean res = new MyBoolean();
		isBalanced(root, res);
		return res.get();
	}

	static int isBalanced(TreeNode root, MyBoolean res) {
		if (root == null) {
			return 0;
		}
		int leftHeight = isBalanced(root.left, res);
		int rightHeight = isBalanced(root.right, res);
		if (Math.abs(rightHeight - leftHeight) >= 2) {
			res.set(false);
		}
		return Math.max(leftHeight, rightHeight) + 1;
	}

	static ArrayList<ArrayList<Integer>> diagonalTraversal(TreeNode root) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
		fillMap(root, 0, map);
		for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet()) {
			res.add(entry.getValue());
		}
		return res;
	}

	static void fillMap(TreeNode root, int diagonal, TreeMap<Integer, ArrayList<Integer>> map) {
		if (root == null)
			return;
		map.putIfAbsent(diagonal, new ArrayList<Integer>());
		map.get(diagonal).add(root.data);
		fillMap(root.left, diagonal + 1, map);
		fillMap(root.right, diagonal, map);
	}

	static void printLeaves(TreeNode root, ArrayList<Integer> res) {
		if (root == null)
			return;
		printLeaves(root.left, res);
		if (root.left == null && root.right == null) {
			res.add(root.data);
		}
		printLeaves(root.right, res);

	}

	static void printBoundaryLeft(TreeNode node, ArrayList<Integer> res) {
		if (node == null)
			return;

		if (node.left != null) {

			res.add(node.data);
			printBoundaryLeft(node.left, res);
		} else if (node.right != null) {
			res.add(node.data);
			printBoundaryLeft(node.right, res);
		}

	}

	static void printBoundaryRight(TreeNode node, ArrayList<Integer> res) {
		if (node == null)
			return;

		if (node.right != null) {
			printBoundaryRight(node.right, res);
			res.add(node.data);
		} else if (node.left != null) {
			printBoundaryRight(node.left, res);
			res.add(node.data);
		}

	}

	static ArrayList<Integer> printBoundary(TreeNode node) {
		ArrayList<Integer> res = new ArrayList<>();
		if (node == null)
			return res;

		res.add(node.data);

		printBoundaryLeft(node.left, res);
		printLeaves(node.left, res);
		printLeaves(node.right, res);
		printBoundaryRight(node.right, res);
		return res;
	}

	static TreeNode buildTreeFromString(String str, int start, int end) {
		TreeNode root = new TreeNode(str.charAt(start) - '0');
		if (start == end)
			return root;
		int index = matchClose(str, start + 1, end);
		root.left = buildTreeFromString(str, start + 2, index - 1);
		if (index + 2 < end) {
			root.right = buildTreeFromString(str, index + 2, end - 1);
		}
		return root;
	}

	static int matchClose(String str, int start, int end) {
		Stack<Character> st = new Stack<>();
		for (int i = start; i <= end; i++) {
			if (str.charAt(i) == '(') {
				st.push('(');
			} else if (str.charAt(i) == ')') {
				st.pop();
				if (st.isEmpty()) {
					return i;
				}
			}
		}
		return -1;
	}

	public static void toSumTree(TreeNode root) {
		if (root == null)
			return;
		convertIntoSumTree2(root);
	}

	static int convertIntoSumTree2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = convertIntoSumTree2(root.left);
		int right = convertIntoSumTree2(root.right);
		int data = root.data;
		root.data = left + right;
		return data + left + right;
	}

	static TreeNode constructBinary(int[] in, int inStart, int inEnd, int[] post, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return null;
		}
		TreeNode root = new TreeNode(post[postEnd]);
		if (inStart == inEnd) {
			return root;
		}
		int index = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == post[postEnd]) {
				index = i;
				break;
			}
		}
		root.left = constructBinary(in, inStart, index - 1, post, postStart, postStart - inStart + index - 1);
		root.right = constructBinary(in, index + 1, inEnd, post, postEnd - inEnd + index, postEnd - 1);

		return root;
	}

	public static TreeNode buildTree(int inorder[], int preorder[], int n) {
		return constructBinaryTree(inorder, 0, n - 1, preorder, 0, n - 1);
	}

	static TreeNode constructBinaryTree(int[] in, int inStart, int inEnd, int[] pre, int preStart, int preEnd) {
		if (inStart > inEnd)
			return null;
		TreeNode root = new TreeNode(pre[preStart]);
		if (inStart == inEnd)
			return root;
		int index = -1;
		for (int i = inStart; i <= inEnd; i++) {
			if (in[i] == root.data) {
				index = i;
				break;
			}
		}
		int sizeOfLeftSubTree = index - inStart;
		int sizeOfRightSubTree = inEnd - index;
		root.left = constructBinary(in, inStart, index - 1, pre, preStart + 1, preStart + sizeOfLeftSubTree - 1);
		root.right = constructBinary(in, index + 1, inEnd, pre, preStart + sizeOfLeftSubTree + 1,
				preStart + sizeOfLeftSubTree + sizeOfRightSubTree);
		return root;
	}

	static int searchInorder(int val, int[] inorder, int lowInorder, int highInorder) {
		for (int i = lowInorder; i <= highInorder; i++) {
			if (val == inorder[i])
				return i;
		}
		return -1;
	}

	static TreeNode createTree(int[] inorder, int lowInorder, int highInorder, int[] preorder, int lowPreorder,
			int highPreorder) {

		if ((lowInorder > highInorder) || (lowPreorder > highPreorder))
			return null;

		TreeNode root = new TreeNode(preorder[lowPreorder]);

		int divideIndex = searchInorder(root.data, inorder, lowInorder, highInorder);

		int sizeOfLeftSubTree = divideIndex - lowInorder;
		int sizeOfRightSubTree = highInorder - divideIndex;

		root.right = createTree(inorder, divideIndex + 1, highInorder, preorder, lowPreorder + sizeOfLeftSubTree + 1,
				lowPreorder + sizeOfLeftSubTree + sizeOfRightSubTree);

		root.left = createTree(inorder, lowInorder, divideIndex - 1, preorder, lowPreorder + 1,
				lowPreorder + sizeOfLeftSubTree);

		return root;
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return createTree(inorder, 0, inorder.length - 1, preorder, 0, preorder.length - 1);
	}

}
