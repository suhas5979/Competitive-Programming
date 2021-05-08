package dataStructuresAndAlgorithms;

public class PrefixSum {
	// Runner
	public static void main(String[] args) {
		
		int[] nums = new int[] {1,2,3,4,5,6,7,8,9,10};
	
		System.out.println(calculateSum(nums, 1, 10));

	}
	public static int calculateSum(int[] arr, int l ,int r) {
		int[] prefix = new int[arr.length+1];
		for(int i=1;i<prefix.length;i++) {
			prefix[i] = prefix[i-1] + arr[i-1];
		}
		
		return prefix[r] - prefix[l-1];
	}

}
