package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class SplitBinaryString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(split(str, str.length()));
	}

	static int split(String str, int n) {
		int count = 0;
		int[] hash = new int[2];
		for (int i = 0; i < n; i++) {
			hash[str.charAt(i) - '0']++;
			if (hash[0] == hash[1]) {
				count++;
				hash[0] = 0;
				hash[1] = 0;
			}
		}
		return count == 0 ? -1 : count;
	}

}
