package boj2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		int n = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);

		int houses[] = new int[n];
		for (int i = 0; i < n; i++) {
			houses[i] = Integer.parseInt(br.readLine());
		}

		Arrays.sort(houses);

		int left = 1;
		int right = houses[n - 1] - houses[0];
		int max = 0;

		while (left <= right) {
			int mid = (left + right) / 2;

			int sum = 1;
			int temp = houses[0];
			for (int i = 1; i < n; i++) {
				if (temp + mid <= houses[i]) {
					sum++;
					temp = houses[i];
				}
			}

			if (sum >= c) {
				if (max < mid)
					max = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		System.out.println(max);
	}
}