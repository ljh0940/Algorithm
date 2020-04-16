package boj9613;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static ArrayList<Integer> arr = new ArrayList<>();
	static boolean checked[];
	static ArrayList<Integer> compare = new ArrayList<>();

	static long sum;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			arr.clear();
			checked = new boolean[n];
			sum = 0;

			for (int i = 0; i < n; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}

			solve(0, 0);
			sb.append(sum).append("\n");
		}

		System.out.println(sb);
	}

	static int gcd() {
		int n = compare.get(0);
		int m = compare.get(1);

		if (n < m) {
			int temp = n;
			n = m;
			m = temp;
		}

		if (n > m) {
			for (int i = m; i > 0; i--) {
				if (m % i == 0 && n % i == 0) {
					return i;
				}
			}
		}

		return n;
	}

	static void solve(int index, int depth) {
		if (depth == 2) {
			compare.clear();
			for (int i = 0; i < arr.size(); i++) {
				if (checked[i] == true) {
					compare.add(arr.get(i));
				}
			}

			sum = sum + gcd();
			return;
		}

		for (int i = index; i < arr.size(); i++) {
			if (checked[i] == true)
				continue;

			checked[i] = true;
			solve(i, depth + 1);
			checked[i] = false;
		}
	}
}