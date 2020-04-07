package boj2146;

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
	int depth;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Pos(int x, int y, int depth) {
		this.x = x;
		this.y = y;
		this.depth = depth;
	}
}

class Main {

	static int n;
	static int min = Integer.MAX_VALUE;
	static int landNum = 2;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static int map[][];
	static boolean checked[][];

	static ArrayList<Pos> edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		checked = new boolean[n][n];
		edge = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					land(i, j);
					landNum++;
				}
			}
		}

		Pos p = new Pos(0, 0);

		for (int i = 0; i < edge.size(); i++) {
			for (int j = 0; j < n; j++) {
				Arrays.fill(checked[j], false);
			}
			p = edge.get(i);
			bfs(p.x, p.y, map[p.x][p.y]);
		}

		System.out.println(min);

	}

	static void bfs(int xx, int yy, int num) {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(xx, yy, 0));

		while (!q.isEmpty()) {
			Pos p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];

				if (p.depth >= min)
					continue;

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					continue;

				if (checked[nx][ny] == true)
					continue;

				if (map[nx][ny] == num)
					continue;

				if (map[nx][ny] == 0) {
					checked[nx][ny] = true;
					q.add(new Pos(nx, ny, p.depth + 1));
					continue;
				}

				min = Math.min(min, p.depth);
				return;
			}
		}
	}

	static void land(int xx, int yy) {
		checked[xx][yy] = true;
		map[xx][yy] = landNum;

		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= n)
				continue;

			if (checked[nx][ny] == true)
				continue;

			if (map[nx][ny] == 0) {
				edge.add(new Pos(xx, yy));
				continue;
			}

			if (map[nx][ny] == 1) {
				map[nx][ny] = landNum;
				land(nx, ny);
			}
		}
	}
}