package builtInDatastructuresTest;

import java.util.Arrays;

public class ComparatorTest {

	public static void main(String[] args) {

		int[][] two = new int[][] { { 1, 4 }, { 123, 5 }, { 56, 98 }, { 34, 56 }, { 79, 90 }, { 23, 19 }, };

		Arrays.sort(two, (o1, o2) -> {
			return o1[1] - o2[1];
		});

		for (int[] arr : two) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
