package boj3933;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int count = 0;
	static int max = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		while (true) {
			count = 0;
			int n = Integer.parseInt(br.readLine());

			if (n == 0)
				break;

			max = (int) Math.sqrt(n);

			int sum = 0;
			for (int i = 0; i < max; i++) {
				int pow1 = (i + 1) * (i + 1);
				sum = sum + pow1;
				if (sum == n) {
					count++;
					break;
				}
				if (sum > n)
					break;

				for (int j = i; j < max; j++) {
					int pow2 = (j + 1) * (j + 1);
					sum = sum + pow2;
					if (sum == n) {
						sum = sum - pow2;
						count++;
						break;
					}
					if (sum > n) {
						sum = sum - pow2;
						break;
					}

					for (int k = j; k < max; k++) {
						int pow3 = (k + 1) * (k + 1);
						sum = sum + pow3;
						if (sum == n) {
							sum = sum - pow3;
							count++;
							break;
						}
						if (sum > n) {
							sum = sum - pow3;
							break;
						}

						for (int l = k; l < max; l++) {
							int pow4 = (l + 1) * (l + 1);
							sum = sum + pow4;
							if (sum == n) {
								sum = sum - pow4;
								count++;
								break;
							}
							if (sum > n) {
								sum = sum - pow4;
								break;
							}
							sum = sum - pow4;
						}

						sum = sum - pow3;
					}
					sum = sum - pow2;
				}
				sum = sum - pow1;
			}

			sb.append(count).append("\n");
		}

		System.out.print(sb.toString());
	}
}