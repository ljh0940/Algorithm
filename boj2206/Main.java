package boj2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
	int x;
	int y;

	boolean crush;

	Pos(int x, int y, boolean crush) {
		this.x = x;
		this.y = y;
		this.crush = crush;
	}
}

class Main {
	static int n;
	static int m;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int map[][];
	static boolean checked[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputs[] = br.readLine().split(" ");
		n = Integer.parseInt(inputs[0]);
		m = Integer.parseInt(inputs[1]);

		if (n == 1 && m == 1) {
			System.out.println(1);
			return;
		}

		map = new int[n][m];
		checked = new boolean[2][n][m];

		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}

		System.out.println(bfs());

	}

	static int bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(new Pos(0, 0, false));
		checked[0][0][0] = true;

		int count = 1;

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

					if (p.crush) {
						if (checked[1][nx][ny] == true)
							continue;

						if (map[nx][ny] == 1)
							continue;

						checked[1][nx][ny] = true;
						q.offer(new Pos(nx, ny, true));
					} else {
						if (checked[0][nx][ny] == true)
							continue;

						if (map[nx][ny] == 1) {
							q.offer(new Pos(nx, ny, true));
							checked[1][nx][ny] = true;
						} else {
							q.offer(new Pos(nx, ny, false));
							checked[0][nx][ny] = true;
						}
					}

					if (n - 1 == nx && m - 1 == ny)
						return count;
				}
			}
		}

		return -1;
	}
}