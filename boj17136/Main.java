package boj17136;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
	static int map[][];
	static int papers[];
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		map = new int[10][10];
		papers = new int[5];

		Arrays.fill(papers, 5);

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Pos p = check();

		if (p == null) {
			System.out.println(0);
			return;
		} else {
			combination(p.x, p.y, 1);
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void combination(int x, int y, int depth) {
		if (depth > min)
			return;

		for (int k = 1; k <= 5; k++) {
			if (papers[k - 1] <= 0)
				continue;

			if (isAvailable(x, y, k) == true) {
				papers[k - 1]--;
				fillMap(x, y, k, 0);

				Pos p = check();
				if (p == null) {
					min = Math.min(min, depth);
					fillMap(x, y, k, 1);
					papers[k - 1]++;
					return;
				} else {
					combination(p.x, p.y, depth + 1);
					fillMap(x, y, k, 1);
					papers[k - 1]++;
				}
			}
		}
	}

	static Pos check() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1)
					return new Pos(i, j);
			}
		}

		return null;
	}

	static boolean isAvailable(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (i < 0 || i >= 10)
					return false;

				if (j < 0 || j >= 10)
					return false;

				if (map[i][j] == 0)
					return false;
			}
		}

		return true;
	}

	static void fillMap(int x, int y, int size, int num) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = num;
			}
		}
	}
}