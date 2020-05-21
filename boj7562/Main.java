package boj7562;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main {
	static int n;

	static int dx[] = { -1, -2, 1, 2, -2, -1, 2, 1 };
	static int dy[] = { -2, -1, -2, -1, 1, 2, 1, 2 };
	static boolean checked[][];

	static Pos goal = null;
	static Pos knight = null;

	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		sb = new StringBuilder();

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			checked = new boolean[n][n];

			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			knight = new Pos(x, y);

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			goal = new Pos(x, y);

			if (knight.x == goal.x && knight.y == goal.y) {
				sb.append(0).append("\n");
				continue;
			}

			bfs();
		}

		System.out.print(sb.toString());
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(knight);
		checked[knight.x][knight.y] = true;

		int cnt = 0;

		while (!q.isEmpty()) {
			int size = q.size();

			cnt++;
			for (int k = 0; k < size; k++) {
				Pos p = q.poll();

				for (int i = 0; i < 8; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;

					if (checked[nx][ny] == true)
						continue;

					if (nx == goal.x && ny == goal.y) {
						sb.append(cnt).append("\n");
						return;
					}

					checked[nx][ny] = true;
					q.add(new Pos(nx, ny));
				}
			}

		}
	}
}