package dataStructuresAndAlgorithms.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ActivitySelection {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int arr2[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = sc.nextInt();
		}
		sc.close();
		System.out.println(maxMeetings(arr, arr2, n));

	}
    static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<pair> m = new ArrayList<>();
        for(int i=0;i<n;i++){
           m.add(new pair(start[i],end[i]) );
        }
        Collections.sort(m,(o1,o2) ->{
            return o1.finish - o2.finish;
        });
        int time = 0;
        int count =0;
        for(int i=0;i<n;i++){
            if(m.get(i).start > time){
            	System.out.println("start = " +m.get(i).start+"end=" + m.get(i).finish);
                count++;
                time = m.get(i).finish;
            }
        }
        return count;
        
    }
    static class pair{
        int start,finish;
        pair(int start,int finish){
            this.start = start;
            this.finish = finish;
        }
    }

}
