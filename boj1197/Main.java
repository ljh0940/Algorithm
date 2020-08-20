package boj1197;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
	int goal;
	int cost;

	Node(int goal, int cost) {
		this.goal = goal;
		this.cost = cost;
	}
}

class Main {
	static int n;
	static int m;
	static long minCost;

	static ArrayList<Node> arr[];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		checked = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			arr[start].add(new Node(end, cost));
			arr[end].add(new Node(start, cost));
		}

		mst();

		System.out.println(minCost);
	}

	static void mst() {
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if (o1.cost > o2.cost)
					return 1;
				else
					return -1;
			}
		});

		int count = 0;

		checked[1] = true;
		for (int i = 0; i < arr[1].size(); i++) {
			pq.add(arr[1].get(i));
		}

		while (!pq.isEmpty()) {
			Node currentNode = pq.poll();

			if (checked[currentNode.goal])
				continue;

			checked[currentNode.goal] = true;
			minCost += currentNode.cost;
			count++;

			if (count == n - 1)
				return;

			for (int i = 0; i < arr[currentNode.goal].size(); i++) {
				Node nextNode = arr[currentNode.goal].get(i);

				if (checked[nextNode.goal])
					continue;

				pq.offer(nextNode);
			}

		}
	}
}