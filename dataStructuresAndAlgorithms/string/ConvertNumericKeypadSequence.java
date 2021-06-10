package dataStructuresAndAlgorithms.string;

import java.util.HashMap;
import java.util.Scanner;

public class ConvertNumericKeypadSequence {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(convert(str, str.length()));

	}

	static String convert(String str, int n) {
		String res = "";
		HashMap<String, Character> map = new HashMap<>();
		map.put("0", ' ');
		map.put("2", 'A');
		map.put("22", 'B');
		map.put("222", 'C');
		map.put("3", 'D');
		map.put("33", 'E');
		map.put("333", 'F');
		map.put("4", 'G');
		map.put("44", 'H');
		map.put("444", 'I');
		map.put("5", 'J');
		map.put("55", 'K');
		map.put("555", 'L');
		map.put("6", 'M');
		map.put("66", 'N');
		map.put("666", 'O');
		map.put("7", 'P');
		map.put("77", 'Q');
		map.put("777", 'R');
		map.put("7777", 'S');
		map.put("8", 'T');
		map.put("88", 'U');
		map.put("888", 'V');
		map.put("9", 'W');
		map.put("99", 'X');
		map.put("999", 'Y');
		map.put("9999", 'Z');

		String cur = "" + str.charAt(0);
		for (int i = 1; i < n; i++) {
			if (str.charAt(i) == cur.charAt(0)) {
				cur += str.charAt(i);
			} else {
				res += map.get(cur);
				cur = "" + str.charAt(i);
			}
		}

		return res;
	}

}
