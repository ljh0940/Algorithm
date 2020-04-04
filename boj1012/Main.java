package boj1012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int map[][];
	static int count = 0;

	static int n;
	static int m;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static boolean checked[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());

			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());

			int baechu = Integer.parseInt(st.nextToken());
			map = new int[n][m];
			checked = new boolean[n][m];

			for (int i = 0; i < baechu; i++) {
				st = new StringTokenizer(br.readLine());
				int temp1 = Integer.parseInt(st.nextToken());
				int temp2 = Integer.parseInt(st.nextToken());
				map[temp1][temp2] = 1;
			}

			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (checked[i][j] == false && map[i][j] == 1) {
						dfs(i, j);
						count++;
					}
				}
			}

			System.out.println(count);
			count = 0;
		}

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
				dfs(nx, ny);
			}
		}
	}
}
