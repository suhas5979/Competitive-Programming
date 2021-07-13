package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class InterlevedString {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String b = sc.nextLine();
		String c = sc.nextLine();
		sc.close();
		System.out.println(isInterleaved(a, b, c));
	}

	static boolean isInterLeave(String a, String b, String c) {
		return isInter(a, 0, b, 0, c, 0);
	}

	static boolean isInter(String a, int cur1, String b, int cur2, String c, int cur3) {
		if (cur3 == c.length())
			return true;
		boolean bool1 = false;
		if (cur1 < a.length() && a.charAt(cur1) == c.charAt(cur3)) {
			bool1 = isInter(a, cur1 + 1, b, cur2, c, cur3 + 1);
		}
		boolean bool2 = false;
		if (cur2 < b.length() && b.charAt(cur2) == c.charAt(cur3)) {
			bool2 = isInter(a, cur1, b, cur2 + 1, c, cur3 + 1);
		}
		return bool1 || bool2;
	}

	static boolean isInterleaved(String A, String B, String C) {

// Find lengths of the two strings
		int M = A.length(), N = B.length();

// Let us create a 2D table to store
// solutions of subproblems. C[i][j] 
// will br true if C[0..i+j-1] is an
// interleaving of A[0..i-1] and B[0..j-1].
		boolean IL[][] = new boolean[M + 1][N + 1];

// IL is default initialised by false

// C can be an interleaving of A and B
// only if the sum of lengths of A and B
// is equal to length of C
		if ((M + N) != C.length())
			return false;

// Process all characters of A and B

		for (int i = 0; i <= M; i++) {
			for (int j = 0; j <= N; j++) {

// Two empty strings have an
// empty strings as interleaving
				if (i == 0 && j == 0)
					IL[i][j] = true;

// A is empty
				else if (i == 0) {
					if (B.charAt(j - 1) == C.charAt(j - 1))
						IL[i][j] = IL[i][j - 1];
				}

// B is empty
				else if (j == 0) {
					if (A.charAt(i - 1) == C.charAt(i - 1))
						IL[i][j] = IL[i - 1][j];
				}

// Current character of C matches
// with current character of A, 
// but doesn't match with current
// character if B
				else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) != C.charAt(i + j - 1))
					IL[i][j] = IL[i - 1][j];

// Current character of C matches
// with current character of B, but
// doesn't match with current
// character if A
				else if (A.charAt(i - 1) != C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
					IL[i][j] = IL[i][j - 1];

// Current character of C matches
// with that of both A and B
				else if (A.charAt(i - 1) == C.charAt(i + j - 1) && B.charAt(j - 1) == C.charAt(i + j - 1))
					IL[i][j] = (IL[i - 1][j] || IL[i][j - 1]);
			}
					
			
		}
		for (int ii = 0; ii <= M; ii++) {
			for (int jj = 0; jj <= N; jj++)
				System.out.print(IL[ii][jj]+" ");
			System.out.println();
		}
		return IL[M][N];
	}

}
