package dataStructuresAndAlgorithms;

public class FastExponent {
	static int counter = 0;

	// Runner
	public static void main(String[] args) {

		System.out.println(fastExp(2, 10));

	}

	private static int fastExp(int a, int n) {
		int res = 1;
		while (n > 0) {
			if ((n & 1) != 0) {
				res *= a;
			}
			a *= a;
			n = n >> 1;
		}
		return res;
	}

	public static int normalExp(int a, int n) {
		int res = 1;
		while (n-- > 0) {
			res *= a;
		}
		return res;
	}

}
