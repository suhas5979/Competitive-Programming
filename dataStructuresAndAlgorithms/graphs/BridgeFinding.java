package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Scanner;


public class BridgeFinding {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer> adj[] = new ArrayList[n];
		for (int i = 0; i < n; i++)
			adj[i] = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a--;
			b--;
			adj[a].add(b);
			adj[b].add(a);
		}
		findBridges(adj, n);

	}

	static void dfs(ArrayList<Integer>[] adj, boolean[] visited, int[] timeOfIns, int[] lowestTime, int cur,
			int parent,int timer) {
		visited[cur] = true;
		timeOfIns[cur] = timer;
		lowestTime[cur] = timer;
		timer++;
		for (int v : adj[cur]) {
			if (v == parent)
				continue;
			if (!visited[v]) {
				dfs(adj, visited, timeOfIns, lowestTime, v, cur,timer);
				lowestTime[cur] = Math.min(lowestTime[v], lowestTime[cur]);
				if (lowestTime[v] > lowestTime[cur])
					System.out.println("bridge " + (cur+1) + " -> " + (v+1));

			} else {
				lowestTime[cur] = Math.min(lowestTime[cur], timeOfIns[v]);
			}
		}

	}

	static void findBridges(ArrayList<Integer>[] adj, int n) {
		boolean visited[] = new boolean[n];
		int timeOfIns[] = new int[n];
		int lowestTime[] = new int[n];
		int timer =1;
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				dfs(adj, visited, timeOfIns, lowestTime, i, i,timer);
			}
		}
	}
}

// Test Case

//12 14
//1 2
//2 3
//4 3
//4 1
//4 5
//5 6
//6 7
//6 9
//7 8
//9 8
//8 10
//10 11 
//11 12
//12 10



