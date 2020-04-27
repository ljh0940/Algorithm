package boj6603;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	static int n;

	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static boolean checked[];

	static HashMap<Integer, Integer> hash = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		while (true) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			if (n == 0) {
				break;
			}
			arr = new int[n];
			checked = new boolean[n];

			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			combination(0, 0);

			sb.append("\n");
		}

		System.out.print(sb);

	}

	static void combination(int index, int depth) {
		if (depth == 6) {
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (checked[i] == true) {
					count++;
					if (count == 6)
						sb.append(arr[i]);
					else
						sb.append(arr[i]).append(" ");
				}
			}
			sb.append("\n");
			return;
		}

		for (int i = index; i < arr.length; i++) {
			if (checked[i] == true)
				continue;
			checked[i] = true;
			combination(i + 1, depth + 1);
			checked[i] = false;

		}
	}
}