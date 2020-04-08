package boj7569;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int z;

	Pos(int z, int x, int y) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
}

public class Main {
	static int n;
	static int m;
	static int h;

	static int max = 0;

	static int dx[] = { 1, -1, 0, 0, 0, 0 };
	static int dy[] = { 0, 0, 1, -1, 0, 0 };
	static int dz[] = { 0, 0, 0, 0, 1, -1 };

	static int map[][][];
	static boolean checked[][][];
	static Queue<Pos> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());

		map = new int[h][n][m];
		checked = new boolean[h][n][m];
		q = new LinkedList<Pos>();

		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < m; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());

					if (map[k][i][j] == 1) {
						checked[k][i][j] = true;
						q.add(new Pos(k, i, j));
					}
				}
			}
		}

		bfs();

		if (check() == true)
			System.out.println(max);
		else
			System.out.println(-1);
	}

	static boolean check() {
		for (int k = 0; k < h; k++) {
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (map[k][i][j] == 0)
						return false;
				}
			}
		}

		return true;
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Pos p = q.poll();

			for (int i = 0; i < 6; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int nz = p.z + dz[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m || nz < 0 || nz >= h)
					continue;

				if (checked[nz][nx][ny] == true)
					continue;

				if (map[nz][nx][ny] == 0) {
					checked[nz][nx][ny] = true;
					q.add(new Pos(nz, nx, ny));
					map[nz][nx][ny] = map[p.z][p.x][p.y] + 1;

					max = Math.max(max, map[p.z][p.x][p.y]);
				}
			}
		}
	}
}