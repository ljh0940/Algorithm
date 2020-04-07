package boj5427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int depth;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Pos(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}

class Main {

	static int n;
	static int m;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static char map[][];
	static boolean checked[][];

	static Queue<Pos> fire;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());

			map = new char[n][m];
			checked = new boolean[n][m];
			fire = new LinkedList<Pos>();

			Pos me = new Pos(0, 0);

			for (int i = 0; i < n; i++) {
				String str = br.readLine();
				for (int j = 0; j < m; j++) {
					map[i][j] = str.charAt(j);

					if (map[i][j] == '*')
						fire.add(new Pos(i, j));

					if (map[i][j] == '@') {
						me = new Pos(i, j);
					}
				}
			}
			bfs(me.x, me.y);

		}

	}

	static void bfs(int xx, int yy) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(xx, yy, 0));
		checked[xx][yy] = true;

		while (!q.isEmpty()) {
			burn();

			int size = q.size();
			for (int i = 0; i < size; i++) {
				Pos p = q.poll();

				for (int j = 0; j < 4; j++) {
					int nx = p.x + dx[j];
					int ny = p.y + dy[j];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
						System.out.println(p.depth + 1);
						return;
					}

					if (checked[nx][ny] == true)
						continue;

					if (map[nx][ny] == '.') {
						checked[nx][ny] = true;
						q.add(new Pos(nx, ny, p.depth + 1));
					}
				}
			}
		}
		System.out.println("IMPOSSIBLE");
	}

	static void burn() {

		int size = fire.size();

		for (int i = 0; i < size; i++) {
			Pos p = fire.poll();

			for (int j = 0; j < 4; j++) {
				int nx = p.x + dx[j];
				int ny = p.y + dy[j];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if (map[nx][ny] == '.') {
					map[nx][ny] = '*';
					fire.add(new Pos(nx, ny));
				}
			}

		}
	}
}