package boj1915;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n;
	static int m;
	static int max = 0;

	static int rect[][];

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

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (rect[i][j] == 0)
					continue;

				if (max == 0)
					max = 1;

				if (i - 1 < 0 || j - 1 < 0)
					continue;

				rect[i][j] = 1 + Math.min(Math.min(rect[i - 1][j], rect[i][j - 1]), rect[i - 1][j - 1]);
				if (rect[i][j] > max)
					max = rect[i][j];
			}
		}

		System.out.println(max * max);
	}

}