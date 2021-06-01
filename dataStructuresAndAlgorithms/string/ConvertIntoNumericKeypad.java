package dataStructuresAndAlgorithms.string;

import java.util.HashMap;
import java.util.Scanner;

public class ConvertIntoNumericKeypad {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(convert(str, str.length()));

	}

	static String convert(String str, int n) {
		HashMap<Character, String> map = new HashMap<>();
		map.put(' ', "0");
		map.put('A', "2");
		map.put('B', "22");
		map.put('C', "222");
		map.put('D', "3");
		map.put('E', "33");
		map.put('F', "333");
		map.put('G', "4");
		map.put('H', "44");
		map.put('I', "444");
		map.put('J', "5");
		map.put('K', "55");
		map.put('L', "555");
		map.put('M', "6");
		map.put('N', "66");
		map.put('O', "666");
		map.put('P', "7");
		map.put('Q', "77");
		map.put('R', "777");
		map.put('S', "7777");
		map.put('T', "8");
		map.put('U', "88");
		map.put('V', "888");
		map.put('W', "9");
		map.put('X', "99");
		map.put('Y', "999");
		map.put('z', "9999");

		String res = "";
		for (int i = 0; i < n; i++) {
			res += map.get(str.charAt(i));
		}

		return res;
	}

}
