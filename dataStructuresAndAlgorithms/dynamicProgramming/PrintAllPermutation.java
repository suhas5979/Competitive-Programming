package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintAllPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String  str = sc.nextLine();

		sc.close();
		ArrayList<String> res = permutation(str);
		System.out.println(res);
		System.out.println(res.size());

	}
	static ArrayList<String> permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		permutation(str,res,"",str.length());
		return res;
	}
	 static void permutation(String str, ArrayList<String> res,String cur,int n) {
		 if(cur.length() >= n) {
			res.add(cur);
			return;
		}
		for(int i=0;i< n;i++) {
			if(!cur.contains(str.charAt(i)+"")) {
				String s= cur + str.charAt(i);
				permutation(str,res,s,n);
			}
		}
		
	}

}
