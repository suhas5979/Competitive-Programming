package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a--;
			b--;
			adj[a].add(b);
			adj[b].add(a);
		}
		dfs(adj);

	}

	static void dfs(ArrayList<Integer>[] adj) {
		boolean visited[] = new boolean[adj.length];
		for (int i = 0; i < adj.length; i++) {
			if (!visited[i])
				dfs(adj, visited, i);

		}
	}

	static void dfs(ArrayList<Integer>[] adj, boolean[] visited, int source) {
		if (visited[source]) {
			return;
		}
		visited[source] = true;
		System.out.print(source +1 + " ");
		for (int v : adj[source])
			dfs(adj, visited, v);
	}

}
