package boj17142;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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
	static int m;
	static int min = Integer.MAX_VALUE;

	static int map[][];
	static int copyMap[][];
	static boolean checked[][];
	static boolean selected[];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static ArrayList<Pos> virus;
	static Queue<Pos> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		copyMap = new int[n][n];
		checked = new boolean[n][n];
		virus = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 2)
					virus.add(new Pos(i, j));
			}
		}
		selected = new boolean[virus.size()];

		combination(0, 0);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	static boolean isEnd() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (copyMap[i][j] == 0)
					return false;
			}
		}

		return true;
	}

	static void bfs() {
		for (int i = 0; i < virus.size(); i++) {
			if (selected[i] == true) {
				Pos p = virus.get(i);
				q.add(p);
				checked[p.x][p.y] = true;
			}
		}

		int length = 10;
		while (!q.isEmpty()) {
			if (isEnd() == true) {
				if (min > length - 10)
					min = length - 10;
			}

			int size = q.size();

			length++;
			for (int k = 0; k < size; k++) {
				Pos p = q.poll();

				for (int i = 0; i < 4; i++) {
					int nx = p.x + dx[i];
					int ny = p.y + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;

					if (checked[nx][ny] == true)
						continue;

					if (copyMap[nx][ny] == 1)
						continue;

					checked[nx][ny] = true;
					if (copyMap[nx][ny] == 0) {
						copyMap[nx][ny] = length;
					}
					q.add(new Pos(nx, ny));

				}
			}
		}

	}

	static void combination(int index, int depth) {
		if (depth == m) {
			copyMap(map, copyMap);
			for (int i = 0; i < n; i++) {
				Arrays.fill(checked[i], false);
			}

			bfs();

			return;

		}

		for (int i = index; i < virus.size(); i++) {
			selected[i] = true;
			combination(i + 1, depth + 1);
			selected[i] = false;
		}
	}

	static void copyMap(int ori[][], int copy[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = ori[i][j];
			}
		}
	}
}