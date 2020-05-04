package boj1475;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int count = 1;

		String str = br.readLine();
		int num[] = new int[10];
		Arrays.fill(num, 1);

		for (int i = 0; i < str.length(); i++) {
			int temp = str.charAt(i) - '0';

			if (num[temp] < 1) {
				if (temp == 6) {
					if (num[9] > 0) {
						num[9]--;
						continue;
					}
				} else if (temp == 9) {
					if (num[6] > 0) {
						num[6]--;
						continue;
					}
				}
				count++;
				for (int j = 0; j < 10; j++) {
					if (j == temp)
						continue;
					num[j]++;

				}
			} else {
				num[temp]--;
			}
		}

		System.out.println(count);
	}
}