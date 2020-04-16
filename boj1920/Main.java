package boj1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		HashMap<Integer, Boolean> hash = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			hash.put(temp, true);
		}

		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int temp = Integer.parseInt(st.nextToken());

			if (hash.containsKey(temp) == true) {
				sb.append(1).append("\n");
			} else {
				sb.append(0).append("\n");
			}
		}

		System.out.print(sb);
	}
}