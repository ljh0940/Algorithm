package boj1107;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int length;
	static int min = Integer.MAX_VALUE;

	static boolean disorder[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		length = Integer.toString(n).length();
		disorder = new boolean[10];

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		if (m != 0)
			st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int number = Integer.parseInt(st.nextToken());
			disorder[number] = true;
		}

		min = Math.abs(100 - n);

		makeNumber(length + 1, 0, 0);

		System.out.println(min);

	}

	static void makeNumber(int depth, int count, int number) {
		if (depth == count) {
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (disorder[i])
				continue;

			int newNumber = number + i * (int) Math.pow(10, count);
			calc(newNumber);
			makeNumber(depth, count + 1, newNumber);
		}
	}

	static void calc(int number) {
		int count = Math.abs(number - n) + Integer.toString(number).length();

		if (count < min)
			min = count;
	}
}