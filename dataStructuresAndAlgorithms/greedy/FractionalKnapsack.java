package dataStructuresAndAlgorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class FractionalKnapsack {
	static class Item {
		int value, weight;

		Item(int x, int y) {
			this.value = x;
			this.weight = y;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		Item arr[] = new Item[n];
		for (int i = 0; i < n; i++) {
			int value = sc.nextInt();
			int weight = sc.nextInt();
			arr[i] = new Item(value, weight);
		}
		sc.close();
		System.out.println(getMaxValue(arr, w, n));

	}

	private static double getMaxValue(Item[] arr, int capacity,int n) {
		ItemValue[] iVal = new ItemValue[n];

		for (int i = 0; i < n; i++) {
			iVal[i] = new ItemValue(arr[i].weight, arr[i].value, i);
		}

		Arrays.sort(iVal,(o1 ,o2) -> {
				return o2.cost.compareTo(o1.cost);
		});

		double totalValue = 0d;

		for (ItemValue i : iVal) {

			int curWt = (int) i.wt;
			int curVal = (int) i.val;

			if (capacity - curWt >= 0) {
				capacity = capacity - curWt;
				totalValue += curVal;
			} else {
				double fraction = ((double) capacity / (double) curWt);
				totalValue += (curVal * fraction);
				capacity = (int) (capacity - (curWt * fraction));
				break;
			}
		}

		return totalValue;
	}

	static class ItemValue {
		Double cost;
		double wt, val, ind;

		// item value function
		public ItemValue(int wt, int val, int ind) {
			this.wt = wt;
			this.val = val;
			this.ind = ind;
			cost = ((double) val / (double) wt);
		}
	}
}

//
//84 87
//78 16 94 36 87 43 50 22 63 28 91 10 64 27 41 27 73 37 12 19 68 30 83 31 63 24 68 36 30 3 23 9 70 18 94 7 12 43 30 24 22 20 85 38 99 25 16 21 14 27 92 31 57 24 63 21 97 32 6 26 85 28 37 6 47 30 14 8 25 46 83 46 15 18 35 15 44 1 88 9 77 29 89 35 4 2 55 50 33 11 77 19 40 13 27 37 95 40 96 21 35 29 68 2 98 3 18 43 53 7 2 31 87 42 66 40 45 20 41 30 32 18 98 22 82 26 10 28 68 7 98 4 87 16 7 34 20 25 29 22 33 30 4 20 71 19 9 16 41 50 97 24 19 46 47 2 22 6 80 39 65 29 42 1 94 1 35 15
