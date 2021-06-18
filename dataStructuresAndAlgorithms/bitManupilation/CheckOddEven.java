package dataStructuresAndAlgorithms.bitManupilation;

import java.util.Scanner;

public class CheckOddEven {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		check(n);

	}
	static void check(int n) {
		if((n &1) == 1) {
			System.out.println("given number is Odd");
		}else {
			System.out.println("given number is even");
		}
	}

}
