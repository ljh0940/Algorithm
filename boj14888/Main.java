package boj14888;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int min = Integer.MAX_VALUE;
	static int max = -Integer.MAX_VALUE;

	static int arr[];
	static int operators[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		operators = new int[4];

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operators[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, arr[0]);

		System.out.println(max);
		System.out.println(min);
	}

	static void solve(int index, int sum) {
		if (index == n - 1) {
			if (max < sum)
				max = sum;

			if (min > sum)
				min = sum;

			return;
		}

		for (int i = 0; i < 4; i++) {
			if (operators[i] <= 0)
				continue;
			operators[i]--;
			solve(index + 1, calc(sum, arr[index + 1], i));
			operators[i]++;
		}
	}

	static int calc(int num1, int num2, int oper) {
		int result = 0;
		if (oper == 0) {
			result = num1 + num2;
		}
		if (oper == 1) {
			result = num1 - num2;
		}
		if (oper == 2) {
			result = num1 * num2;
		}
		if (oper == 3) {
			result = num1 / num2;
		}

		return result;
	}
}