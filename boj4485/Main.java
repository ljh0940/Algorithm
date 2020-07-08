package boj4485;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int value;

	Pos(int x, int y, int value) {
		this.x = x;
		this.y = y;
		this.value = value;
	}
}

class Main {
	static int n;

	static int map[][];
	static int dijkstra[][];

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, -1, 0, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		StringBuilder sb = new StringBuilder();
		int count = 1;

		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}

			map = new int[n][n];
			dijkstra = new int[n][n];

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dijkstra[i][j] = Integer.MAX_VALUE;
				}
			}

			dijkstra[0][0] = map[0][0];
			solve();

			sb.append("Problem ").append(count).append(": ").append(dijkstra[n - 1][n - 1]).append("\n");
			count++;
		}

		System.out.print(sb.toString());
	}

	static void solve() {
		PriorityQueue<Pos> pq = new PriorityQueue<>(new Comparator<Pos>() {

			@Override
			public int compare(Pos o1, Pos o2) {
				if (o1.value > o2.value)
					return 1;
				return -1;
			}
		});

		pq.add(new Pos(0, 0, map[0][0]));

		while (!pq.isEmpty()) {
			Pos p = pq.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				int newValue = dijkstra[p.x][p.y] + map[nx][ny];

				if (dijkstra[nx][ny] <= newValue)
					continue;

				dijkstra[nx][ny] = newValue;
				pq.add(new Pos(nx, ny, newValue));
			}
		}
	}
}