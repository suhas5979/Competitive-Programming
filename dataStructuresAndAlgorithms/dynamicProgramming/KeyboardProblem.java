package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class KeyboardProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		System.out.println(keyboard(n));
	}
	static long keyboard(int n) {
		long [] memo = new long[n+1];
		long res= keyBoard(n,memo);
		return res;
	}
	static long keyBoard(int n, long[] memo) {
		if(n < 0) return 0;
		if(n <=6)
			return n;
		if(memo[n] == 0) {
		long max =0;
		for(int i=3;n-i >=0;i++) {
			long cur = (i-1) * keyBoard(n-i,memo);
			max = Math.max(max, cur);
		}
		memo[n] = max;
		}
		return memo[n];
	}
	

}
