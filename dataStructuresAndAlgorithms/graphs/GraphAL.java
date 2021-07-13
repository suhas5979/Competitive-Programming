package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GraphAL {
	private ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

	GraphAL(int v) {
		for (int i = 0; i <= v; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	void addEdge(int source, int destination) {
		adj.get(source).add(destination);
		adj.get(destination).add(source);
	}

	void addEdgeDirected(int source, int destination) {
		adj.get(source).add(destination);
	}

	ArrayList<ArrayList<Integer>> getGraph() {
		return adj;
	}

	void bfs() {
		int size = adj.size();
		boolean[] visited = new boolean[size];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				Queue<Integer> q = new LinkedList<>();
				visited[i] = true;
				q.add(i);
				while (!q.isEmpty()) {
					int cur = q.poll();
					System.out.print(cur + " ");
					for (int v : adj.get(cur)) {
						if (!visited[v]) {
							q.add(v);
							visited[v] = true;
						}

					}
				}
			}
		}
	}

	void dfs() {
		int size = adj.size();
		boolean[] visited = new boolean[size];
		for (int i = 0; i < adj.size(); i++) {
			if (!visited[i]) {
				dfs(visited, i);
			}
		}
	}

	void dfs(boolean[] visited, int cur) {
		if (!visited[cur]) {
			visited[cur] = true;
			System.out.print(cur + " ");
			for (int v : adj.get(cur)) {
				if (!visited[v]) {
					dfs(visited, v);
				}
			}
		}
	}

	public static void main(String[] args) {
//		GraphAL graph = new GraphAL(7);
//		graph.addEdge(0, 1);
//		graph.addEdge(0, 4);
//		graph.addEdge(1, 2);
//		graph.addEdge(4, 3);
//		graph.addEdge(1, 4);
//		graph.addEdge(3, 5);
//		graph.addEdge(6, 7);
//		System.out.println(detectCycleDFS(graph.getGraph()));
//		System.out.println(isBipartitle(buildBipartiteGraph()));
//		System.out.println(topoSort(buildDirectedAcyclicGraph()));
		solve();
	}

	static boolean isBipartitle(ArrayList<ArrayList<Integer>> adj) {
		int size = adj.size();
		int[] visited = new int[size];
		Arrays.fill(visited, -1);
		Queue<Integer> q = new LinkedList<>();
		q.add(0);
		visited[0] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			int curColor = visited[cur] == 0 ? 1 : 0;
			for (int num : adj.get(cur)) {
				if (visited[num] == -1) {
					visited[num] = curColor;
					q.add(num);
				}
				if (visited[num] != curColor) {
					return false;
				}
			}
		}
		return true;
	}

	static void shortestPathTest() {
		GraphAL graph = new GraphAL(8);
		graph.addEdge(0, 1);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 4);
		graph.addEdge(2, 6);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		graph.addEdge(6, 7);
		graph.addEdge(6, 8);
		graph.addEdge(7, 8);
		graph.addEdge(0, 5);
		int[] res = shortestDistance(graph.getGraph(), 0);
		for (int i = 0; i < res.length; i++) {
			System.out.println(i + "=>" + res[i]);
		}
	}

	static void solve() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int c = sc.nextInt();
		GraphAL g = new GraphAL(n);
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a--;
			b--;
			g.addEdge(b, a);
		}
		int res[] = shortestPath(g.getGraph(), 0, t, c);
		for (int i = 0; i < n; i++) {
			System.out.print(res[i] + " ");
		}
	}

	static int[] shortestPath(ArrayList<ArrayList<Integer>> adj, int source, int t, int c) {
		int size = adj.size();
		int[] dist = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while (!q.isEmpty()) {
			int cur = q.poll();
			int d = dist[cur];
			for (int v : adj.get(cur)) {
				int time = 0;
				if (d != 0)
					time = d % t == 0 ? d + t : d + (t - (d % t));
				if (dist[v] == Integer.MAX_VALUE) {
					q.add(v);

					dist[v] = c + time;
				} else {
					dist[v] = Math.min(dist[v], c + time);
				}
			}
		}
		return dist;
	}

	static int[] shortestDistance(ArrayList<ArrayList<Integer>> adj, int source) {
		int size = adj.size();
		int[] dist = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while (!q.isEmpty()) {
			int cur = q.poll();
			int d = dist[cur];
			for (int v : adj.get(cur)) {
				if (dist[v] == Integer.MAX_VALUE) {
					q.add(v);
					dist[v] = 1 + d;
				} else {
					dist[v] = Math.min(dist[v], 1 + d);
				}
			}
		}
		return dist;
	}

	static ArrayList<ArrayList<Integer>> buildUnBipartiteGraph() {
		GraphAL graph = new GraphAL(8);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 7);
		graph.addEdge(2, 3);
		graph.addEdge(7, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		return graph.getGraph();
	}

	static ArrayList<ArrayList<Integer>> buildBipartiteGraph() {
		GraphAL graph = new GraphAL(9);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(1, 7);
		graph.addEdge(2, 3);
		graph.addEdge(7, 8);
		graph.addEdge(8, 4);
		graph.addEdge(3, 4);
		graph.addEdge(4, 5);
		graph.addEdge(5, 6);
		return graph.getGraph();
	}

	static ArrayList<ArrayList<Integer>> buildDirectedAcyclicGraph() {
		GraphAL graph = new GraphAL(6);
		graph.addEdgeDirected(5, 0);
		graph.addEdgeDirected(4, 0);
		graph.addEdgeDirected(5, 2);
		graph.addEdgeDirected(4, 1);
		graph.addEdgeDirected(2, 3);
		graph.addEdgeDirected(3, 1);
		return graph.getGraph();
	}

	static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
		int size = adj.size();
		int[] inDegree = new int[size];
		for (int i = 0; i < size; i++) {
			for (int v : adj.get(i)) {
				inDegree[v]++;
			}
		}
		ArrayList<Integer> res = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 0; i < size; i++) {
			if (inDegree[i] == 0)
				q.add(i);
		}
		while (!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);
			for (int v : adj.get(cur)) {
				inDegree[v]--;
				if (inDegree[v] == 0)
					q.add(v);
			}
		}
		return res;
	}

	static boolean detectCycleDFS(ArrayList<ArrayList<Integer>> adj) {
		int size = adj.size();
		boolean[] visited = new boolean[size];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				if (isCyclicDFS(adj, visited, new pair(i, -1)))
					return true;

			}
		}
		return false;
	}

	private static boolean isCyclicDFS(ArrayList<ArrayList<Integer>> adj2, boolean[] visited, pair cur) {
		visited[cur.node] = true;
		for (int num : adj2.get(cur.node)) {
			if (!visited[num]) {
				isCyclicDFS(adj2, visited, new pair(num, cur.node));
			} else if (num != cur.parent)
				return true;
		}
		return false;
	}

	static boolean isCyclic(ArrayList<ArrayList<Integer>> adj) {
		int size = adj.size();
		boolean[] visited = new boolean[size];
		for (int i = 0; i < size; i++) {
			if (!visited[i]) {
				if (isCyclic(adj, visited, i))
					return true;

			}
		}
		return false;
	}

	private static boolean isCyclic(ArrayList<ArrayList<Integer>> adj2, boolean[] visited, int root) {
		Queue<pair> q = new LinkedList<>();
		q.add(new pair(root, root));
		visited[root] = true;
		while (!q.isEmpty()) {
			pair cur = q.poll();
			for (int num : adj2.get(cur.node)) {
				if (!visited[num]) {
					q.add(new pair(num, cur.node));
					visited[num] = true;
				} else if (num != cur.parent)
					return true;
			}
		}
		return false;
	}

	static class pair {
		int node, parent;

		pair(int n, int p) {
			this.node = n;
			this.parent = p;
		}
	}

}
