package dataStructuresAndAlgorithms.string;

import java.util.Scanner;
import java.util.Stack;

public class BracketReversalNeededForBalance {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(needed(str, str.length()));
	}

	static int needed(String str, int n) {
		if (n % 2 != 0) {
			return -1;
		}
		Stack<Character> st = new Stack<>();
		for (int i = 0; i < n; i++) {
			if (st.isEmpty()) {
				st.push(str.charAt(i));
				continue;
			}
			if (str.charAt(i) == '{') {
				st.push('{');
			} else {
				if (st.peek() == '{') {
					st.pop();
				} else {
					st.push('}');
				}
			}
		}
		int rev = 0;
		while (!st.isEmpty()) {
			if (st.peek() == '}') {
				rev++;
				st.pop();
				st.pop();
			} else {
				char cur = st.pop();
				if (cur == st.peek()) {
					rev++;
					st.pop();
				} else {
					rev += 2;
					st.pop();
				}
			}
		}
		return rev;
	}

}
