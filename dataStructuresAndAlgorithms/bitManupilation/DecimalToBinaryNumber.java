package dataStructuresAndAlgorithms.bitManupilation;

import java.util.Scanner;

public class DecimalToBinaryNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		System.out.println(convert(n));

	}
	static String convert(int n) {
		String res = "";
		while(n !=0) {
			int rem = n % 2;
			res = rem +res;
			n = n/2;
		}
		return res;
	}

}
