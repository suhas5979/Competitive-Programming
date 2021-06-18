package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class RemoveAllAdjecentDuplicateInString {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(removeConsecutive(str));

	}

	static String remove(String str) {
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) == str.charAt(i + 1)) {
				if (i + 2 < str.length())
					return remove(str.substring(0, i) + str.substring(i + 2, str.length()));
				else
					return remove(str.substring(0, i));

			}
		}
		return str;
	}
	static String removeConsecutive(String S) {
        String res = "";
        char prev = S.charAt(0);
        for(int i=1;i<S.length();i++){
           if(S.charAt(i) != prev){
               res += prev;
               prev = S.charAt(i);
           } 
        }
        res += prev;
        return res;
	}

}
