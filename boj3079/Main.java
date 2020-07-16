package boj3079;

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

		int places[] = new int[n];
		for (int i = 0; i < n; i++) {
			places[i] = Integer.parseInt(br.readLine());
		}

//		Arrays.sort(places);

		long left = places[0];
		long right = places[n - 1] * (long) m;
		long min = Long.MAX_VALUE;

		while (left <= right) {
			long mid = (left + right) / 2;

			long sum = 0;
			for (int i = 0; i < n; i++) {
				sum = sum + mid / places[i];
			}

			if (sum >= m) {
				if (min > mid)
					min = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		System.out.println(min);
	}
}