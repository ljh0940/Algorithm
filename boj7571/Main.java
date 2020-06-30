package boj7571;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		int dx[] = new int[m];
		int dy[] = new int[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			dx[i] = x;
			dy[i] = y;
		}

		Arrays.sort(dx);
		Arrays.sort(dy);

		int x = dx[m / 2];
		int y = dy[m / 2];

		int sum = 0;
		for (int i = 0; i < m; i++) {
			sum = sum + calc(dx[i], dy[i], x, y);
		}

		System.out.println(sum);

	}

	static int calc(int x1, int y1, int x2, int y2) {
		int x = x1 - x2;
		int y = y1 - y2;

		if (x < 0)
			x = -x;
		if (y < 0)
			y = -y;

		return x + y;
	}
}
