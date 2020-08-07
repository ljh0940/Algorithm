package boj1062;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int n;
	static int k;
	static int max;

	static int alpha[];
	static int alphaCheck;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String string[] = br.readLine().split(" ");
		n = Integer.parseInt(string[0]);
		k = Integer.parseInt(string[1]) - 5;

		alpha = new int[n];

		for (int i = 0; i < n; i++) {
			String word = br.readLine();
			for (int j = 0; j < word.length(); j++) {
				char alphabat = word.charAt(j);
				alpha[i] = alpha[i] | (1 << (alphabat - 'a'));
			}
		}

		if (k < 0) {
			System.out.println(0);
			return;
		}

		alphaCheck |= (1 << 0); // a
		alphaCheck |= (1 << 13); // n
		alphaCheck |= (1 << 19); // t
		alphaCheck |= (1 << 8); // i
		alphaCheck |= (1 << 2); // c

		max = check();

		combination(0, k, 0);

		System.out.println(max);
	}

	static void combination(int index, int depth, int count) {
		if (depth == count) {
			max = Math.max(max, check());
			return;
		}

		for (int i = index; i < 26; i++) {
			if ((alphaCheck & (1 << i)) == (1 << i))
				continue;

			int temp = alphaCheck;
			alphaCheck |= (1 << i);
			combination(i + 1, depth, count + 1);
			alphaCheck = temp;
		}
	}

	static int check() {
		int result = 0;
		for (int i = 0; i < n; i++) {
			if ((alpha[i] & alphaCheck) == alpha[i]) {
				result++;
			}
		}

		return result;
	}
}