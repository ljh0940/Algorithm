package boj1806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());

		int arr[] = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int length = Integer.MAX_VALUE;
		int end = 0;
		int sum = 0;
		for (int start = 0; start < n; start++) {
			sum = sum + arr[start];

			if (sum == s) {
				length = Math.min(length, start - end + 1);
			}

			if (sum > s) {
				while (sum > s) {
					sum = sum - arr[end];
					end++;
				}

				if (sum == s)
					length = Math.min(length, start - end + 1);
				else
					length = Math.min(length, start - end + 2);
			}
		}

		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}
}