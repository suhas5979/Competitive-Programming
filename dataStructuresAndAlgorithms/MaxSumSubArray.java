package dataStructuresAndAlgorithms;

import java.util.Scanner;

public class MaxSumSubArray {

	// Runner
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(maxSubarraySum(arr, n));

	}
	static int maxSubarraySum(int arr[], int n){
        int max = Integer.MIN_VALUE;
        int curMax = 0;
        for(int i=0;i<n;i++){
            curMax += arr[i];
            max= Math.max(max,curMax);
            if(curMax < 0) curMax =0;
        }
        return max;
        
    }

}

// Sample Test Case 1

//5
//1 -3 2 4 -2

// Sample Test Case 2

//5
//-5 -2 -1 -6 -3

