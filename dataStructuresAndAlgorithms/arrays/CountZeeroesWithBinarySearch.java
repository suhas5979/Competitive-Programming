package dataStructuresAndAlgorithms.arrays;

public class CountZeeroesWithBinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int countZeroes(int[] arr, int n) {
		if (n == 1)
			return arr[0] == 1 ? 0 : 1;
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (arr[mid] > arr[mid + 1]) {
				return (n - mid - 1);
			} else if (arr[mid] == 1) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return n;
	}

}
