package boj4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static final int N = 123456;
	static int[] primeNumberArray = new int[2 * N + 1];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		primeNumberArray[1] = 0;
		for (int i = 2; i <= 2 * N; i++) {
			eratostenes(i);
		}

		int count = 0;
		for (int i = 2; i <= 2 * N; i++) {
			if (primeNumberArray[i] == 0) {
				count++;
				primeNumberArray[i] = count;
			} else {
				primeNumberArray[i] = count;
			}
		}

		StringBuilder sb = new StringBuilder();

		while (true) {
			int n = Integer.parseInt(br.readLine());
			if (n == 0)
				break;

			count = primeNumberArray[2 * n] - primeNumberArray[n];
			sb.append(count).append("\n");
		}

		System.out.print(sb.toString());

	}

	static void eratostenes(int n) {
		int temp = n * 2;

		while (temp <= 2 * N) {
			primeNumberArray[temp] = -1;
			temp = temp + n;
		}
	}
}