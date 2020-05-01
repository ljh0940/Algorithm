package boj13460;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Case {
	Pos blue;
	Pos red;

	Case(Pos red, Pos blue) {
		this.red = red;
		this.blue = blue;
	}
}

class Main {
	static int n;
	static int m;
	static int count = 0;

	static char map[][];
	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static Pos goal = null;
	static Pos red = null;
	static Pos blue = null;

	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		map = new char[n][m];

		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = string.charAt(j);

				if (map[i][j] == 'O')
					goal = new Pos(i, j);

				if (map[i][j] == 'R')
					red = new Pos(i, j);

				if (map[i][j] == 'B')
					blue = new Pos(i, j);
			}
		}

		System.out.println(bfs() ? count : -1);

	}

	static boolean bfs() {
		Queue<Case> q = new LinkedList<Case>();
		q.add(new Case(red, blue));

		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			for (int k = 0; k < size; k++) {
				Case c = q.poll();

				for (int i = 0; i < 4; i++) {
					Pos tempBlue = new Pos(c.blue.x, c.blue.y);
					Pos tempRed = new Pos(c.red.x, c.red.y);
					move(tempRed, tempBlue, i);

					if (tempBlue.x == 0 && tempBlue.y == 0) {
						continue;
					}

					if (tempRed.x == 0 && tempRed.y == 0) {
						if (tempBlue.x == 0 && tempBlue.y == 0) {
							continue;
						}
						return true;
					}

					q.add(new Case(tempRed, tempBlue));
				}
			}

			if (count == 10)
				return false;
		}

		return false;
	}

	static void move(Pos red, Pos blue, int order) {
		int redX = red.x;
		int redY = red.y;
		int blueX = blue.x;
		int blueY = blue.y;

		while (true) {
			if (map[red.x + dx[order]][red.y + dy[order]] == '#')
				break;
			red.x = red.x + dx[order];
			red.y = red.y + dy[order];

			if (map[red.x][red.y] == 'O') {
				red.x = 0;
				red.y = 0;
				break;
			}
		}

		while (true) {
			if (map[blue.x + dx[order]][blue.y + dy[order]] == '#')
				break;
			blue.x = blue.x + dx[order];
			blue.y = blue.y + dy[order];

			if (map[blue.x][blue.y] == 'O') {
				blue.x = 0;
				blue.y = 0;
				return;
			}
		}

		if (red.x == blue.x && red.y == blue.y) {
			if (order == 0) {
				if (redX > blueX) {
					blue.x = blue.x - dx[order];
				} else if (redX < blueX) {
					red.x = red.x - dx[order];
				}
			} else if (order == 2) {
				if (redX > blueX) {
					red.x = red.x - dx[order];
				} else if (redX < blueX) {
					blue.x = blue.x - dx[order];
				}
			}
			if (order == 1) {
				if (redY > blueY) {
					blue.y = blue.y - dy[order];
				} else if (redY < blueY) {
					red.y = red.y - dy[order];
				}
			} else if (order == 3) {
				if (redY > blueY) {
					red.y = red.y - dy[order];
				} else if (redY < blueY) {
					blue.y = blue.y - dy[order];
				}
			}
		}
	}
}