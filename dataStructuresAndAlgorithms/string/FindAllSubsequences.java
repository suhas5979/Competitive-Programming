package dataStructuresAndAlgorithms.string;

import java.util.ArrayList;
import java.util.Scanner;

public class FindAllSubsequences {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(findAllSubsequences(str));

	}

	static ArrayList<String> findAllSubsequences(String str) {
		ArrayList<String> res = new ArrayList<>();
		findAll(str, "", res);
		return res;
	}

	static void findAll(String str, String cur, ArrayList<String> res) {
		if (0 == str.length()) {
			if (cur.length() == 0)
				return;
			res.add(cur);
		} else {
			findAll(str.substring(1), cur, res);
			findAll(str.substring(1), cur + str.charAt(0), res);
		}
	}

}
