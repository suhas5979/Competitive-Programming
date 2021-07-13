package dataStructuresAndAlgorithms.arrays;

public class WaveShuffle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public static void convertToWave(int arr[], int n){
        
        int temp=0;
        for(int i=0;i<n-1;i=i+2){
           temp = arr[i];
           arr[i] = arr[i+1];
           arr[i+1] = temp;
        }
        
    }

}
