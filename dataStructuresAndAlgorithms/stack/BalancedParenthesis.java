package dataStructuresAndAlgorithms.stack;

import java.util.Scanner;
import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(ispar(str));
	}
	
	static boolean ispar(String x)
    {
        if(x.length() == 0 ) return true;
        Stack<Character> st = new Stack<>();
        for(int i=0;i<x.length();i++){
        	System.out.println(st);
            if(x.charAt(i) == '(' || x.charAt(i) == '[' || x.charAt(i) == '{'){
                st.push(x.charAt(i));
                continue;
            }
            if(st.isEmpty()) return false;
            if(x.charAt(i) == ')' && st.peek() == '('){
                 st.pop();
            }
            if(x.charAt(i) == ']' && st.peek() == '[') {
                st.pop();
            }
            if(x.charAt(i) == '}' && st.peek() == '{'){
                st.pop();
            } 
        }
        return st.isEmpty();
    }

}

// {}{(}))}