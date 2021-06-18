package dataStructuresAndAlgorithms.sortingAndSearching;

import java.util.Scanner;

public class NthRootOfNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		sc.close();
		System.out.println(nthRoot(n, m));
	}
	static double nthRoot(int n,int m) {
		double left =1;
		double right = n;
		double res = Double.MAX_VALUE;
		double eps = 0.0001;
		while((right -left) > eps) {
			double mid = (left +right) /2.0;
			if(Math.pow(mid, (double) m) > n) {
				res = Math.min(res, mid);
				right = mid;
			}else {
				left = mid;
			}
			System.out.println(res);
		}
		return res;
	}

}
