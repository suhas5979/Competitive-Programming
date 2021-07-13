package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromicPartition {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(allPalindromicPerms(str));

	}
	
static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
	ArrayList<ArrayList<String>> partitions = new ArrayList<>();
	ArrayList<String> temp = new ArrayList<>();
	return  addStrings(partitions, S, temp, 0);
    }

	static boolean checkPalindrome(String str) {
		int len = str.length();
		len--;
		for (int i = 0; i < len; i++) {
			if (str.charAt(i) != str.charAt(len))
				return false;
			len--;
		}
		return true;
	}

	static ArrayList<ArrayList<String>> addStrings(ArrayList<ArrayList<String>> v, String s, ArrayList<String> temp,
			int index) {
		int len = s.length();
		String str = "";
		ArrayList<String> current = new ArrayList<>(temp);

		if (index == 0)
			temp.clear();

		for (int i = index; i < len; ++i) {
			str = str + s.charAt(i);
			System.out.println(str);
			if (checkPalindrome(str)) {
				temp.add(str);

				if (i + 1 < len) {
					v = addStrings(v, s, temp, i + 1);
				} else {
					v.add(temp);
				}
				temp = new ArrayList<>(current);
			}
		}
		return v;
	}

}
