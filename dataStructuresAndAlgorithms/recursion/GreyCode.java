package dataStructuresAndAlgorithms.recursion;

import java.util.ArrayList;
import java.util.Scanner;

public class GreyCode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		System.out.println(generate(n));
	}

	static ArrayList<String> generate(int n) {
		if (n == 1) {
			ArrayList<String> res = new ArrayList<>();
			res.add("0");
			res.add("1");
			return res;
		}
		ArrayList<String> res = generate(n - 1);
		ArrayList<String> temp = new ArrayList<>();
		for (int i = 0; i < res.size(); i++)
			temp.add('0' + res.get(i));
		for (int i = res.size() - 1; i >= 0; i--)
			temp.add('1' + res.get(i));
		return temp;
	}

}
