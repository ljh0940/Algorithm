package boj2589;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x, y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {
	static char map[][];
	static int min = 0;

	static int n;
	static int m;

	static int dx[] = { 0, -1, 0, 1 }; // ¼­ºÏµ¿³²
	static int dy[] = { -1, 0, 1, 0 };

	static boolean checked[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 'L') {
					checked = new boolean[n][m];
					bfs(i, j);
				}
			}
		}

		System.out.println(min);

	}

	static void bfs(int xx, int yy) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(xx, yy));
		checked[xx][yy] = true;

		int count = -1;

		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			for (int k = 0; k < size; k++) {
				Pos p = q.remove();
				int x = p.x;
				int y = p.y;

				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;
					if (checked[nx][ny] == true)
						continue;

					if (map[nx][ny] == 'L') {
						q.add(new Pos(nx, ny));
						checked[nx][ny] = true;
					}

				}
			}
		}

		min = Math.max(min, count);
	}

}