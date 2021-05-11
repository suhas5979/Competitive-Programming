package dataStructuresAndAlgorithms;

public class BinarySearch {

	// Runner
	public static void main(String[] args) {

		int[] arr = new int[] { 11, 21, 31, 44, 56, 72, 100, 1, 2, 5, 8 };

		System.out.println(binarySearchOnRotatedArray(arr, 0, arr.length,100));
	}

	public static int binarySearch(int[] arr, int low, int high, int target) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] == target)
				return mid;
			else if (arr[mid] < target)
				low = mid + 1;
			else
				high = mid - 1;
		}
		return -1;
	}

	public static int pivotOfRotation(int[] arr, int low, int high) {
		if (high < low)
            return -1;
        if (high == low)
            return low;
		int mid = low + (high - low) / 2;
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid < high && arr[mid] < arr[mid - 1])
			return mid - 1;
		if (arr[low] <= arr[mid]) {
			return pivotOfRotation(arr, mid, high);
		} else {
			return pivotOfRotation(arr, low, mid);
		}
	}

	public static int binarySearchOnRotatedArray(int[] arr, int low, int high, int target) {
		int pivot = pivotOfRotation(arr, low, high - 1);
		return Math.max(binarySearch(arr, low, pivot, target), binarySearch(arr, pivot + 1, high, target));
	}

}
