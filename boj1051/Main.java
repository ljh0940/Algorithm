package boj1051;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int rect[][];
	static int count = 0;
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		rect = new int[n][m];

		for (int i = 0; i < n; i++) {
			String string = br.readLine();
			for (int j = 0; j < m; j++) {
				rect[i][j] = string.charAt(j) - '0';
			}
		}

		calc();

		System.out.println(count == 0 ? 1 : count);
	}

	static void calc() {
		for (int i = 0; i < n - 1; i++) {
			for (int j = 0; j < m - 1; j++) {
				int value = rect[i][j];
				for (int k = 1; k + i < n && k + j < m; k++) {
					if (rect[i][k + j] != value)
						continue;
					if (rect[i + k][j] != value)
						continue;
					if (rect[i + k][j + k] != value)
						continue;

					int sum = (int) Math.pow(k + 1, 2);

					if (count < sum)
						count = sum;
				}
			}
		}
	}
}