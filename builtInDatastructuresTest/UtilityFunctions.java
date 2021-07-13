package builtInDatastructuresTest;

public class UtilityFunctions {
	public static void printArray(int[] arr) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		System.out.println();

	}

	public static void printArray(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++)
				System.out.print(arr[i][j] + ",");
			System.out.println();
		}
		System.out.println();

	}

	public static void printArray(Boolean[] arr) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + ",");
		}
		System.out.println();
		System.out.println();

	}

}
