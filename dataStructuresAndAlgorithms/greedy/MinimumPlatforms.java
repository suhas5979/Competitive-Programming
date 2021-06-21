package dataStructuresAndAlgorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPlatforms {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int dep[] = new int[n];
		for (int i = 0; i < n; i++) {
			dep[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(findPlatform(arr, dep, n));

	}
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int count=0;
        int i=0,j=0;
        int occupied =0;
        while(i < n){
            if(arr[i] > dep[j]){
                occupied--;
                j++;
            }else{
                occupied++;
                count = Math.max(count,occupied);
                i++;
            }
        }
        return count;
    }

}
