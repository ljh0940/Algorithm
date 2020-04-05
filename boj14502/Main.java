package boj14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Main {

	static int n;
	static int m;
	static int max;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static int map[][];
	static int copyMap[][];
	static boolean checked[][];

	static ArrayList<Pos> land;
	static ArrayList<Pos> virus;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		land = new ArrayList<>();
		virus = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0)
					land.add(new Pos(i, j));
				if (map[i][j] == 2)
					virus.add(new Pos(i, j));
			}
		}

		copyMap = new int[n][m];

		solve(0, 0);

		System.out.println(max);
	}

	static void copy(int ori[][], int copy[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = ori[i][j];
			}
		}
	}

	static void solve(int index, int count) {
		if (count == 3) {
			copy(map, copyMap);
			checked = new boolean[n][m];
			for (int i = 0; i < virus.size(); i++) {
				Pos p = virus.get(i);
				dfs(p.x, p.y);
			}
			max = Math.max(max, check());
			return;
		}

		for (int i = index; i < land.size(); i++) {
			Pos p = land.get(i);
			map[p.x][p.y] = 1;

			solve(i + 1, count + 1);
			map[p.x][p.y] = 0;
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

			if (copyMap[nx][ny] == 0) {
				copyMap[nx][ny] = 2;
				dfs(nx, ny);
			}
		}
	}

	static int check() {
		int count = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 0)
					count++;
			}
		}

		return count;
	}
}