package dataStructuresAndAlgorithms.string;

import java.util.Scanner;
import java.util.Stack;

public class SwapsForBracketBalancing {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(swapForBalancing(str, str.length()));
	}

	static int swapForBalancing(String str, int n) {
		int swaps = 0;
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < n; i++) {
			if (st.isEmpty()) {
				st.push(str.charAt(i));
				continue;
			}
			if (st.peek() == '[' && str.charAt(i) == ']') {
				st.pop();
				continue;
			}
			if (st.peek() == ']' && str.charAt(i) == '[') {
				swaps += st.size();
				st.pop();
				continue;
			}
			st.push(str.charAt(i));
		}

		return swaps;
	}

}
