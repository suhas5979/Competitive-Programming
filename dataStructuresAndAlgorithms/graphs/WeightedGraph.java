package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class WeightedGraph {
	static class edge {
		int weight, dest;

		edge(int d, int w) {
			this.weight = w;
			this.dest = d;
		}

		@Override
		public String toString() {
			return "edge [" + dest + ", " + weight + "]";
		}
	}

	public WeightedGraph(int v) {
		for (int i = 0; i < v; i++) {
			adj.add(new ArrayList<edge>());
		}
	}

	private ArrayList<ArrayList<edge>> adj = new ArrayList<>();

	void addEdge(int source, int destination, int weight) {
		adj.get(source).add(new edge(destination, weight));
		adj.get(destination).add(new edge(source, weight));
	}

	ArrayList<ArrayList<edge>> getGraph() {
		return adj;
	}

	public static void main(String[] args) {

		primsTest();
	}

	static void dijekstraTest() {
		WeightedGraph g = new WeightedGraph(5);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 1);
		g.addEdge(1, 2, 4);
		g.addEdge(1, 4, 5);
		g.addEdge(3, 2, 3);
		g.addEdge(2, 4, 1);
		dijekstra(g.getGraph(), 3);
	}

	static void primsTest() {
		WeightedGraph g = new WeightedGraph(6);
		g.addEdge(0, 1, 2);
		g.addEdge(0, 3, 1);
		g.addEdge(1, 3, 3);
		g.addEdge(1, 2, 3);
		g.addEdge(3, 2, 5);
		g.addEdge(2, 5, 8);
		g.addEdge(1, 5, 7);
		g.addEdge(0, 4, 4);
		g.addEdge(3, 4, 9);
		primsMst(g.getGraph());
	}

	static void primsMst(ArrayList<ArrayList<edge>> adj) {
		int size = adj.size();
		boolean[] visited = new boolean[size];
		visited[0] = true;
		Queue<pair> q = new PriorityQueue<>((o1, o2) -> {
			return o1.weight - o2.weight;
		});
		for (edge e : adj.get(0)) {

			q.add(new pair(0, e.dest, e.weight));
		}
		ArrayList<pair> res = new ArrayList<>();
		while (!q.isEmpty() && res.size() != size) {
			pair cur = q.poll();
			if (visited[cur.source] && visited[cur.destination])
				continue;
			res.add(cur);
			visited[cur.destination] = true;
			for (edge e : adj.get(cur.destination))
				q.add(new pair(cur.destination, e.dest, e.weight));
		}
		System.out.println(res);
	}

	static class pair {
		int source, destination, weight;

		pair(int s, int d, int w) {
			this.source = s;
			this.destination = d;
			this.weight = w;
		}

		@Override
		public String toString() {
			return "[" + source + ", " + destination + ", =>" + weight + "]";
		}
	}

	static void dijekstra(ArrayList<ArrayList<edge>> adj, int source) {
		int size = adj.size();
		int[] dist = new int[size];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[source] = 0;
		Queue<edge> q = new PriorityQueue<>((o1, o2) -> {
			return o1.weight - o2.weight;
		});
		q.add(new edge(source, 0));
		while (!q.isEmpty()) {
			edge cur = q.poll();
			for (edge e : adj.get(cur.dest)) {
				if (dist[e.dest] == Integer.MAX_VALUE) {
					dist[e.dest] = cur.weight + e.weight;
					q.add(new edge(e.dest, dist[e.dest]));
				} else {
					dist[e.dest] = Math.min(dist[e.dest], cur.weight + e.weight);
				}
			}
		}
		for (int i = 0; i < size; i++) {
			System.out.println(source + "to" + i + " =>" + dist[i]);
		}
	}

}
