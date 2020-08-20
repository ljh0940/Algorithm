package boj1182;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int s;
	static int count = 0;
	static int checked;

	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		combination(0, n, 0);

		System.out.println(count);
	}

	static void combination(int index, int depth, int now) {
		if (depth == now) {
			return;
		}

		for (int i = index; i < n; i++) {
			if ((checked & 1 << i) != 0)
				continue;

			checked |= (1 << i);
			isS();
			combination(i + 1, depth, now + 1);
			checked ^= (1 << i);
		}
	}

	static void isS() {
		int checkSum = 0;
		boolean check = false;

		for (int i = 0; i < n; i++) {
			if ((checked & 1 << i) != 0) {
				checkSum += arr[i];
				check = true;
			}
		}

		if (check && checkSum == s)
			count++;
	}
}