package dataStructuresAndAlgorithms.arrays;

public class RearrangeWithoutExtraSpace {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static void arrange(long arr[], int n) {
		for (int i = 0; i < n; i++) {
			long old = arr[i];
			long neww = arr[(int) old] % n;
			long converted = old + (neww % n) * n;
			arr[i] = converted;
		}
		for (int i = 0; i < n; i++)
			arr[i] = arr[i] / n;
	}

}
