package boj17144;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int t;
	static int startPos;
	static int count;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int nowMap[][];
	static int nextMap[][];
	static int countMap[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		t = Integer.parseInt(st.nextToken());

		nowMap = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				nowMap[i][j] = Integer.parseInt(st.nextToken());

				if (nowMap[i][j] == -1 && startPos == 0)
					startPos = i;
			}
		}

		for (int k = 0; k < t; k++) {
			nextMap = new int[n][m];
			countMap = new int[n][m];
			spread();
			mergeMap();
			blowUp();
			blowDown();
		}

		calcDust();

		System.out.println(count);
	}

	static void calcDust() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (nowMap[i][j] > 0)
					count += nowMap[i][j];
			}
		}
	}

	static void mergeMap() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				nowMap[i][j] = nowMap[i][j] - countMap[i][j] + nextMap[i][j];
			}
		}
	}

	static void blowUp() {
		int x = startPos - 1;
		int y = 0;
		int nextX = startPos - 2;
		int nextY = 0;

		int xFlag = -1;
		int yFlag = 0;
		while (true) {
			if (nextX == startPos && nextY == 0) {
				nowMap[x][y] = 0;
				break;
			}

			nowMap[x][y] = nowMap[nextX][nextY];
			x = nextX;
			y = nextY;

			if (nextX == 0 && nextY == 0) {
				xFlag = 0;
				yFlag = 1;
			} else if (nextX == 0 && nextY == m - 1) {
				xFlag = 1;
				yFlag = 0;
			} else if (nextX == startPos && nextY == m - 1) {
				xFlag = 0;
				yFlag = -1;
			}

			nextX += xFlag;
			nextY += yFlag;
		}
	}

	static void blowDown() {
		int x = startPos + 2;
		int y = 0;
		int nextX = startPos + 3;
		int nextY = 0;

		int xFlag = 1;
		int yFlag = 0;
		while (true) {
			if (nextX == startPos + 1 && nextY == 0) {
				nowMap[x][y] = 0;
				break;
			}

			nowMap[x][y] = nowMap[nextX][nextY];
			x = nextX;
			y = nextY;

			if (nextX == n - 1 && nextY == 0) {
				xFlag = 0;
				yFlag = 1;
			} else if (nextX == n - 1 && nextY == m - 1) {
				xFlag = -1;
				yFlag = 0;
			} else if (nextX == startPos + 1 && nextY == m - 1) {
				xFlag = 0;
				yFlag = -1;
			}

			nextX += xFlag;
			nextY += yFlag;
		}
	}

	static void spread() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				int count = 0;
				if (nowMap[i][j] <= 0)
					continue;

				int newDust = nowMap[i][j] / 5;
				for (int k = 0; k < 4; k++) {
					int nx = i + dx[k];
					int ny = j + dy[k];

					if (nx < 0 || nx >= n || ny < 0 || ny >= m)
						continue;

					if (nowMap[nx][ny] == -1)
						continue;

					count++;

					nextMap[nx][ny] += newDust;
				}

				countMap[i][j] = count * newDust;
			}
		}
	}
}