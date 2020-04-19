package boj2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int max = 0;

	static int arr[];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];
		checked = new boolean[n];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		solve(0, 0);

		System.out.println(max);
	}

	static void solve(int index, int depth) {
		if (depth == 3) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if (checked[i] == true) {
					sum = sum + arr[i];
				}

				if (sum > m)
					return;
			}

			if (max < sum) {
				max = sum;
			}

			return;

		}

		for (int i = index; i < n; i++) {
			checked[i] = true;
			solve(i + 1, depth + 1);
			checked[i] = false;
		}

	}
}