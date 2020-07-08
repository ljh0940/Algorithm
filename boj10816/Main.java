package boj10816;

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

		st = new StringTokenizer(br.readLine());

		HashMap<Integer, Integer> hash = new HashMap<>();

		for (int i = 0; i < n; i++) {
			int number = Integer.parseInt(st.nextToken());
			if (hash.containsKey(number))
				hash.put(number, hash.get(number) + 1);
			else
				hash.put(number, 1);
		}

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken());
			sb.append(hash.get(target) == null ? 0 : hash.get(target)).append(" ");
		}

		System.out.println(sb.toString());

	}
}