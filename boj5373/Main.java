package boj5373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static char copy[][] = { { '0', '0', '0', 'o', 'o', 'o', '0', '0', '0', '0', '0', '0' },
			{ '0', '0', '0', 'o', 'o', 'o', '0', '0', '0', '0', '0', '0' },
			{ '0', '0', '0', 'o', 'o', 'o', '0', '0', '0', '0', '0', '0' },
			{ 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b', 'y', 'y', 'y' },
			{ 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b', 'y', 'y', 'y' },
			{ 'g', 'g', 'g', 'w', 'w', 'w', 'b', 'b', 'b', 'y', 'y', 'y' },
			{ '0', '0', '0', 'r', 'r', 'r', '0', '0', '0', '0', '0', '0' },
			{ '0', '0', '0', 'r', 'r', 'r', '0', '0', '0', '0', '0', '0' },
			{ '0', '0', '0', 'r', 'r', 'r', '0', '0', '0', '0', '0', '0' } };
	static char cube[][] = new char[9][12];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			copy(copy, cube);
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				command(st.nextToken());
			}

			StringBuilder sb = new StringBuilder();
			for (int i = 3; i < 6; i++) {
				for (int j = 3; j < 6; j++) {
					sb.append(cube[i][j]);
				}
				sb.append("\n");
			}
			System.out.print(sb);
		}

	}

	static void copy(char[][] ori, char[][] copy) {
		for (int i = 0; i < ori.length; i++) {
			for (int j = 0; j < ori[i].length; j++)
				copy[i][j] = ori[i][j];
		}
	}

	static void command(String command) {
		int order = command.charAt(1) == '+' ? 1 : 3;
		if (command.charAt(0) == 'L') {
			L(order);
		} else if (command.charAt(0) == 'R') {
			R(order);
		} else if (command.charAt(0) == 'F') {
			F(order);
		} else if (command.charAt(0) == 'B') {
			B(order);
		} else if (command.charAt(0) == 'U') {
			U(order);
		} else if (command.charAt(0) == 'D') {
			D(order);
		}
	}

	static void U(int order) {
		for (int i = 0; i < order; i++) {
			rotate('U');

			for (int j = 0; j < 3; j++) {
				char temp = cube[6][3 + j];
				cube[6][3 + j] = cube[5 - j][6];
				cube[5 - j][6] = cube[2][5 - j];
				cube[2][5 - j] = cube[3 + j][2];
				cube[3 + j][2] = temp;
			}
		}
	}

	static void D(int order) {
		for (int i = 0; i < order; i++) {
			rotate('D');

			for (int j = 0; j < 3; j++) {
				char temp = cube[8][3 + j];
				cube[8][3 + j] = cube[3 + j][0];
				cube[3 + j][0] = cube[0][5 - j];
				cube[0][5 - j] = cube[5 - j][8];
				cube[5 - j][8] = temp;
			}
		}
	}

	static void B(int order) {
		for (int i = 0; i < order; i++) {
			rotate('B');

			for (int j = 0; j < 3; j++) {
				char temp = cube[3][3 + j];
				cube[3][3 + j] = cube[3][6 + j];
				cube[3][6 + j] = cube[3][11 - j];
				cube[3][11 - j] = cube[3][0 + j];
				cube[3][0 + j] = temp;
			}
		}
	}

	static void F(int order) {
		for (int i = 0; i < order; i++) {
			rotate('F');

			for (int j = 0; j < 3; j++) {
				char temp = cube[5][5 - j];
				cube[5][5 - j] = cube[5][2 - j];
				cube[5][2 - j] = cube[5][9 + j];
				cube[5][9 + j] = cube[5][8 - j];
				cube[5][8 - j] = temp;
			}
		}
	}

	static void R(int order) {
		for (int i = 0; i < order; i++) {
			rotate('R');

			for (int j = 0; j < 3; j++) {
				char temp = cube[3 + j][5];
				cube[3 + j][5] = cube[6 + j][5];
				cube[6 + j][5] = cube[5 - j][11];
				cube[5 - j][11] = cube[0 + j][5];
				cube[0 + j][5] = temp;
			}
		}
	}

	static void L(int order) {
		for (int i = 0; i < order; i++) {
			rotate('L');

			for (int j = 0; j < 3; j++) {
				char temp = cube[3 + j][3];
				cube[3 + j][3] = cube[0 + j][3];
				cube[0 + j][3] = cube[5 - j][9];
				cube[5 - j][9] = cube[6 + j][3];
				cube[6 + j][3] = temp;
			}
		}
	}

	static void rotate(char order) {

		int x = 0;
		int y = 0;

		if (order == 'L') {
			x = 3;
			y = 0;
		} else if (order == 'R') {
			x = 3;
			y = 6;
		} else if (order == 'U') {
			x = 3;
			y = 3;
		} else if (order == 'D') {
			x = 3;
			y = 9;
		} else if (order == 'F') {
			x = 6;
			y = 3;
		} else if (order == 'B') {
			x = 0;
			y = 3;
		}
		if (order != 'D') {
			char temp = cube[0 + x][0 + y];
			cube[0 + x][0 + y] = cube[2 + x][0 + y];
			cube[2 + x][0 + y] = cube[2 + x][2 + y];
			cube[2 + x][2 + y] = cube[0 + x][2 + y];
			cube[0 + x][2 + y] = temp;

			temp = cube[1 + x][0 + y];
			cube[1 + x][0 + y] = cube[2 + x][1 + y];
			cube[2 + x][1 + y] = cube[1 + x][2 + y];
			cube[1 + x][2 + y] = cube[0 + x][1 + y];
			cube[0 + x][1 + y] = temp;
		} else {
			char temp = cube[0 + x][0 + y];
			cube[0 + x][0 + y] = cube[0 + x][2 + y];
			cube[0 + x][2 + y] = cube[2 + x][2 + y];
			cube[2 + x][2 + y] = cube[2 + x][0 + y];
			cube[2 + x][0 + y] = temp;

			temp = cube[1 + x][0 + y];
			cube[1 + x][0 + y] = cube[0 + x][1 + y];
			cube[0 + x][1 + y] = cube[1 + x][2 + y];
			cube[1 + x][2 + y] = cube[2 + x][1 + y];
			cube[2 + x][1 + y] = temp;
		}
	}

}