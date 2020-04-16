package boj9095;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static int arr[] = { 1, 2, 3 };
	static int n;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < t; i++) {
			n = Integer.parseInt(br.readLine());

			solve(0, 0);

			sb.append(count).append("\n");
			count = 0;
		}

		System.out.println(sb);
	}

	static void solve(int index, int sum) {
		if (sum == n) {
			count++;
			return;
		}
		if (sum > n)
			return;
		for (int i = 0; i < 3; i++) {
			sum = sum + arr[i];
			solve(i, sum);
			sum = sum - arr[i];
		}
	}
}