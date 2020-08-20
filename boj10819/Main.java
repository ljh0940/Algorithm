package boj10819;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int max;

	static int arr[];
	static int order[];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		order = new int[n];
		checked = new boolean[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		combination(n, 0);

		System.out.println(max);
	}

	static void combination(int depth, int count) {
		if (depth == count) {
			calc();
			return;
		}

		for (int i = 0; i < n; i++) {
			if (checked[i])
				continue;

			checked[i] = true;
			order[i] = count;
			combination(depth, count + 1);
			checked[i] = false;
		}
	}

	static void calc() {
		int sum = 0;
		int temp = arr[order[0]];
		for (int i = 1; i < n; i++) {
			sum = sum + Math.abs(temp - arr[order[i]]);
			temp = arr[order[i]];
		}

		if (sum > max)
			max = sum;
	}
}