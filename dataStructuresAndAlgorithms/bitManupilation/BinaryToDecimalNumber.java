package dataStructuresAndAlgorithms.bitManupilation;

import java.util.Scanner;

public class BinaryToDecimalNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(convert(str));

	}
	static int convert(String str) {
		int res =0;
		int n = str.length();
		int ptr = n-1;
		for(int i=0;i<n;i++) {
			res = res + (str.charAt(ptr--)-'0') * pow(2, i);
		}
		return res;
	}
	static int pow(int a ,int b) {
		int res = 1;
		if(b==0)
			return res;
		else {
			for(int i=0;i<b;i++) {
				res *= a;
			}
		}
		return res;
	}

}

// Test Case 1

//10000100
