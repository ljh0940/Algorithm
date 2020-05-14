package boj3987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

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
	static int time = -1;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int checked[][];

	static char signalOrder;

	static char map[][];

	static Pos start = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		map = new char[n][m];
		checked = new int[n][m];

		String string = "";
		for (int i = 0; i < n; i++) {
			string = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = string.charAt(j);
			}
		}

		str = br.readLine().split(" ");

		start = new Pos(Integer.parseInt(str[0]) - 1, Integer.parseInt(str[1]) - 1);

		solve('U');

		for (int i = 0; i < n; i++)
			Arrays.fill(checked[i], 0);
		solve('R');

		for (int i = 0; i < n; i++)
			Arrays.fill(checked[i], 0);
		solve('D');

		for (int i = 0; i < n; i++)
			Arrays.fill(checked[i], 0);
		solve('L');

		System.out.println(signalOrder);
		if (time != Integer.MAX_VALUE) {
			System.out.println(time);
		} else
			System.out.println("Voyager");
	}

	static void solve(char charOrder) {
		int count = 1;
		int order = 0;

		if (charOrder == 'U') {
			order = 2;
		} else if (charOrder == 'R') {
			order = 1;
		} else if (charOrder == 'D') {
			order = 0;
		} else if (charOrder == 'L') {
			order = 3;
		}

		Pos p = new Pos(start.x, start.y);
		while (true) {
			p.x = p.x + dx[order];
			p.y = p.y + dy[order];

			if (checking(p) == false) {
				if (time < count) {
					time = count;
					signalOrder = charOrder;
				}
				return;
			}

			if (checked[p.x][p.y] == order + 1) {
				if (time != Integer.MAX_VALUE)
					signalOrder = charOrder;
				time = Integer.MAX_VALUE;
				return;
			}

			checked[p.x][p.y] = order + 1;
			count++;

			if (map[p.x][p.y] == '\\')
				if (order % 2 == 0)
					order = turnLeft(order);
				else
					order = turnRight(order);

			if (map[p.x][p.y] == '/')
				if (order % 2 == 0)
					order = turnRight(order);
				else
					order = turnLeft(order);

		}
	}

	static boolean checking(Pos p) {
		if (p.x < 0 || p.x >= n || p.y < 0 || p.y >= m)
			return false;

		if (map[p.x][p.y] == 'C')
			return false;

		return true;
	}

	static int turnLeft(int order) {
		return (order + 1) % 4;
	}

	static int turnRight(int order) {
		return (order + 3) % 4;
	}
}
