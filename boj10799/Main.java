package boj10799;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str = br.readLine();

		int sum = 0;
		int count = 0;

		for (int i = 0; i < str.length() - 1; i++) {
			char c = str.charAt(i);
			if (c == '(') {
				if (str.charAt(i + 1) == ')') {
					sum = sum + count;
					i++;
				} else {
					count++;
				}
			} else if (c == ')' && count != 0) {
				count--;
				sum++;
			}
		}

		System.out.println(sum + 1);
	}
}