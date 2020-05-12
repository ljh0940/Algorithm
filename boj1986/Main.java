package boj1986;

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

class Main {
	static int n;
	static int m;

	static int queenX[] = { 1, 0, -1, 0, 1, 1, -1, -1 };
	static int queenY[] = { 0, 1, 0, -1, -1, 1, -1, 1 };
	static int knightX[] = { -1, -1, 1, 1, -2, -2, 2, 2 };
	static int knightY[] = { -2, 2, -2, 2, -1, 1, -1, 1 };
	static int map[][];

	static ArrayList<Pos> chess[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		chess = new ArrayList[3];

		for (int i = 0; i < 3; i++) {
			chess[i] = new ArrayList<>();
		}

		map = new int[n][m];

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			for (int j = 0; j < count; j++) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				int y = Integer.parseInt(st.nextToken()) - 1;

				chess[i].add(new Pos(x, y));
				map[x][y] = i + 1;
			}
		}

		moveQueen();
		moveKnight();

		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] == 0)
					count++;
			}
		}

		System.out.println(count);

	}

	static void moveQueen() {
		for (int i = 0; i < chess[0].size(); i++) {
			Pos queen = chess[0].get(i);

			for (int j = 0; j < 8; j++) {
				int nx = queen.x;
				int ny = queen.y;
				do {
					nx = nx + queenX[j];
					ny = ny + queenY[j];

					if (check(nx, ny) == false)
						break;

					map[nx][ny] = 10;

				} while (true);
			}
		}
	}

	static void moveKnight() {
		for (int i = 0; i < chess[1].size(); i++) {
			Pos knight = chess[1].get(i);

			for (int j = 0; j < 8; j++) {
				int nx = knight.x;
				int ny = knight.y;
				nx = nx + knightX[j];
				ny = ny + knightY[j];

				if (check(nx, ny) == false)
					continue;

				map[nx][ny] = 10;

			}
		}
	}

	static boolean check(int x, int y) {
		if (x < 0 || x >= n || y < 0 || y >= m)
			return false;
		if (map[x][y] == 0 || map[x][y] == 10)
			return true;
		return false;
	}
}