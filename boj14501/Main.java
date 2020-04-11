package boj14501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Temp {
	int t;
	int p;

	Temp(int t, int p) {
		this.t = t;
		this.p = p;
	}
}

class Main {
	static int n;

	static Temp temp[];
	static int dp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		temp = new Temp[n + 1];
		dp = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());

			temp[i] = new Temp(t, p);

		}

		for (int i = 1; i <= n; i++) {
			solve(i, i);
		}

		int max = 0;

		for (int i = 1; i <= n; i++) {
			if (max < dp[i])
				max = dp[i];
		}

		System.out.println(max);

	}

	static void solve(int index, int day) {
		int t = temp[day].t;
		int p = temp[day].p;

		if (day + t - 1 > n)
			return;

		if (index == day) {
			dp[day] = Math.max(temp[day].p, dp[day]);
		} else {
			dp[day] = Math.max(dp[day], dp[index] + p);
		}
		for (int i = day + t; i <= n + 1; i++) {
			if (i > n)
				break;

			solve(day, i);
		}
	}

}