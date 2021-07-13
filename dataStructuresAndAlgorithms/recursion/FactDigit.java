package dataStructuresAndAlgorithms.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class FactDigit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		sc.close();
		System.out.println(FactDigit(n));

	}
	
    static ArrayList<Integer> FactDigit(int N)
    {
        int fact[] = {1,1,2,6,24,120,720,5040,40320,362880};
        ArrayList<Integer> res = new ArrayList<>();
        while(N !=0){
            for(int i=9;i>=1;i--){
                if(N > fact[i]){
                    res.add(i);
                    N -=fact[i];
                    break;
                }
            }
            if(N ==1) {
            	res.add(1);
            	break;
            }
            	
        }
        Collections.sort(res);
        for(int i=1;i<res.size();i++) {
        	if(res.get(i)==1) {
        		res.set(i, 0);
        	}else
        		break;
        }
        return res;
    }

}
