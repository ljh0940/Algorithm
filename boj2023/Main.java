package boj2023;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

class Main {
	static HashSet<Integer> hashset;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		isAwesome(n, 0, 2);
		isAwesome(n, 0, 3);
		isAwesome(n, 0, 5);
		isAwesome(n, 0, 7);

		System.out.print(sb.toString());
	}

	static boolean isAwesome(int n, int count, int number) {
		for (int j = 1; j < 10; j++) {
			int newNumber = number * 10 + j;
			if (check(newNumber) == true)
				if (isAwesome(n, count + 1, newNumber) == false)
					return false;
		}

		if (n - 1 == count)
			sb.append(number).append("\n");

		return true;
	}

	static boolean check(int n) {
		if (n == 1)
			return false;

		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}

		return true;
	}
}
