package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class LongestCommomPrefix {

	public static void main(String[] args) {

		String arr[] = {"asheryry","ashehljljhlj","ashrtyrt","ashcvb"};
		System.out.println(longestPrefix(arr, 4));

	}

	static String longestPrefix(String[] arr, int n) {
		String longest = arr[0];
		for (int i = 0; i < n; i++) {
			String cur = arr[i];
			String newLongest ="";
			for(int k=0;k <cur.length() && k < longest.length();k++) {
				if(cur.charAt(k) == longest.charAt(k)) {
					newLongest += cur.charAt(k);
				}
			}
			longest = newLongest;
		}
		return longest;
	}

}
