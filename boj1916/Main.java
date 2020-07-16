package boj1916;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;

	static int adj[][];
	static int dist[];

	static PriorityQueue<Integer> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());

		adj = new int[n + 1][n + 1];
		dist = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(adj[i], Integer.MAX_VALUE);
			adj[i][i] = 0;
		}
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int time = Integer.parseInt(st.nextToken());

			if (adj[start][end] > time)
				adj[start][end] = time;
		}

		pq = new PriorityQueue<>();

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		dijkstra(start);

		System.out.println(dist[end]);
	}

	static void dijkstra(int index) {
		pq.add(index);
		dist[index] = 0;

		while (!pq.isEmpty()) {
			int cur = pq.poll();

			for (int i = 1; i <= n; i++) {
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