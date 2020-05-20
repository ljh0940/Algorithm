package boj2210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

class Main {
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int map[][];
	static int checked[][];

	static StringBuilder sb;
	static HashSet<String> hash;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[5][5];

		sb = new StringBuilder();
		hash = new HashSet<>();

		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				checked = new int[5][5];
				sb.append(map[i][j]);
				dfs(i, j);
				sb.setLength(0);
			}
		}

		System.out.println(hash.size());
	}

	static void dfs(int xx, int yy) {
		checked[xx][yy]++;

		if (sb.length() == 6) {
			if (hash.contains(sb.toString()) != true)
				hash.add(sb.toString());

			return;
		}
		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx < 0 || nx >= 5 || ny < 0 || ny >= 5)
				continue;

			if (checked[nx][ny] > 4096)
				continue;

			sb.append(map[nx][ny]);
			dfs(nx, ny);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}