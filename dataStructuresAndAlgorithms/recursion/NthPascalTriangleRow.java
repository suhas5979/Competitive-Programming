package dataStructuresAndAlgorithms.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class NthPascalTriangleRow {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		System.out.println(pascalRow(n));
	}

	static ArrayList<Integer> pascalRow(int n){
		ArrayList<Integer> res = new ArrayList<>();
		res.add(0);
		res.add(1);
		res.add(0);
		for(int i=1;i<n;i++) {
			res.add(0, 0);
			for(int j=1;j<res.size()-1;j++) {
				res.set(j, res.get(j)+res.get(j+1));
			}
		}
		res.remove(0);
		res.remove(res.size()-1);
		return res;
	}

}
