package boj1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int arr[] = new int[26];

		String str = br.readLine().toUpperCase();

		for (int i = 0; i < str.length(); i++) {
			arr[str.charAt(i) - 65]++;
		}

		char c = '?';
		int max = 0;
		for (int i = 0; i < 26; i++) {
			if (arr[i] > max) {
				max = arr[i];
				c = (char) (i + 65);
			} else if (arr[i] == max) {
				c = '?';
			}
		}

		System.out.println(c);

	}
}