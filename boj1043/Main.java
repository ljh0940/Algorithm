package boj1043;

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
	static boolean checked[];
	static int people[][];
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		people = new int[n + 1][n + 1];

		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		ArrayList<Integer> parties[] = new ArrayList[m];
		checked = new boolean[n + 1];

		for (int i = 0; i < k; i++) {
			int num = Integer.parseInt(st.nextToken());
			q.add(num);
			checked[num] = true;
		}

		for (int i = 0; i < m; i++) {
			parties[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			k = Integer.parseInt(st.nextToken());

			for (int j = 0; j < k; j++) {
				int num = Integer.parseInt(st.nextToken());
				parties[i].add(num);
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < parties[i].size() - 1; j++) {
				for (int l = j + 1; l < parties[i].size(); l++) {
					int first = parties[i].get(j);
					int second = parties[i].get(l);
					people[first][second] = -1;
					people[second][first] = -1;
				}
			}
		}

		bfs();

		int count = 0;
		for (int i = 0; i < m; i++) {
			boolean result = true;
			for (int j = 0; j < parties[i].size(); j++) {
				int num = parties[i].get(j);
				if (checked[num]) {
					result = false;
					break;
				}
			}

			if (result)
				count++;
		}

		System.out.println(count);

	}

	static void bfs() {
		while (!q.isEmpty()) {
			int next = q.poll();

			for (int i = 1; i <= n; i++) {
				if (people[next][i] == 0)
					continue;

				if (checked[i] == true)
					continue;

				checked[i] = true;
				q.add(i);
			}
		}
	}
}