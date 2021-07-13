package dataStructuresAndAlgorithms.recursion;

import java.util.LinkedList;
import java.util.Scanner;

public class LuckyNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		System.out.println(isLucky(n));

	}
	
    public static boolean isLucky(int n)
    {
        LinkedList<Integer> list = new LinkedList<>();
        for(int i=1;i<=n;i++)
            list.add(i);
        return isLucky(list,2,n);
    }
    static boolean isLucky(LinkedList<Integer> list,int cur,int n){
        if(cur > list.size())
            return true;
        for(int i =cur-1;i < list.size();i = i+cur){
        	System.out.println(i);
            if(list.get(i)== n)
                return false;
           
        }
        System.out.println(list);
        return isLucky(list,cur +1,n);
    }

}
