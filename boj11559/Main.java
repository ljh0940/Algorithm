package boj11559;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Main {
	static char map[][];
	static ArrayList<Pos> arr;
	static boolean checked[][];

	static int count = 1;
	static int bombCount = 0;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		map = new char[12][6];
		arr = new ArrayList<>();

		for (int i = 0; i < 12; i++) {
			String str = br.readLine();
			for (int j = 0; j < 6; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		bomb();

		System.out.println(bombCount);
	}

	static void bomb() {
		boolean flag = false;
		do {
			checked = new boolean[12][6];
			for (int i = 0; i < 12; i++) {
				for (int j = 0; j < 6; j++) {
					if (map[i][j] != '.') {
						count = 1;
						arr.clear();
						dfs(i, j, map[i][j]);
						if (arr.size() >= 4) {
							for (int k = 0; k < arr.size(); k++) {
								Pos p = arr.get(k);
								map[p.x][p.y] = '#';
							}

						}
					}

				}
			}

			flag = move();

		} while (flag == true);
	}

	static int canMove(int index) {
		for (int i = 11; i >= 0; i--) {
			if (map[i][index] == '#')
				return i;
		}
		return 12;
	}

	static boolean move() {
		boolean flag = false;
		for (int j = 0; j < 6; j++) {
			int index = canMove(j);
			while (index != 12) {
				for (int i = index; i >= 0; i--) {
					if (map[i][j] == '#') {
						if (i - 1 < 0)
							map[i][j] = '.';
						else {
							map[i][j] = map[i - 1][j];
							map[i - 1][j] = '#';
						}
					}
				}
				index = canMove(j);
				flag = true;
			}
		}
		if (flag == true) {
			bombCount++;
		}

		return flag;

	}

	static void dfs(int xx, int yy, char color) {
		checked[xx][yy] = true;
		arr.add(new Pos(xx, yy));

		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx < 0 || nx >= 12 || ny < 0 || ny >= 6)
				continue;

			if (checked[nx][ny] == true)
				continue;

			if (color == map[nx][ny]) {
				dfs(nx, ny, color);
			}
		}
	}
}