package boj1707;

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

	static ArrayList<Integer> arr[];
	static int checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			checked = new int[n + 1];
			arr = new ArrayList[n + 1];

			for (int i = 1; i <= n; i++) {
				arr[i] = new ArrayList<>();
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());

				arr[start].add(end);
				arr[end].add(start);
			}

			sb.append(bfs() ? "YES" : "NO").append("\n");
		}

		System.out.println(sb.toString());

	}

	static boolean bfs() {
		Queue<Integer> q = new LinkedList<>();
		for (int k = 1; k <= n; k++) {
			if (checked[k] != 0)
				continue;

			q.add(k);
			int flag = -1;
			checked[k] = 1;

			while (!q.isEmpty()) {
				int index = q.poll();

				for (int i = 0; i < arr[index].size(); i++) {
					int next = arr[index].get(i);

					if (checked[next] == checked[index])
						return false;

					if (checked[next] != 0)
						continue;

					checked[next] = checked[index] * flag;
					q.add(next);
				}
			}
		}

		return true;
	}
}