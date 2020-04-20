package boj16234;

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
	static int l;
	static int r;
	static int nation;
	static int sum;
	static int count = 0;
	static int visitCount = 1;

	static boolean flag = false;

	static int map[][];
	static int checked[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static Queue<Pos> q = new LinkedList<Pos>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		checked = new int[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			flag = false;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (checked[i][j] != 0)
						continue;
					sum = map[i][j];
					nation = 1;
					solve(i, j);
					while (!q.isEmpty()) {
						Pos p = q.poll();
						map[p.x][p.y] = sum / nation;
					}
				}
			}
			if (flag == false)
				break;
			count++;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					checked[i][j] = 0;
				}
			}
		}

		System.out.println(count);

	}

	static boolean solve(int x, int y) {
		if (checked[x][y] != 0)
			return false;

		checked[x][y] = 1;
		q.add(new Pos(x, y));

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (Math.abs(map[nx][ny] - map[x][y]) < l || Math.abs(map[nx][ny] - map[x][y]) > r)
				continue;

			if (checked[nx][ny] == 1)
				continue;

			flag = true;
			nation++;
			sum = sum + map[nx][ny];
			solve(nx, ny);
		}

		return true;
	}

}