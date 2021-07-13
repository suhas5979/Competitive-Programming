package dataStructuresAndAlgorithms.recursion;

import java.util.Scanner;

public class LastNonZeroDigitInFactorial {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		nonZero(n);

	}
	static void nonZero(int n) {
		int last =n;
		for(int i=n-1;i>=2;i--) {
			last = last*i;
			while(last%10 ==0) {
				last = last/10;
			}
			last = last %100;
		}
		int digit = last%10;
		System.out.println(digit);
	}

}
