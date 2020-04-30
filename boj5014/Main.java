package boj5014;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int f;
	static int s;
	static int g;
	static int u;
	static int d;

	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		f = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		u = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		checked = new boolean[f + 1];

		if (s == g) {
			System.out.println(0);
			return;
		}

		int result = bfs();

		System.out.println(result == Integer.MAX_VALUE ? "use the stairs" : result);
	}

	static int bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(s);
		checked[s] = true;

		int count = 0;

		while (!q.isEmpty()) {
			count++;
			int size = q.size();
			for (int k = 0; k < size; k++) {

				int now = q.poll();
				int next = now;

				for (int i = 0; i < 2; i++) { // 0:u 1:d
					if (i == 0) {
						next = now + u;
						if (next > f)
							continue;

					} else {
						next = now - d;
						if (next <= 0)
							continue;
					}

					if (checked[next] == true)
						continue;

					if (next == g)
						return count;

					checked[next] = true;
					q.add(next);
				}
			}
		}

		return Integer.MAX_VALUE;
	}
}