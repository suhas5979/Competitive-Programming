package dataStructuresAndAlgorithms.dynamicProgramming;

public class TravelingSalesmanProblem {

	public static void main(String[] args) {
		int graph[][] = {{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};
		System.out.println(tsp(graph));
		System.out.println(calls);
	}

	static int tsp(int[][] graph) {
		boolean[] visited = new boolean[graph.length];
		visited[0] = true;
		return tsp(graph, visited, 0, 1);
	}
	static int calls=0;
	static int tsp(int[][] graph, boolean[] visited, int cur, int count) {
		calls++;
		if (count == graph.length) {
			return graph[cur][0];
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < graph.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				int newAns = graph[cur][i] + tsp(graph, visited, i, count + 1);
				visited[i] = false;
				ans = Math.min(newAns, ans);
			}
		}
		return ans;
	}

}
