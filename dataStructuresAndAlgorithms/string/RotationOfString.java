package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class RotationOfString {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();

		sc.close();

		System.out.println(checkForRotation(str1, str2));

	}

	static boolean checkForRotation(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		String temp = str2.concat(str2);
		return temp.contains(str1);
	}

}

// Sample Test case 

//ABCDEFGHI
//FGHIABCDE

//Sample Test case 2

//ABCDEFGHI
//FGHIABCDDF
