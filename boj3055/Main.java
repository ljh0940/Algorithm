package boj3055;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

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

	static char map[][];
	static boolean checked[][];

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };
	static Queue<Pos> q = new LinkedList<Pos>();

	static Pos me = null;
	static Pos goal = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");

		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		map = new char[n][m];
		checked = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = string.charAt(j);

				if (map[i][j] == 'S') {
					me = new Pos(i, j);
					checked[i][j] = true;
				}

				if (map[i][j] == '*') {
					q.add(new Pos(i, j));
					checked[i][j] = true;
				}

				if (map[i][j] == 'D')
					goal = new Pos(i, j);
			}
		}

		q.add(me);

		if (bfs() == false) {
			System.out.println("KAKTUS");
		}
	}

	static boolean bfs() {
		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			count++;

			for (int k = 0; k < size; k++) {
				Pos p = q.poll();
				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if (checked[nx][ny] == true)
						continue;

					if (map[p.x][p.y] == '*') {
						if (map[nx][ny] == '.') {
							map[nx][ny] = '*';
							checked[nx][ny] = true;
							q.add(new Pos(nx, ny));
						}
					} else {
						if (map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							checked[nx][ny] = true;
							q.add(new Pos(nx, ny));
						}
						if (map[nx][ny] == 'D') {
							System.out.println(count);
							return true;
						}
					}

				}
			}
		}

		return false;
	}
}