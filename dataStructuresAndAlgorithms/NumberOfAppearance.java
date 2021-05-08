package dataStructuresAndAlgorithms;

public class NumberOfAppearance {

	// Runner
	public static void main(String[] args) {
		
		int[] nums = new int[] {5,2,3,4,5,6,7,8,9,10,5};
		System.out.println(numsOfAppearance(nums, 1));
	}
	public static int numsOfAppearance(int[] arr, int n) {
		int[] hash = new int[arr.length];
		for(int i=0;i<arr.length;i++) {
			hash[arr[i]]++;
		}
		return hash[n];
	}

}
