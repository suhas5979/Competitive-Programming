package dataStructuresAndAlgorithms.recursion;

import java.util.LinkedList;
import java.util.Scanner;

public class JosephusProblem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();

		sc.close();
		System.out.println(josephus(n, k));

	}
	static int josephus(int n,int k) {
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=1;i<=n;i++)
			list.add(i);
		return josephus(n,k,list,0);
	}
	private static int josephus(int n, int k, LinkedList<Integer> list,int cur) {
		if(list.size()==1)
			return list.get(0);
		int killIndex = (cur +(k-1))%list.size();
		list.remove(killIndex);
		return josephus(n, k, list, killIndex);	
	}

}
