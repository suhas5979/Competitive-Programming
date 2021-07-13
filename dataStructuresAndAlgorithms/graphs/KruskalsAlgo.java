package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class KruskalsAlgo {

	static class edge {
		int source, destination, weight;

		edge(int s, int d, int w) {
			this.source = s;
			this.destination = d;
			this.weight = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<edge> adj = new ArrayList<>(n);

		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			a--;
			b--;
			adj.add(new edge(a, b, w));
		}

		Collections.sort(adj, (o1, o2) -> {
			return o1.weight - o2.weight;
		});
		kruskalsMST(adj, n);
	}

	static void union(int[] parent, int[] rank, int u, int v) {
		u = findParent(parent, rank, u);
		v = findParent(parent, rank, v);
		if (rank[u] > rank[v]) {
			parent[v] = u;
		} else if (rank[u] < rank[v]) {
			parent[u] = v;
		} else {
			parent[v] = u;
			rank[u]++;
		}
	}

	static int findParent(int[] parent, int[] rank, int v) {
		if (v == parent[v])
			return v;
		return parent[v] = findParent(parent, rank, parent[v]);
	}

	private static void kruskalsMST(ArrayList<edge> adj, int n) {
		int parent[] = new int[n];
		int rank[] = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		int minMst = 0;
		for (int i = 0; i < adj.size(); i++) {
			edge cur = adj.get(i);
			if (findParent(parent, rank, cur.source) != findParent(parent, rank, cur.destination)) {
				minMst += cur.weight;
				union(parent, rank, cur.source, cur.destination);
			}
		}
		System.out.println("minimum spanning tree with weight=" + minMst);

	}

}

// Test case
//6 9
//1 4 1
//1 5 4
//1 2 2
//4 5 9
//4 3 5
//4 2 3
//2 3 3
//3 6 8
//2 6 7
