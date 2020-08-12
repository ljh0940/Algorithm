package boj1783;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n;
	static int m;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input[] = br.readLine().split(" ");
		n = Integer.parseInt(input[0]);
		m = Integer.parseInt(input[1]);

		if (n >= 3 && m >= 7) {
			System.out.println(m - 2);
			return;
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}

		if (n == 2) {
			System.out.println(Math.min((m - 1) / 2 + 1, 4));
			return;
		}
		if (n >= 3) {
			System.out.println(Math.min(m, 4));
			return;
		}
	}
}