package boj2343;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int left = 1;
		int right = 0;
		int max = 0;

		int lessons[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			lessons[i] = Integer.parseInt(st.nextToken());
			right = right + lessons[i];
			if (max < lessons[i])
				max = lessons[i];
		}

		max = right;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (check(mid, m, lessons) == false) {
				left = mid + 1;
			} else {
				if (max > mid)
					max = mid;
				right = mid - 1;
			}
		}

		System.out.println(max);
	}

	static boolean check(int value, int target, int[] lessons) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < lessons.length; i++) {
			if (value < lessons[i])
				return false;

			if (sum + lessons[i] > value) {
				count++;
				sum = 0;
			}
			sum = sum + lessons[i];
		}

		if (sum > 0)
			count++;

		if (count > target) {
			return false;
		} else {
			return true;
		}
	}
}