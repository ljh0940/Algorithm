package boj14503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot {
	int x;
	int y;
	int order;

	Robot(int x, int y, int order) {
		this.x = x;
		this.y = y;
		this.order = order;
	}
}

class Main {
	static int count = 0;
	static int n = 0;
	static int m = 0;
	static boolean flag = true;

	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int map[][] = { {} };

	static Robot robot = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		st = new StringTokenizer(br.readLine());

		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int order = Integer.parseInt(st.nextToken()); // 0:ºÏ 1:µ¿ 2:³² 3:¼­

		robot = new Robot(x, y, order);

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		if (map[robot.x][robot.y] == 0) {
			map[robot.x][robot.y] = 2;
			count++;
		}

		while (true) {
			if (solve() == false)
				break;
		}
		System.out.println(count);
	}

	static boolean solve() {
		for (int i = 3; i >= 0; i--) {
			int nextOrder = (robot.order + i) % 4;
			int nx = robot.x + dx[nextOrder];
			int ny = robot.y + dy[nextOrder];

			if (nx < 1 || nx >= n - 1 || ny < 1 || ny >= m - 1)
				continue;

			if (map[nx][ny] == 1)
				continue;

			if (map[nx][ny] == 0) {
				robot.x = nx;
				robot.y = ny;
				robot.order = nextOrder;
				map[robot.x][robot.y] = 2;
				count++;

				return true;
			}
		}

		int nextOrder = (robot.order + 2) % 4;
		int nx = robot.x + dx[nextOrder];
		int ny = robot.y + dy[nextOrder];

		if (nx < 1 || nx >= n - 1 || ny < 1 || ny >= m - 1)
			return false;

		if (map[nx][ny] == 1)
			return false;

		robot.x = nx;
		robot.y = ny;

		return true;
	}

}