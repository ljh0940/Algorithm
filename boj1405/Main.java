package boj1405;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int dx[] = { 0, 0, 1, -1 }; // µ¿¼­³²ºÏ
	static int dy[] = { 1, -1, 0, 0 };
	static double percents[] = new double[4];

	static int map[][] = new int[29][29];

	static double easy = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 4; i++) {
			percents[i] = Integer.parseInt(st.nextToken()) / (double) 100;
		}

		map[14][14] = 1;
		dfs(14, 14, n, 0, 1);

		System.out.println(1 - easy);

	}

	static void dfs(int xx, int yy, int depth, int count, double percent) {
		if (map[xx][yy] > 1) {
			easy = easy + percent;
			return;
		}

		if (depth == count)
			return;

		for (int i = 0; i < 4; i++) {
			if (percents[i] == 0)
				continue;

			int nx = xx + dx[i];
			int ny = yy + dy[i];

			map[nx][ny]++;
			dfs(nx, ny, depth, count + 1, percent * percents[i]);
			map[nx][ny]--;
		}

	}
}