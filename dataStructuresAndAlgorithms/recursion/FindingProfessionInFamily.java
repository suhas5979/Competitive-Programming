package dataStructuresAndAlgorithms.recursion;

import java.util.Scanner;

public class FindingProfessionInFamily {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int level = sc.nextInt();
		int pos = sc.nextInt();

		sc.close();
		System.out.println(findProffesion(level, pos));
	}

	static char findProffesion(int level, int pos) {
		System.out.println("level =" + level + " pos=" + pos);
		if (level == 1)
			return 'e';
		if (findProffesion(level - 1, (pos + 1) / 2) == 'd')
			return (pos % 2 > 0) ? 'd' : 'e';
		return (pos % 2 > 0) ? 'e' : 'd';
	}

	static int countSetBits(int n) {
		int count = 0;
		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}

	static char profession(int level, int pos) {
		int c = countSetBits(pos - 1);
		return (c % 2 != 0) ? 'd' : 'e';
	}

}
