package dataStructuresAndAlgorithms.greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BuyMaximumStocks {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int arr[] = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		int[] res = maxStocks(arr, n, k);
		for(int num :res) {
			System.out.print(num+" ");
		}

	}

	static int[] maxStocks(int[] arr, int n, int k) {
		pair[] stocks = new pair[n];
		for (int i = 0; i < n; i++) {
			stocks[i] = new pair(arr[i], i + 1);
		}
		Arrays.sort(stocks, (o1, o2) -> {
			return o1.price - o2.price;
		});
		int count = 0;
		int amount = 0;
		for (int i = 0; i < n; i++) {
			int aukat = k / stocks[i].price;
			if (aukat > stocks[i].max) {
				count += stocks[i].max;
				amount += stocks[i].max * stocks[i].price;
				k -= (stocks[i].max * stocks[i].price);
			} else {
				count += aukat;
				k -= (aukat * stocks[i].price);
				amount += (aukat * stocks[i].price);
			}
		}

		return new int[] {count ,amount};
	}

	static class pair {
		int price, max;

		pair(int p, int m) {
			this.price = p;
			this.max = m;
		}
	}
}

// Test case

//3
//43
//10 7 19



