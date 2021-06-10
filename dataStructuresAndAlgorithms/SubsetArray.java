package dataStructuresAndAlgorithms;

import java.util.HashMap;

public class SubsetArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    static String isSubset( long arr1[], long arr2[], long n, long m) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int i=0;i< n;i++){
            int num = (int) arr1[i];
            if(freq.containsKey(num)){
                freq.put(num,freq.get(num) + 1);
            }else{
                freq.put(num ,1);
            }
        }
        for(int i =0;i< m;i++){
            int num = (int) arr2[i];
            if(freq.containsKey(num)){
                int count = freq.get(num);
                if(count ==0){
                    return "NO";
                }else{
                    freq.put(num,count--);
                }
            }else{
                return "No";
            }
        }
        return "Yes";
        
    }

}
