package dataStructuresAndAlgorithms;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class UnionCountInSet {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
		}

		int b[] = new int[m];
		for (int i = 0; i < m; i++) {
			b[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(doUnion(a, n, b, m));

	}

	static int doUnion(int a[], int n, int b[], int m) {
		int count = 0;
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < n; i++) {
			if (set.contains(a[i]))
				continue;
			set.add(a[i]);
			count++;
		}
		for (int i = 0; i < m; i++) {
			if (set.contains(b[i])) {
				continue;
			}
			set.add(b[i]);
			count++;
		}
		return count;
	}

}

// Sample Test Case 1

//6 2 
//85 25 1 32 54 6
//85 2
