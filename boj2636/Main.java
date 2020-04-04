package boj2636;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n, m;
	static int map[][];

	static int count = 0;
	static int time = 0;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static boolean checked[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (isEnd() == true) {
			System.out.println(0);
			System.out.println(0);
			return;
		}

		while (true) {
			time++;
			checked = new boolean[n][m];
			dfs(0, 0);

			meltCheeze();

			if (isEnd() == true) {
				System.out.println(time);
				System.out.println(count);
				return;
			}
			count = 0;
		}

	}

	static void meltCheeze() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
	}

	static boolean isEnd() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != 0)
					return false;
			}
		}

		return true;
	}

	static void dfs(int xx, int yy) {
		checked[xx][yy] = true;

		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (checked[nx][ny] == true)
				continue;

			if (map[nx][ny] == 1) {
				map[nx][ny]++;
				count++;
			}

			if (map[nx][ny] == 0)
				dfs(nx, ny);
		}
	}

}