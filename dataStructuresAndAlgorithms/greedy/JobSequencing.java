package dataStructuresAndAlgorithms.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class JobSequencing {
	static class Job {
		int id, deadline, profit;

		Job(int x, int y, int z) {
			this.id = x;
			this.deadline = y;
			this.profit = z;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Job arr[] = new Job[n];
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt();
			arr[i] = new Job(x, y, z);
		}
		sc.close();
		int[] res = JobScheduling(arr, n);
		System.out.println(res[0] + " " + res[1]);

	}

	static int[] JobScheduling(Job arr[], int n) {
		Arrays.sort(arr, (o1, o2) -> {
			return o2.profit - o1.profit;
		});
		int maxDeadline = 0;
		for (int i = 0; i < n; i++) {
			maxDeadline = Math.max(maxDeadline, arr[i].deadline);
		}
		int[] schedule = new int[maxDeadline];
		int count = 0;
		int maxProfit = 0;
		for (int i = 0; i < n; i++) {
			int index = arr[i].deadline - 1;
			while (index >= 0 && schedule[index] != 0)
				index--;
			if (index == -1)
				continue;
			schedule[index] = arr[i].id;
			count++;
			maxProfit += arr[i].profit;

		}
		return new int[] { count, maxProfit };

	}

	static class pair {
		int deadline, profit;

		pair(int d, int p) {
			this.deadline = d;
			this.profit = p;
		}

		@Override
		public String toString() {
			return "[" + deadline + "," + profit + "]";
		}
	}

}

//17
//1 56 288 2 27 435 3 67 401 4 64 368 5 94 248 6 54 361 7 43 108 8 96 167 9 73 251 10 96 170 11 14 156 12 78 184 13 61 370 14 77 424 15 68 397 16 40 375 17 36 218
