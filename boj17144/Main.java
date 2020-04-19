package boj17144;

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
	static int m;

	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };

	static int map[][][];

	static Pos machine = null;
	static Queue<Pos> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m][2];

		int t = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j][0] = Integer.parseInt(st.nextToken());

				if (map[i][j][0] == -1) {
					machine = new Pos(i, j);
				}
			}
		}

		for (int i = 0; i < t; i++) {
			init();
			solve();
			sum();
			move();
		}

		int sum = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j][0] != -1) {
					sum = sum + map[i][j][0];
				}
			}
		}

		System.out.println(sum);

	}

	static void init() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j][0] >= 5)
					q.add(new Pos(i, j));
			}
		}
	}

	static void sum() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				map[i][j][0] = map[i][j][0] + map[i][j][1];
				map[i][j][1] = 0;
			}
		}
	}

	static void solve() {
		while (!q.isEmpty()) {
			Pos p = q.poll();

			int count = 0;
			int temp = map[p.x][p.y][0] / 5;

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					continue;

				if ((nx == machine.x && ny == 0) || (nx == machine.x - 1 && ny == 0))
					continue;

				count++;
				map[nx][ny][1] += temp;
			}

			map[p.x][p.y][0] = map[p.x][p.y][0] - count * temp;
		}
	}

	static void move() {
		int order = 1;
		int temp1 = 0;
		for (int i = machine.x - 1;; i = i - order) {

			if (order == -1) {
				if (i == machine.x - 2)
					break;
				else {
					int temp2 = temp1;
					temp1 = map[i + 1][0][0];
					map[i + 1][0][0] = temp2;
				}

			} else if (order == 1) {
				if (i == 0) {
					int temp2 = temp1;
					temp1 = map[i][m - 1][0];
					map[i][m - 1][0] = temp2;

					for (int j = m - 2; j >= 0; j--) {
						temp2 = temp1;
						temp1 = map[i][j][0];
						map[i][j][0] = temp2;
					}
					temp2 = temp1;
					temp1 = map[i + 1][0][0];
					map[i + 1][0][0] = temp2;
					order = -1;
				} else if (i == machine.x - 1) {
					for (int j = m - 2; j > 0; j--) {
						int temp2 = map[i][j][0];
						map[i][j][0] = map[i][j + 1][0];
						map[i][j + 1][0] = temp2;
					}
					temp1 = map[i][1][0];
					map[i][1][0] = 0;
				} else {
					int temp2 = temp1;
					temp1 = map[i][m - 1][0];
					map[i][m - 1][0] = temp2;
				}
			}
		}

		order = -1;
		temp1 = 0;

		for (int i = machine.x;; i = i - order) {

			if (order == 1) {
				if (i == machine.x + 1)
					break;
				else {
					int temp2 = temp1;
					temp1 = map[i - 1][0][0];
					map[i - 1][0][0] = temp2;
				}

			} else if (order == -1) {
				if (i == n - 1) {
					int temp2 = temp1;
					temp1 = map[i][m - 1][0];
					map[i][m - 1][0] = temp2;

					for (int j = m - 2; j >= 0; j--) {
						temp2 = temp1;
						temp1 = map[i][j][0];
						map[i][j][0] = temp2;
					}
					temp2 = temp1;
					temp1 = map[i - 1][0][0];
					map[i - 1][0][0] = temp2;
					order = 1;
				} else if (i == machine.x) {
					for (int j = m - 2; j > 0; j--) {
						int temp2 = map[i][j][0];
						map[i][j][0] = map[i][j + 1][0];
						map[i][j + 1][0] = temp2;
					}
					temp1 = map[i][1][0];
					map[i][1][0] = 0;
				} else {
					int temp2 = temp1;
					temp1 = map[i][m - 1][0];
					map[i][m - 1][0] = temp2;
				}
			}
		}
	}

}