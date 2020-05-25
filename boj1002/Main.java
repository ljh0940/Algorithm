package boj1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			// 일치하는 경우 - 무수히 많은 경우
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);
				continue;
			}

			// 원의 내부에 있고 안 겹침
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) < abs(r1 - r2)) {
				System.out.println(0);
				continue;
			}

			// 원 내접
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) == abs(r1 - r2)) {
				System.out.println(1);
				continue;
			}

			// 원 외접
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) == abs(r1 + r2)) {
				System.out.println(1);
				continue;
			}

			// 서로 밖에 있는 경우
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) > r1 + r2) {
				System.out.println(0);
				continue;
			}

			else {
				System.out.println(2);
				continue;
			}

		}
	}

	static int abs(int n) {
		if (n > 0)
			return n;
		else
			return -n;
	}

	static int pow(int n) {
		return n * n;
	}
}