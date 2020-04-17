package boj15685;

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
	static int map[][] = new int[101][101];
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	static ArrayList<Pos> arr;

	static Pos pivot = null;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();

		for (int k = 0; k < n; k++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int order = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
			arr.clear();

			map[x][y] = 1;
			arr.add(new Pos(x, y));

			dragonCurve(x, y, order, gen);
		}

		System.out.println(calc());
	}

	static int calc() {
		int count = 0;
		for (int i = 0; i <= 99; i++) {
			for (int j = 0; j <= 99; j++) {
				if (map[i][j] == 1 && map[i][j + 1] == 1 && map[i + 1][j] == 1 && map[i + 1][j + 1] == 1)
					count++;
			}
		}

		return count;
	}

	static void dragonCurve(int x, int y, int order, int gen) {
		pivot = new Pos(x + dx[order], y + dy[order]);
		arr.add(pivot);

		Pos nextPivot = pivot;
		for (int k = 0; k < gen; k++) {
			int size = arr.size();

			pivot = nextPivot;
			for (int i = 0; i < size; i++) {
				x = arr.get(i).x;
				y = arr.get(i).y;

				if (x == pivot.x && y == pivot.y)
					continue;

				int tempX = pivot.y - y;
				int tempY = pivot.x - x;

				x = pivot.x - tempX;
				y = pivot.y + tempY;

				if (i == 0) {
					nextPivot = new Pos(x, y);
				}

				arr.add(new Pos(x, y));
			}
		}

		for (int i = 0; i < arr.size(); i++) {
			Pos p = arr.get(i);

			map[p.x][p.y] = 1;
		}
	}
}