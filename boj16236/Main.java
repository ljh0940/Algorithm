package boj16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int size = 2;
	int count = 0;
	int depth = 0;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Pos(int x, int y, int size, int depth) {
		this.x = x;
		this.y = y;
		this.size = size;
		this.depth = depth;
	}
}

class Main {
	static int map[][];
	static int dx[] = { -1, 0, 0, 1 };
	static int dy[] = { 0, -1, 1, 0 };

	static int n;
	static int time;

	static Pos shark = null;

	static boolean checked[][];
	static boolean fish[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		checked = new boolean[n][n];
		fish = new boolean[n][n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 9) {
					shark = new Pos(i, j);
					map[i][j] = 0;
				}
			}
		}

		if (newFish() == true) {
			bfs();
		}
		System.out.println(time);
	}

	static boolean grow() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(checked[i], false);
		}
		if (shark.size == shark.count) {
			shark.size++;
			shark.count = 0;
		}
		return newFish();

	}

	static boolean newFish() {
		for (int i = 0; i < n; i++) {
			Arrays.fill(fish[i], false);
		}

		Pos p = selectFish();
		if (p == null)
			return false;
		else {
			for (int i = 0; i < n; i++) {
				Arrays.fill(fish[i], false);
			}
			fish[p.x][p.y] = true;
		}
		for (int i = 0; i < n; i++) {
			Arrays.fill(checked[i], false);
		}
		return true;

	}

	static Pos selectFish() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(shark);
		checked[shark.x][shark.y] = true;

		int count = Integer.MAX_VALUE;
		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (count < p.depth)
					break;

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (checked[nx][ny] == true)
					continue;

				if (map[nx][ny] > p.size)
					continue;

				if (map[nx][ny] < p.size && map[nx][ny] != 0) {
					fish[nx][ny] = true;
					count = p.depth;
				}

				checked[nx][ny] = true;
				q.add(new Pos(nx, ny, p.size, p.depth + 1));
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (fish[i][j] == true)
					return new Pos(i, j);
			}
		}

		return null;
	}

	static void bfs() {
		Queue<Pos> q = new LinkedList<Pos>();
		q.add(shark);
		checked[shark.x][shark.y] = true;

		while (!q.isEmpty()) {
			Pos p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (checked[nx][ny] == true)
					continue;

				if (map[nx][ny] > shark.size)
					continue;

				if (fish[nx][ny] == true) {
					map[nx][ny] = 0;
					shark.count++;
					time = time + p.depth + 1;
					shark.x = nx;
					shark.y = ny;
					if (grow() == true)
						bfs();
					else
						break;
				}
				checked[nx][ny] = true;
				q.add(new Pos(nx, ny, p.size, p.depth + 1));
			}
		}

	}
}