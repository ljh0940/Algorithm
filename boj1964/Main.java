package boj1964;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		long dp[] = new long[n + 1];

		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				dp[i] = 5;
				continue;
			} else {
				dp[i] = dp[i - 1] + 3 * i + 1;
			}
		}

		System.out.println(dp[n] % 45678);
	}
}