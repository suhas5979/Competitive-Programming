package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class CostOfConversion {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		System.out.println(minCost(str1, str2));

		sc.close();

	}

	static int minCost(String str1, String str2) {
		return minCost(str1, str2, str1.length(), str2.length(), 0, 0);
	}

	static int minCost(String str1, String str2, int n1, int n2, int p1, int p2) {
		System.out.println("str1 = " + str1 + "   str2 = " + str2);

		if (p1 == n1 && p2 == n2) {
			return 0;
		}
		if (p1 == n1) {
			return 1 + minCost(str1, str2.substring(0, p2) + str2.substring(p2 + 1, n2), n1, n2 - 1, p1, p2);
		}
		if (p2 == n2) {
			return 1 + minCost(str1, str2.substring(0, p2) + str1.charAt(p1) + str2.substring(p2, n2), n1, n2 + 1,
					p1 + 1, p2 + 1);
		}
		
		// done
		if (str1 == str2)
			return 0;
		// 0 cost
		if (str1.charAt(p1) == str2.charAt(p2)) {
			return minCost(str1, str2, n1, n2, p1 + 1, p2 + 1);
		} else {
			// Insert
			int c1 = 1 + minCost(str1, str2.substring(0, p2) + str1.charAt(p1) + str2.substring(p2, n2), n1, n2 + 1,
					p1 + 1, p2 + 1);
			// Delete
			int c2 = 1 + minCost(str1, str2.substring(0, p2) + str2.substring(p2 + 1, n2), n1, n2 - 1, p1 + 1, p2);
			// Update
			int c3 = 1 + minCost(str1, str2.substring(0, p2) + str1.charAt(p1) + str2.substring(p2 + 1, n2), n1, n2, p1,
					p2);

			int min = Math.min(c1, c2);

			return Math.min(c3, min);
		}
	}

}
