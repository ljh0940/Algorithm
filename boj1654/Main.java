package boj1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		int k = Integer.parseInt(str[0]);
		int n = Integer.parseInt(str[1]);

		int cables[] = new int[k];
		for (int i = 0; i < k; i++) {
			cables[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(cables);

		long left = 1;
		long right = cables[k - 1];
		long max = 0;

		while (left <= right) {
			long div = 0;
			long sum = left + right;
			long mid = sum / 2;

			for (int i = 0; i < k; i++) {
				long quantity = cables[i] / mid;
				div = div + quantity;
			}

			if (div < n) {
				right = mid - 1;
			} else {
				if (max < mid)
					max = mid;
				left = mid + 1;
			}

		}

		System.out.println(max);
	}
}