package dataStructuresAndAlgorithms.myDataStructures;

public class Tries {
	class TrieNode {
		TrieNode[] children = new TrieNode[26];;
		boolean end;

		TrieNode() {
			end = false;
			for (int i = 0; i < children.length; i++) {
				children[i] = null;
			}
		}
	}

	Tries() {
		this.root = new TrieNode();
	}

	TrieNode root;

	void insert(String str) {
		int index;
		TrieNode ptr = root;
		int length = str.length();
		for (int i = 0; i < length; i++) {
			index = str.charAt(i) - 'a';
			if (ptr.children[index] == null)
				ptr.children[index] = new TrieNode();
			ptr = ptr.children[index];
		}
		ptr.end = true;
	}

	boolean search(String str) {
		int length = str.length();
		int index;
		TrieNode ptr = root;
		for (int i = 0; i < length; i++) {
			index = str.charAt(i) - 'a';
			if (ptr.children[index] == null)
				return false;
			ptr = ptr.children[index];
		}
		return ptr.end;
	}

	public static void main(String[] args) {

		Tries my = new Tries();

		my.insert("suhas");
		my.insert("suryavanshi");

		if (my.search("suhas"))
			System.out.println("suhas is present in Trie");
		else
			System.out.println("suhas is not present in Trie");
		if (my.search("suhass"))
			System.out.println("suhass is present in Trie");
		else
			System.out.println("suhass is not present in Trie");
	}

}
