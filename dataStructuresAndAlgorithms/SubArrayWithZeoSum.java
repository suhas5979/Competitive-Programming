package dataStructuresAndAlgorithms;

import java.util.HashSet;
import java.util.Scanner;

public class SubArrayWithZeoSum {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(findsum(arr, n));

	}
    static boolean findsum(int arr[],int n)
    {
        int sum =0;
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i < n;i++){
            sum += arr[i];
            if(set.contains(sum)){
                return true;
            }else{
                set.add(sum);
            }
        }
        System.out.println(set);
        
        return false;
    }

}
