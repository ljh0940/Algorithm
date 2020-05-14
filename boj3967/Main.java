package boj3967;

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
	static char hexagram[][];

	static ArrayList<Pos> arr;

	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		hexagram = new char[5][9];
		checked = new boolean[12];

		arr = new ArrayList<>();

		for (int i = 0; i < 5; i++) {
			String str = br.readLine();
			for (int j = 0; j < 9; j++) {
				hexagram[i][j] = str.charAt(j);

				if (hexagram[i][j] == 'x')
					arr.add(new Pos(i, j));
				else if (hexagram[i][j] != '.')
					checked[hexagram[i][j] - 'A'] = true;
			}
		}

		solve(0);
	}

	static void solve(int index) {
		if (index == arr.size()) {
			if (checking1() < 1) {
				return;
			}
			if (checking2() < 1) {
				return;
			}
			if (checking3() < 1) {
				return;
			}
			if (checking4() < 1) {
				return;
			}
			if (checking5() < 1) {
				return;
			}
			if (checking6() < 1) {
				return;
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 9; j++) {
					sb.append(hexagram[i][j]);
				}
				sb.append("\n");
			}

			System.out.print(sb);
			System.exit(0);
		}

		for (int i = index; i < arr.size(); i++) {
			Pos p = arr.get(i);
			for (int j = 0; j < 12; j++) {
				if (checked[j] == true)
					continue;

				char c = (char) (j + 'A');

				hexagram[p.x][p.y] = c;
				checked[j] = true;
				if (checking1() < 0 || checking2() < 0 || checking3() < 0 || checking4() < 0 || checking5() < 0
						|| checking6() < 0) {
					checked[j] = false;
					hexagram[p.x][p.y] = 'x';
					continue;
				}
				solve(i + 1);
				checked[j] = false;
				hexagram[p.x][p.y] = 'x';
			}
		}
	}

	static int checking1() {
		if (hexagram[1][1] == 'x')
			return 0;
		if (hexagram[1][3] == 'x')
			return 0;
		if (hexagram[1][5] == 'x')
			return 0;
		if (hexagram[1][7] == 'x')
			return 0;
		int sum = hexagram[1][1] - 'A' + 1 + hexagram[1][3] - 'A' + 1 + hexagram[1][5] - 'A' + 1 + hexagram[1][7] - 'A'
				+ 1;
		if (sum != 26)
			return -1;
		return 1;
	}

	static int checking2() {
		if (hexagram[3][1] == 'x')
			return 0;
		if (hexagram[3][3] == 'x')
			return 0;
		if (hexagram[3][5] == 'x')
			return 0;
		if (hexagram[3][7] == 'x')
			return 0;
		int sum = hexagram[3][1] - 'A' + 1 + hexagram[3][3] - 'A' + 1 + hexagram[3][5] - 'A' + 1 + hexagram[3][7] - 'A'
				+ 1;
		if (sum != 26)
			return -1;
		return 1;
	}

	static int checking3() {
		if (hexagram[0][4] == 'x')
			return 0;
		if (hexagram[1][3] == 'x')
			return 0;
		if (hexagram[2][2] == 'x')
			return 0;
		if (hexagram[3][1] == 'x')
			return 0;
		int sum = hexagram[0][4] - 'A' + 1 + hexagram[1][3] - 'A' + 1 + hexagram[2][2] - 'A' + 1 + hexagram[3][1] - 'A'
				+ 1;
		if (sum != 26)
			return -1;

		return 1;
	}

	static int checking4() {
		if (hexagram[0][4] == 'x')
			return 0;
		if (hexagram[1][5] == 'x')
			return 0;
		if (hexagram[2][6] == 'x')
			return 0;
		if (hexagram[3][7] == 'x')
			return 0;

		int sum = hexagram[0][4] - 'A' + 1 + hexagram[1][5] - 'A' + 1 + hexagram[2][6] - 'A' + 1 + hexagram[3][7] - 'A'
				+ 1;
		if (sum != 26)
			return -1;

		return 1;
	}

	static int checking5() {
		if (hexagram[1][1] == 'x')
			return 0;
		if (hexagram[2][2] == 'x')
			return 0;
		if (hexagram[3][3] == 'x')
			return 0;
		if (hexagram[4][4] == 'x')
			return 0;

		int sum = hexagram[1][1] - 'A' + 1 + hexagram[2][2] - 'A' + 1 + hexagram[3][3] - 'A' + 1 + hexagram[4][4] - 'A'
				+ 1;
		if (sum != 26)
			return -1;

		return 1;
	}

	static int checking6() {
		if (hexagram[1][7] == 'x')
			return 0;
		if (hexagram[2][6] == 'x')
			return 0;
		if (hexagram[3][5] == 'x')
			return 0;
		if (hexagram[4][4] == 'x')
			return 0;

		int sum = hexagram[1][7] - 'A' + 1 + hexagram[2][6] - 'A' + 1 + hexagram[3][5] - 'A' + 1 + hexagram[4][4] - 'A'
				+ 1;
		if (sum != 26)
			return -1;

		return 1;
	}

}