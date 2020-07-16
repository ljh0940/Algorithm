package boj1753;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int index;
	int weight;

	Node(int index, int weight) {
		this.index = index;
		this.weight = weight;
	}
}

class Main {
	static int v;
	static int e;

	static ArrayList<Node> arr[];
	static int dist[];

	static PriorityQueue<Node> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		arr = new ArrayList[v + 1];
		dist = new int[v + 1];
		pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.weight > o2.weight)
					return 1;
				else
					return -1;
			}
		});

		for (int i = 1; i <= v; i++)
			arr[i] = new ArrayList<>();

		Arrays.fill(dist, Integer.MAX_VALUE);

		int first = Integer.parseInt(br.readLine());

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			arr[start].add(new Node(end, weight));
		}

		dijkstra(first);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			sb.append((dist[i] == Integer.MAX_VALUE) ? "INF" : dist[i]).append("\n");
		}

		System.out.print(sb.toString());

	}

	static void dijkstra(int index) {
		pq.offer(new Node(index, 0));
		dist[index] = 0;
		boolean checked[] = new boolean[v + 1];

		while (!pq.isEmpty()) {
			int cur = pq.poll().index;

			if (checked[cur] == true)
				continue;
			checked[cur] = true;

			for (Node node : arr[cur]) {
				if (dist[node.index] > dist[cur] + node.weight) {
					dist[node.index] = dist[cur] + node.weight;
					pq.offer(new Node(node.index, dist[node.index]));
				}
			}
		}
	}
}