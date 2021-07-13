package dataStructuresAndAlgorithms.graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GridPractice {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		sc.close();
		bfs(arr, n, m);

	}

	static void bfs(int[][] grid, int n, int m) {
		boolean visited[][] = new boolean[n][m];
		visited[0][0] = true;
		Queue<pair> q = new LinkedList<>();
		int[] dr = { 1, 0, -1, 0 };
		int[] dc = { 0, 1, 0, -1 };
		q.add(new pair(0,0,0));
		int min = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			pair cur = q.poll();
			for(int i=0;i<4;i++) {
				int dx = cur.x +dr[i];
				int dy = cur.y + dc[i];
				if(isSafe(grid,visited,dx,dy)) {
					if(dx== grid.length-1 && dy== grid[0].length-1) {
						min = Math.min(min, 1 + cur.cost);
						System.out.println(min);
					}
					visited[dx][dy] = true;
					q.add(new pair(dx,dy,cur.cost +1));
				}
			}
		}
	}
	static boolean isSafe(int[][] grid ,boolean visited[][],int x,int y) {
		if(x<0 || y <0 || x>=grid.length || y >= grid[0].length)
			return false;
		if(visited[x][y] || grid[x][y] == 0)
			return false;
		return true;
	}

	static class pair {
		int x, y,cost;

		pair(int x, int y,int c) {
			this.x = x;
			this.y = y;
			this.cost = c;
		}
	}

}

// Sample Test Case

//10 10
//1 1 1 0 0 1 1 1 0 0
//1 0 1 1 1 1 1 1 0 0
//1 0 0 1 1 1 1 1 0 0
//1 1 0 1 0 1 1 1 0 0
//0 1 1 1 1 1 0 1 0 0
//1 1 1 0 0 1 1 1 0 0
//1 0 1 1 1 1 0 1 1 1
//1 0 0 1 0 1 1 1 0 1
//1 1 0 1 0 1 0 1 0 1
//0 1 1 1 1 1 1 1 1 1 

// Test Case 2

//5 5
//1 1 1 0 0
//1 0 0 1 1
//1 0 0 1 1 
//1 1 0 1 0
//0 1 0 1 1
