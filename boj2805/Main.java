package boj2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static long max = 0;

	static int trees[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		trees = new int[n];

		int top = 0;
		int bottom = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			trees[i] = Integer.parseInt(st.nextToken());

			if (trees[i] > top)
				top = trees[i];
		}

		int mid = 0;

		while (true) {
			if (top < bottom)
				break;
			long count = 0;
			mid = (top + bottom) / 2;
			count = cut(mid);

			if (count >= m) {
				if (mid > max)
					max = mid;
				bottom = mid + 1;
			} else {
				top = mid - 1;
			}
		}

		System.out.println(max);
	}

	static long cut(int height) {
		long sum = 0;
		for (int i = 0; i < trees.length; i++) {
			if (trees[i] > height)
				sum = sum + trees[i] - height;
		}

		return sum;
	}
}