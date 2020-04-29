package boj11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		int dp[] = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = 1;
		}

		int max = 1;
		for (int i = n - 1; i >= 0; i--) {
			if (i == n - 1) {
				dp[i] = 1;
			} else {
				for (int j = i; j < n - 1; j++) {
					if (arr[i] < arr[j + 1]) {
						dp[i] = Math.max(dp[i], dp[j + 1] + 1);
					}
				}
				if (max < dp[i])
					max = dp[i];
			}
		}

		System.out.println(max);

	}
}