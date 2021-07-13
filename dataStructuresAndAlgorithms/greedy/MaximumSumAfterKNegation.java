package dataStructuresAndAlgorithms.greedy;

import java.util.Scanner;
import java.util.TreeSet;

public class MaximumSumAfterKNegation {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(maxSum(arr, n, k));

	}
	static int maxSum(int[] arr,int n ,int k) {
		int sum =0;
		TreeSet<Integer> set = new TreeSet<>();
		int min = Integer.MAX_VALUE;
		for(int i=0;i<n;i++) {
			sum += arr[i];
			if(arr[i]< 0) {
				set.add(arr[i]);
			}
			if(arr[i] == 0)
				continue;
			min = Math.min(min, Math.abs(arr[i]));
		}
		System.out.println("sum"+ sum+"min="+min);
		while(k > 0 && !set.isEmpty()) {
			System.out.println(set.first());
			sum += (-2*set.pollFirst());
			k--;
		}
		if(k !=0 && k %2 ==0) {
			return sum;
		}else if(k != 0 && k % 2==1) {
			sum -= min;
			return sum;
		}
		return sum;
	}

}

// Test case

//10
//5
//5 -2 5 -4 5 -12 5 5 5 20


