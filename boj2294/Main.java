package boj2294;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		int dp[] = new int[k + 1];
		Arrays.fill(dp, 1000000);

		ArrayList<Integer> coins = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int coin = Integer.parseInt(st.nextToken());
			if (coin > k)
				continue;
			coins.add(coin);
			dp[coin] = 1;
		}

		if (coins.size() == 0) {
			System.out.println(-1);
			return;
		}

		for (int i = 1; i <= k; i++) {
			for (int j = 0; j < coins.size(); j++) {
				if (i + coins.get(j) <= k)
					dp[i + coins.get(j)] = Math.min(dp[i + coins.get(j)], dp[i] + 1);
			}
		}

		System.out.println(dp[k] == 1000000 ? -1 : dp[k]);
	}
}
