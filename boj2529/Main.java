package boj2529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static String minString = "9999999999";
	static String maxString = "0000000000";
	static char brakets[];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		brakets = new char[n];
		checked = new boolean[10];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++)
			brakets[i] = st.nextToken().charAt(0);

		for (int i = 0; i < 10; i++) {
			checked[i] = true;
			combination(10, n, 0, Integer.toString(i));
			checked[i] = false;
		}

		System.out.println(maxString);
		System.out.println(minString);
	}

	static void combination(int index, int depth, int count, String str) {
		if (depth == count) {
			if (str.compareTo(maxString) > 0)
				maxString = str;

			if (str.compareTo(minString) < 0)
				minString = str;

			return;
		}

		for (int i = 0; i < 10; i++) {
			if (i == index)
				continue;

			if (checked[i])
				continue;

			if (check(str.charAt(str.length() - 1) - '0', i, count)) {
				checked[i] = true;
				combination(i, depth, count + 1, str + i);
				checked[i] = false;
			}
		}
	}

	static boolean check(int now, int next, int index) {
		char braket = brakets[index];

		if (braket == '<')
			return now < next;
		else
			return now > next;
	}
}