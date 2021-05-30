package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class ValidShuffle {

	// Runner
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = sc.nextLine();
		String str2 = sc.nextLine();
		String strShuffle = sc.nextLine();

		sc.close();
		System.out.println(validShuffle(str1, str2, strShuffle));

	}

	static boolean validShuffle(String str1, String str2, String shuffle) {
		int ptr1 = 0;
		int n1 = str1.length();
		int ptr2 = 0;
		int n2 = str2.length();
		int ptrShuffle = 0;
		int n3 = shuffle.length();
		while (ptrShuffle < n3 && ptr1 < n1 && ptr2 < n2) {
			if (str1.charAt(ptr1) == shuffle.charAt(ptrShuffle)) {
				ptr1++;
			}
			if (str2.charAt(ptr2) == shuffle.charAt(ptrShuffle)) {
				ptr2++;
			}
			ptrShuffle++;
		}
		while (ptrShuffle < n3 && ptr1 < n1) {
			if (str1.charAt(ptr1) == shuffle.charAt(ptrShuffle)) {
				ptr1++;
			}
			ptrShuffle++;
		}
		while (ptrShuffle < n3 && ptr2 < n2) {
			if (str2.charAt(ptr2) == shuffle.charAt(ptrShuffle)) {
				ptr2++;
			}
			ptrShuffle++;
		}
		return ptr1 == n1 && ptr2 == n2 && ptrShuffle == n3;
	}

}

// Sample Test case 

//abcdef
//xyzw
//axbcyzdwef

// Sample Test case 2

//abcdef
//xyzw
//axbczydwef
