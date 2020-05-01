package boj1614;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		long max = Integer.parseInt(br.readLine());

		long count = n - 1;

		if (n == 1) {
			count = count + 8 * max;
		} else if (n == 2) {
			if (max % 2 == 0) {
				count = count + 8 * max / 2;
			} else {
				count = 7;
				if (max > 2) {
					count = count + 8 * (max / 2);
				}
			}
		} else if (n == 3) {
			count = count + 4 * max;
		} else if (n == 4) {
			if (max % 2 == 0) {
				count = count + 8 * max / 2;
			} else {
				count = 5;
				if (max > 2) {
					count = count + 8 * (max - 1) / 2;
				}
			}
		} else if (n == 5) {
			count = count + 8 * max;
		}

		System.out.println(count);

	}
}