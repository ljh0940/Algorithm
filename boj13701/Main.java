package boj13701;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean check[] = new boolean[33554434];

		String str[] = br.readLine().split(" ");
		for (int i = 0; i < str.length; i++) {
			int number = Integer.parseInt(str[i]);
			if (check[number] == false) {
				System.out.print(number + " ");
				check[number] = true;
			}
		}

	}
}
