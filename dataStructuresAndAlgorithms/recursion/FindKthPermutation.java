package dataStructuresAndAlgorithms.recursion;

import java.util.Scanner;

public class FindKthPermutation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = sc.nextInt();
		sc.close();
		System.out.println(findKthPermutation(str, n));
	}
	static String findKthPermutation(String str,int k) {
		if(k==0)
			return str;
		return findKthPermutation(str, k-1, "");
	}
	static String findKthPermutation(String str,int k,String cur) {
		if(k == 0)
			return cur +str;
		else {
			int per =fact(str.length())/str.length();
			int index = k /per;
			cur += str.charAt(index);
			return findKthPermutation(str.substring(0,index)+str.substring(index+1, str.length()), k % per, cur);	
		}
	}
	private static int fact(int n) {
		int fact = 1;
		for(int i =n;i>1;i--)
			fact *= i;
		return fact;
	}

}

// Test Case

//abcdef
//25
