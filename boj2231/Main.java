package boj2231;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String str = Integer.toString(n);

		if (n >= 1 && n <= 10) {
			System.out.println(0);
			return;
		}

		int temp = (str.charAt(0) - '0' - 1) * (int) Math.pow(10, str.length() - 1);

		for (int i = temp; i < n; i++) {
			if (i + calc(i) == n) {
				System.out.println(i);
				return;
			}
		}

		System.out.println(0);
	}

	static int calc(int n) {
		int sum = 0;
		while (n > 0) {
			sum = sum + n % 10;
			n = n / 10;
		}

		return sum;
	}
}