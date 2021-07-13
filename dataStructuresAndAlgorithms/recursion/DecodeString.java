package dataStructuresAndAlgorithms.recursion;

import java.util.Scanner;
import java.util.Stack;

public class DecodeString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(decodedString(str));
	}

	static String decodedString(String str) {
		String res = "";
		Stack<Integer> st = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		for(int i=0;i< str.length();i++) {
			if(str.charAt(i) ==']') {
				String s = "";
				while(st2.peek() !='[') {
					s = st2.pop() + s;
				}
				int n = st.pop();
				String newSeq = "";
				for(int j=0;j<n;j++)
					newSeq += s;
				st2.pop();
				for(int j=0;j<newSeq.length();j++)
					st2.push(newSeq.charAt(j));
			}
			else if(str.charAt(i) >=48 && str.charAt(i) <=57) {
				st.push(str.charAt(i)-'0');
			}else if(str.charAt(i) >= 97) {
				st2.push(str.charAt(i));
			}else if(str.charAt(i) =='[') {
				st2.push(str.charAt(i));
			}
		}
		while(!st2.isEmpty())
			res = st2.pop() + res;
		return res;
	}

}

// Test case 

//3[a3[b]1[ab]]
