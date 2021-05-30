package dataStructuresAndAlgorithms.myDataStructures;

import java.util.*;
import java.util.LinkedList;

public class Graph {

	public static void main(String[] args) {

		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			adj.add(new ArrayList<>());
		}
		System.out.println(adj.size());
		addEdge(adj, 0, 1);
		addEdge(adj, 2, 1);
		addEdge(adj, 2, 4);
		addEdge(adj, 3, 1);
		addEdge(adj, 4, 1);
		addEdge(adj, 4, 0);
		printGraph(adj);
		BFS(5, adj);

	}

	static void addEdge(ArrayList<ArrayList<Integer>> adj, int source, int destination) {
		adj.get(source).add(destination);
		adj.get(destination).add(source);
	}

	static void printGraph(ArrayList<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			ArrayList<Integer> cur = adj.get(i);
			System.out.print(i + " -> ");
			for (int num : cur) {
				System.out.print(num + ",");
			}
			System.out.println();
		}
	}

	static void BFS(int v, ArrayList<ArrayList<Integer>> adj) {
		if (adj.size() == 0)
			return;
		boolean[] visited = new boolean[v];
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (visited[cur])
				continue;
			visited[cur] = true;
			System.out.print(cur + " ");
			ArrayList<Integer> curAdj = adj.get(cur);
			for (int num : curAdj) {
				if (!visited[num])
					q.add(num);
			}
		}
	}

}
