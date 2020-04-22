package boj15683;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int camera;
	int order = 0;

	/*
	 * camera 1: 0 - ³² 1 - µ¿ 2 - ºÏ 3 - ¼­
	 */
	/*
	 * camera 2: 0 - ³²ºÏ 1 - µ¿¼­
	 */
	/*
	 * camera 3: 0 - ³²µ¿ 1 - ºÏµ¿ 2 - ºÏ¼­ 3 - ³²¼­
	 */
	/*
	 * camera 4: 0 - ³² 1 - µ¿ 2 - ºÏ 3 - ¼­
	 */
	/*
	 * camera 1: 0 - µ¿¼­³²ºÏ
	 */

	Pos(int x, int y, int camera) {
		this.x = x;
		this.y = y;
		this.camera = camera;
	}

}

class Main {
	static int n;
	static int m;
	static int map[][];
	static int copyMap[][];

	static int min = Integer.MAX_VALUE;

	static int dx[] = { 1, 0, -1, 0 }; // ³² µ¿ ºÏ ¼­
	static int dy[] = { 0, 1, 0, -1 };

	static ArrayList<Pos> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();

		map = new int[n][m];
		copyMap = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] > 0 && map[i][j] < 6)
					arr.add(new Pos(i, j, map[i][j]));
			}
		}

		copy(map, copyMap);
		solve(0, 0);

		System.out.println(min);

	}

	static void solve(int index, int depth) {
		if (depth == arr.size()) {
			for (int i = 0; i < arr.size(); i++) {
				change(arr.get(i));
			}

			min = Math.min(min, calc());
			copy(map, copyMap);
			return;
		}

		if (arr.get(index).camera == 1 || arr.get(index).camera == 3 || arr.get(index).camera == 4)
			for (int i = 0; i < 4; i++) {
				arr.get(index).order = i;
				solve(index + 1, depth + 1);
			}
		else if (arr.get(index).camera == 2) {
			for (int i = 0; i < 2; i++) {
				arr.get(index).order = i;
				solve(index + 1, depth + 1);
			}
		} else {
			solve(index + 1, depth + 1);
		}
	}

	static void copy(int ori[][], int copy[][]) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				copy[i][j] = ori[i][j];
			}
		}
	}

	static int calc() {
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyMap[i][j] == 0)
					count++;
			}
		}

		return count;
	}

	static void change(Pos p) {
		int currentOrder = p.order;
		int camera = map[p.x][p.y];

		if (camera == 1) {
			int nx = p.x;
			int ny = p.y;
			while (true) {
				nx = nx + dx[currentOrder];
				ny = ny + dy[currentOrder];

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					break;

				if (copyMap[nx][ny] == 6)
					break;

				if (copyMap[nx][ny] == 0)
					copyMap[nx][ny] = 1;
			}

		}
		if (camera == 2) {

			for (int i = 0; i <= 2; i = i + 2) {
				int nx = p.x;
				int ny = p.y;
				int index = currentOrder + i;
				while (true) {
					nx = nx + dx[index];
					ny = ny + dy[index];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						break;

					if (copyMap[nx][ny] == 6)
						break;

					if (copyMap[nx][ny] == 0)
						copyMap[nx][ny] = 1;
				}
			}
		}
		if (camera == 3) {

			for (int i = 0; i < 2; i++) {
				int nx = p.x;
				int ny = p.y;
				int index = (currentOrder + i) % 4;
				while (true) {
					nx = nx + dx[index];
					ny = ny + dy[index];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						break;

					if (copyMap[nx][ny] == 6)
						break;

					if (copyMap[nx][ny] == 0)
						copyMap[nx][ny] = 1;
				}
			}
		}
		if (camera == 4) {

			for (int i = 1; i <= 3; i++) {
				int nx = p.x;
				int ny = p.y;
				int index = (currentOrder + i) % 4;
				while (true) {
					nx = nx + dx[index];
					ny = ny + dy[index];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						break;

					if (copyMap[nx][ny] == 6)
						break;

					if (copyMap[nx][ny] == 0)
						copyMap[nx][ny] = 1;
				}

			}
		}
		if (camera == 5) {
			for (int i = 0; i < 4; i++) {
				int nx = p.x;
				int ny = p.y;
				while (true) {
					nx = nx + dx[i];
					ny = ny + dy[i];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						break;

					if (copyMap[nx][ny] == 6)
						break;

					if (copyMap[nx][ny] == 0)
						copyMap[nx][ny] = 1;
				}
			}

		}
	}

}