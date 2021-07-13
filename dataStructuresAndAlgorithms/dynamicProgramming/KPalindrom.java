package dataStructuresAndAlgorithms.dynamicProgramming;

import java.util.Scanner;

public class KPalindrom {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int n = sc.nextInt();
		sc.close();
		System.out.println(kPallin(str, n));
	}
    static boolean kPallin(String str,int k){
    	System.out.println(str);
        if(k==0)
            return isPallin(str);
        for(int i=0;i<str.length();i++){
            boolean res = kPallin(str.substring(0,i)+str.substring(i+1,str.length()),k-1);
            if(res)
                return true;
        }
        return false;
    }
    static boolean isPallin(String str){
        int right = str.length()-1;
        int left = 0;
        while(left <right){
            if(str.charAt(left) != str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
    
}

// Test Case

//nhabans

//qwertyuiopllkmjnhbgvfcdxszaqwertyuiopllkmjnhbgvfcdxszaqwertyuiopllkmjnhbgvfcdxszaqwertyuiopllkmjnhbgvfcdxsza

