package dataStructuresAndAlgorithms;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CommonElementsInSortedArrays {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int n3 = sc.nextInt();
		int arr1[] = new int[n1];
		int arr2[] = new int[n2];
		int arr3[] = new int[n3];
		for (int i = 0; i < n1; i++) {
			arr1[i] = sc.nextInt();
		}
		for (int i = 0; i < n2; i++) {
			arr2[i] = sc.nextInt();
		}
		for (int i = 0; i < n3; i++) {
			arr3[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(commonElements(arr1, arr2, arr3, n1, n2, n3));

	}
    static ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0;i< n1;i++){
            map.putIfAbsent(A[i],1);
        }
        for(int i=0;i< n2;i++){
            if(map.getOrDefault(B[i],0) == 1){
                map.put(B[i] ,2);
            }
        }
        for(int i=0;i< n3;i++){
            if(map.getOrDefault(C[i],0) == 2){
                map.put(C[i] ,3);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry :map.entrySet()){
            if(entry.getValue() == 3){
                res.add(entry.getKey());
            }
        }
        return res;
    }

}

// Test Case 1

//5
//4
//6
//1 3 4 6 8
//4 8 9 12 
//1 2 4 6 7 8



