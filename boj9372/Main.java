package boj9372;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int min;

	static ArrayList<Integer> arr[];

	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			min = Integer.MAX_VALUE;

			checked = new boolean[n + 1];

			arr = new ArrayList[n + 1];
			for (int i = 1; i <= n; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int arrival = Integer.parseInt(st.nextToken());

				arr[start].add(arrival);
				arr[arrival].add(start);
			}

			bfs(1);

			sb.append(min).append("\n");

		}

		System.out.println(sb.toString());
	}

	static void bfs(int index) {
		int count = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(index);
		checked[index] = true;

		while (!q.isEmpty()) {
			int start = q.poll();

			for (int i = 0; i < arr[start].size(); i++) {
				int next = arr[start].get(i);

				if (checked[next] == true)
					continue;

				checked[next] = true;
				count++;

				q.add(next);
			}
		}

		if (count < min)
			min = count;

		return;
	}
}