package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class PallindromicString {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		sc.close();
		System.out.println(isPlaindrome(s));

	}
	static int isPlaindrome(String S) {
        int left = 0;
        int right = S.length() -1;
        while(left < right){
            if(S.charAt(left) != S.charAt(right)){
               return 0; 
            }
            left++;
            right--;
        }
        return 1;
    }

}
