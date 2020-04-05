package boj14500;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int max;

	static int map[][];
	static boolean checked[][];

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		checked = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				dfs(i, j, 1, map[i][j]);
				exception(i, j);
			}
		}

		System.out.println(max);
	}

	static void exception(int x, int y) {
		int sum = map[x][y];
		int count = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
				count++;
				continue;
			}
			min = Math.min(min, map[nx][ny]);
			sum = sum + map[nx][ny];
		}

		if (count == 0) {
			sum = sum - min;
		}
		if (count == 2) {
			return;
		}
		max = Math.max(max, sum);
	}

	static void dfs(int xx, int yy, int depth, int sum) {
		checked[xx][yy] = true;

		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			int temp = sum;

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (checked[nx][ny] == true)
				continue;

			temp = temp + map[nx][ny];
			if (depth == 3) {
				max = Math.max(max, temp);
				continue;
			}
			dfs(nx, ny, depth + 1, temp);
			checked[nx][ny] = false;
		}

		checked[xx][yy] = false;
	}
}