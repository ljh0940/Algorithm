package boj5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int s = Integer.parseInt(br.readLine());
		String string = br.readLine();

		boolean flag = string.charAt(0) == 'I' ? true : false;
		int count = 0;
		int temp = 0;
		for (int i = 0; i < s; i++) {
			char c = string.charAt(i);
			if (c == 'I') {
				if (flag) {
					temp = 1;
				} else {
					temp++;
					if (temp == 2 * n + 1) {
						temp -= 2;
						count++;
					}
					flag = true;
				}
			} else {
				if (flag) {
					temp++;
				} else {
					temp = 0;
				}
				flag = false;
			}

		}

		System.out.println(count);
	}
}