package dataStructuresAndAlgorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CandyShop {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(candyStore(arr, n, k));

	}
    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        Arrays.sort(candies);
        int right = N-1;
        int left = 0;
        int min =0;
        int max =0;
        while(right >=0 && left < N && left <= right){
            min += candies[left];
            left++;
            right-=K;
        }
        right = N-1;
        left = 0;
        while(right >=0 && left < N && left <= right){
            max += candies[right];
            right--;
            left +=K;
        }
        ArrayList<Integer> res = new ArrayList<>();
        res.add(min);
        res.add(max);
        return res;
    }

}

// Test case

//5 2
//3 2 5 1 4
