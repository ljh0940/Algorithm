package programmers12978;

import java.util.Arrays;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int N = 6;
		int[][] road = { { 1, 2, 1 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 4, 3 }, { 3, 5, 2 }, { 3, 5, 3 }, { 5, 6, 1 } };
		int K = 4;
		sol.solution(N, road, K);
	}
}

class Solution {
	int adj[][];
	int dist[];
	PriorityQueue<Integer> pq;

	public int solution(int N, int[][] road, int K) {
		int answer = 0;

		adj = new int[N + 1][N + 1];
		dist = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
			adj[i][i] = 0;
			dist[i] = Integer.MAX_VALUE;
		}

		for (int i = 0; i < road.length; i++) {
			int start = road[i][0];
			int end = road[i][1];
			int time = road[i][2];

			adj[start][end] = Math.min(adj[start][end], time);
			adj[end][start] = adj[start][end];
		}

		pq = new PriorityQueue<>();

		pq.add(1);
		dist[1] = 0;
		dijkstra(N);

		for (int i = 1; i <= N; i++) {
			if (dist[i] <= K)
				answer++;
		}

		return answer;
	}

	void dijkstra(int N) {
		while (!pq.isEmpty()) {
			int cur = pq.poll();

			for (int i = 1; i <= N; i++) {
				if (adj[cur][i] == Integer.MAX_VALUE)
					continue;

				if (dist[i] > dist[cur] + adj[cur][i]) {
					dist[i] = dist[cur] + adj[cur][i];
					pq.offer(i);
				}
			}
		}
	}

}