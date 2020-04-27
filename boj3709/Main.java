package boj3709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
	static int map[][];
	static int dx[] = { 1, 0, -1, 0 }; // ³²µ¿ºÏ¼­
	static int dy[] = { 0, 1, 0, -1 };

	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			int x = 0;
			int y = 0;
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			map = new int[n + 2][n + 2];

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				y = Integer.parseInt(st.nextToken());
				x = Integer.parseInt(st.nextToken());

				map[x][y] = 1;
			}

			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			solve(x, y);

		}
	}

	static void solve(int x, int y) {
		int order = 0; // 0:³² 1:µ¿ 2:ºÏ 3:¼­
		if (x == 0) {
			order = 0;
		} else if (y == n + 1) {
			order = 3;
		} else if (x == n + 1) {
			order = 2;
		} else if (y == 0) {
			order = 1;
		}

		int nx = x;
		int ny = y;

		while (true) {
			nx = nx + dx[order];
			ny = ny + dy[order];

			if (nx == 0 || nx == n + 1 || ny == 0 || ny == n + 1) {
				System.out.println(ny + " " + nx);
				return;
			}

			if (map[nx][ny] == 1) {
				order = setOrder(order);
			}
		}

	}

	static int setOrder(int n) {
		return (n + 1) % 4;
	}
}