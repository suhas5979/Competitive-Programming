package dataStructuresAndAlgorithms.arrays;

public class BitonicPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int find(int[] arr, int n) {
		int left = 0;
		int right = n - 1;
		while (left <= right) {
			int mid = (left + right) >> 1;
			if (mid > 0 && mid < n - 1 && arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
				return arr[mid];
			} else if (mid < n - 1 && arr[mid] > arr[right] && arr[mid] > arr[mid + 1]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return arr[n - 1];
	}

}
