package builtInDatastructuresTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

class TestTest {

	public static void main(String[] args) {
		
		boolean [][] rotten = new boolean[3][6];
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(2);
		list.add(4);
		list.add(5);
		list.add(8);
		String str = "suhas";
		
		
		
		

	}

	static int printTour(int petrol[], int[] distance, int n) {
		int start = 0;
		int end = 1;
		int curr_petrol = petrol[start] - distance[start];
		while (end != start || curr_petrol < 0) {
			while (curr_petrol < 0 && start != end) {
				curr_petrol -= petrol[start] - distance[start];
				start = (start + 1) % n;
				if (start == 0)
					return -1;
			}
			curr_petrol += petrol[end] - distance[end];

			end = (end + 1) % n;
		}
		return start;
	}

}
