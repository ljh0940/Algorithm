package boj14499;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int map[][];
	static int n;
	static int m;
	static int diceX;
	static int diceY;

	static int diceMap[][] = new int[4][3];
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		diceX = Integer.parseInt(st.nextToken());
		diceY = Integer.parseInt(st.nextToken());

		int k = Integer.parseInt(st.nextToken());

		map = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < k; i++) {
			int order = Integer.parseInt(st.nextToken());
			dice(order);
		}

		System.out.print(sb);

	}

	static void dice(int order) {
		if (order == 1) { // µ¿
			if (diceY + 1 >= m)
				return;

			diceY++;

			int temp = diceMap[1][2];
			diceMap[1][2] = diceMap[1][1];
			diceMap[1][1] = diceMap[1][0];
			diceMap[1][0] = diceMap[3][1];
			diceMap[3][1] = temp;
		}
		if (order == 2) { // ¼­
			if (diceY - 1 < 0)
				return;

			diceY--;

			int temp = diceMap[1][0];
			diceMap[1][0] = diceMap[1][1];
			diceMap[1][1] = diceMap[1][2];
			diceMap[1][2] = diceMap[3][1];
			diceMap[3][1] = temp;
		}
		if (order == 3) { // ºÏ
			if (diceX - 1 < 0)
				return;

			diceX--;

			int temp = diceMap[0][1];
			diceMap[0][1] = diceMap[1][1];
			diceMap[1][1] = diceMap[2][1];
			diceMap[2][1] = diceMap[3][1];
			diceMap[3][1] = temp;
		}
		if (order == 4) { // ³²
			if (diceX + 1 >= n)
				return;

			diceX++;

			int temp = diceMap[3][1];
			diceMap[3][1] = diceMap[2][1];
			diceMap[2][1] = diceMap[1][1];
			diceMap[1][1] = diceMap[0][1];
			diceMap[0][1] = temp;
		}

		if (map[diceX][diceY] == 0) {
			map[diceX][diceY] = diceMap[3][1];
		} else {
			diceMap[3][1] = map[diceX][diceY];
			map[diceX][diceY] = 0;
		}

		sb.append(diceMap[1][1]);
		sb.append("\n");
	}
}