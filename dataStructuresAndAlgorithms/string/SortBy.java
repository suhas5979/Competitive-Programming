package dataStructuresAndAlgorithms.string;

import java.util.Scanner;

public class SortBy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		sc.close();
		System.out.println(caseSort(str));
	}
	public static String caseSort(String str)
    {
        int [] hash1 = new int[26];
        int [] hash2 = new int[26];
        int n = str.length();
        for(int i=0;i<n;i++){
            if(str.charAt(i) < 97)
                hash1[str.charAt(i)-'A']++;
            else
                hash2[str.charAt(i)-'a']++;
        }
        for(int j=0;j<26;j++) {
            
        System.out.print(hash1[j]+" ");
        }
        System.out.println();
        for(int j=0;j<26;j++) {
            
            System.out.print(hash2[j]+" ");
            }
        String res ="";
        for(int i=0;i<n;i++){
            if(str.charAt(i) < 97){
               for(int j=0;j<26;j++) {
                   if(hash1[j] >0){
                       res = res + (char) (j +'A');
                       hash1[j]--;
                       break;
                   }
               }
            }else{
                for(int j=0;j<26;j++) {
                   if(hash2[j] >0){
                       res = res + (char) (j +'a');
                       hash2[j]--;
                       break;
                   }
               }
            }
            System.out.println(res);
        }
        return res;
    }

}
