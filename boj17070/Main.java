package boj17070;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int map[][][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		map = new int[4][n][n]; // 0 :원본, 1:가로, 2:세로, 3:대각선

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[0][i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 2; i < n; i++) {
			if (map[0][0][i] != 1) {
				map[1][0][i] = 11;
			} else
				break;
		}

		if (map[0][1][1] != 1 && map[0][1][2] != 1 && map[0][0][2] != 1)
			map[3][1][2] = 11;
		for (int i = 2; i < n; i++) {
			if (map[3][1][2] == 0)
				break;
			if (map[0][i][2] != 1)
				map[2][i][2] = 11;
			else
				break;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 3; j < n; j++) {
				if (map[0][i][j] != 1) {
					map[1][i][j] = (map[1][i][j - 1] == 1 ? 0 : map[1][i][j - 1])
							+ (map[3][i][j - 1] == 1 ? 0 : map[3][i][j - 1]);
					map[2][i][j] = (map[2][i - 1][j] == 1 ? 0 : map[2][i - 1][j])
							+ (map[3][i - 1][j] == 1 ? 0 : map[3][i - 1][j]);

					if (map[0][i - 1][j] != 1 && map[0][i][j - 1] != 1 && map[0][i - 1][j - 1] != 1)
						map[3][i][j] = (map[3][i - 1][j - 1] == 1 ? 0 : map[3][i - 1][j - 1])
								+ (map[1][i - 1][j - 1] == 1 ? 0 : map[1][i - 1][j - 1])
								+ (map[2][i - 1][j - 1] == 1 ? 0 : map[2][i - 1][j - 1]);
				}
			}
		}

		int sum = 0;
		for (int i = 1; i <= 3; i++) {
			sum = sum + map[i][n - 1][n - 1];
		}
		System.out.println(sum / 11);
	}
}