package dataStructuresAndAlgorithms.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Integer>[] adj = new ArrayList[n];
		for(int i=0;i<n;i++)
			adj[i] = new ArrayList();
		for(int i=0;i<m;i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			a--;b--;
			adj[a].add(b);
			adj[b].add(a);
		}
		bfs(adj,5,6);
	}
	static void bfs(ArrayList<Integer>[] adj) {
		boolean visited[] = new boolean[adj.length];
		int parent[] = new int[adj.length];
		int source = 0;
		visited[source] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while(!q.isEmpty()) {
			int cur = q.poll();
			System.out.print(cur+1 +" ");
			for(int v :adj[cur]) {
				if(!visited[v]) {
					visited[v] = true;
					q.add(v);
					parent[v] = cur+1;
				}
			}
		}
		System.out.println();
		for(int p :parent)
			System.out.print(p+" ");
	}
	
	static void bfs(ArrayList<Integer>[] adj,int source,int destination) {
		source--;
		destination--;
		boolean visited[] = new boolean[adj.length];
		int parent[] = new int [adj.length];
		visited[source] = true;
		Queue<Integer> q = new LinkedList<>();
		q.add(source);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int v :adj[cur]) {
				if(!visited[v]) {
					visited [v] = true;
					q.add(v);
					parent[v] = cur+1;
				}
			}
		}
		ArrayList<Integer> path = new ArrayList<>();
		int i=destination;
		while(i != source) {
			path.add(i+1);
			i = parent[i] -1;
		}
		path.add(source+1);
		Collections.reverse(path);
		System.out.println(path);
	}
	

}
