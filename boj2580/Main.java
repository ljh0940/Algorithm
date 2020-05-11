package boj2580;

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
	static int map[][];
	static ArrayList<Pos> arr;
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		map = new int[9][9];
		arr = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 0)
					arr.add(new Pos(i, j));
			}
		}

		dfs(0);

	}

	static void dfs(int index) {
		if (index == arr.size()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}

			System.out.print(sb.toString());
			System.exit(0);

		}
		Pos p = arr.get(index);

		for (int j = 1; j <= 9; j++) {
			if (checking(p, j) == false)
				continue;

			map[p.x][p.y] = j;
			dfs(index + 1);
			map[p.x][p.y] = 0;
		}

	}

	static boolean checking(Pos p, int num) {
		for (int i = 0; i < 9; i++) {
			if (map[i][p.y] == num || map[p.x][i] == num)
				return false;
		}

		for (int i = p.x / 3 * 3; i < p.x / 3 * 3 + 3; i++) {
			for (int j = p.y / 3 * 3; j < p.y / 3 * 3 + 3; j++) {
				if (map[i][j] == num)
					return false;
			}
		}

		return true;
	}

}