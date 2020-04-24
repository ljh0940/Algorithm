package boj1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int min;
	static int max;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");

		min = Integer.parseInt(str[0]);
		max = Integer.parseInt(str[1]);

		for (int i = exp(min); i <= exp(max); i++) {
			combination(0, i, "");
		}

		System.out.println(count);
	}

	static void combination(int depth, int exp, String num) {
		if (depth == exp) {
			try {
				if (Integer.parseInt(num) <= max && Integer.parseInt(num) >= min)
					count++;
			} catch (Exception e) {
			}

			return;
		}

		for (int i = 0; i < 2; i++) {
			if (i == 0) {
				num = num + 4;
			}
			if (i == 1) {
				num = num + 7;
			}
			combination(depth + 1, exp, num);
			num = num.substring(0, num.length() - 1);
		}
	}

	static int exp(int n) {
		int count = 0;
		while (n > 0) {
			n = n / 10;
			count++;
		}

		return count;
	}

}