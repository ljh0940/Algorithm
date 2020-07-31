package boj1766;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int inDegree[] = new int[n + 1];

		ArrayList<Integer> arr[] = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start].add(end);
			inDegree[end]++;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0)
				pq.offer(i);
		}

		while (!pq.isEmpty()) {
			int index = pq.poll();
			inDegree[index]++;
			sb.append(index).append(" ");

			for (int i = 0; i < arr[index].size(); i++) {
				int next = arr[index].get(i);

				inDegree[next]--;

				if (inDegree[next] == 0)
					pq.offer(next);
			}
		}

		System.out.println(sb.toString());
	}
}