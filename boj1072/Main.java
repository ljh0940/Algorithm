package boj1072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");

		int total = Integer.parseInt(str[0]);
		int win = Integer.parseInt(str[1]);

		int percents = toPercents(total, win);

		if (percents >= 99) {
			System.out.println(-1);
			return;
		}

		int left = 0;
		int right = 1000000000;
		while (left <= right) {
			int mid = (left + right) / 2;
			int newPercents = toPercents(total + mid, win + mid);

			if (newPercents > percents) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}

		}

		System.out.println(left);
	}

	static int toPercents(int total, int win) {
		return (int) ((long) win * 100 / total);
	}
}