package boj5622;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();
		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			count = count + change(str.charAt(i)) + 1;
		}

		System.out.println(count);

	}

	static int change(char c) {
		if (c == 'A' || c == 'B' || c == 'C') {
			return 2;
		} else if (c == 'D' || c == 'E' || c == 'F') {
			return 3;
		} else if (c == 'G' || c == 'H' || c == 'I') {
			return 4;
		} else if (c == 'J' || c == 'K' || c == 'L') {
			return 5;
		} else if (c == 'M' || c == 'N' || c == 'O') {
			return 6;
		} else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
			return 7;
		} else if (c == 'T' || c == 'U' || c == 'V') {
			return 8;
		} else
			return 9;
	}
}