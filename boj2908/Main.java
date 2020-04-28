package boj2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");

		for (int i = 2; i >= 0; i--) {
			if (str[0].charAt(i) > str[1].charAt(i)) {
				for (int j = 2; j >= 0; j--) {
					System.out.print(str[0].charAt(j));
				}
				break;
			} else if (str[0].charAt(i) < str[1].charAt(i)) {
				for (int j = 2; j >= 0; j--) {
					System.out.print(str[1].charAt(j));
				}
				break;
			}
		}
	}
}