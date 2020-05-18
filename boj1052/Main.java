package boj1052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n;
	static int k;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		k = Integer.parseInt(str[1]);

		while (calc(n + count) > k) {
			count++;
		}

		System.out.println(count);

	}

	static int calc(int n) {
		int cnt = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1')
				cnt++;
		}

		return cnt;
	}
}