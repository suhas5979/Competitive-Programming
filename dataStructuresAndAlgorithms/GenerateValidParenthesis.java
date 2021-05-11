package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.List;

public class GenerateValidParenthesis {

	// Runner
	public static void main(String[] args) {
		
		
		List<String> res = new ArrayList<>();
		generateParenthesis(new String(""), 2, 2, res);
		System.out.println(res);

	}
	
	static void generateParenthesis(String s,int open ,int close,List<String> res) {
		if(open ==0 & close == 0) {
			res.add(new String(s));
			return;
		}
		if(open > 0) {
			String newString = new String(s+"(");
			generateParenthesis(newString, open-1, close, res);
		}
		if(open < close) {
			String newString = new String(s+")");
			generateParenthesis(newString, open, close-1, res);
		}
	}

}
