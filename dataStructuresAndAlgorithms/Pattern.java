package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class Pattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		pallindromicNumberPattern(n);
	}

	static void pallindromicNumberPattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j >= 1; j--)
				System.out.print("  ");
			for (int j = i; j >= 1; j--)
				System.out.print(j + " ");
			for (int j = 2; j <= i; j++)
				System.out.print(j + " ");
			for (int j = n - i; j >= 1; j--)
				System.out.print("  ");
			System.out.println();
		}
	}

	static void numberPattern(int n) {
		for (int i = n; i >= 1; i--) {
			int counter = 1;
			for (int j = 1; j <= n; j++) {
				if (j < i)
					System.out.print(" ");
				else
					System.out.print(counter++ + " ");
			}
			System.out.println();
		}
	}

	static void rhombus(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n - i; j >= 1; j--)
				System.out.print(" ");
			for (int j = n; j >= 1; j--)
				System.out.print("* ");
			for (int j = i; j >= 0; j--)
				System.out.print(" ");
			System.out.println();
		}
	}

	static void zeroOnePattern(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (((i + j) & 1) == 1)
					System.out.print("0 ");
				else
					System.out.print("1 ");
			}
			System.out.println();
		}
	}

	static void invertedNumber(int n) {
		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= i; j++)
				System.out.print(j + " ");
			System.out.println();
		}
	}

	static void butterfly(int n) {
		// upper
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				if (j < i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for (int j = n; j >= 1; j--) {
				if (j > i)
					System.out.print("  ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
		// bottom
		for (int i = n; i >= 1; i--) {
			for (int j = 0; j <= n; j++) {
				if (j < i)
					System.out.print("* ");
				else
					System.out.print("  ");
			}
			for (int j = n; j >= 1; j--) {
				if (j > i)
					System.out.print("  ");
				else
					System.out.print("* ");
			}
			System.out.println();
		}
	}

	static void invertedPyramid(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++)
				System.out.print("* ");
			System.out.println();
		}
	}

	static void floydTriangle(int n) {
		int counter = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(counter++ + " ");
			System.out.println();
		}
	}

	static void halfPyramidNumbers(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	static void halfPyramid(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = n; j > i; j--)
				System.out.print("  ");
			for (int j = i; j >= 1; j--)
				System.out.print("* ");
			System.out.println();
		}
	}

}
