package dataStructuresAndAlgorithms.string;

import java.util.HashMap;
import java.util.Scanner;

public class RomanToInteger {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(romanToInteger(str, str.length()));
	}

	static int romanToInteger(String str, int n) {
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		for (int i = 0; i < n; i++) {
			if (i < n - 1 && map.get(str.charAt(i)) < map.get(str.charAt(i + 1))) {
				res += (map.get(str.charAt(i + 1)) - map.get(str.charAt(i)));
				i++;
			}else {
				res += map.get(str.charAt(i));
			}
		}
		
		return res;
	}

}
