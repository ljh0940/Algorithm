package boj9375;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		StringBuilder sb = new StringBuilder();
		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());
			HashMap<String, Integer> hash = new HashMap<>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				String cloth = st.nextToken();
				String kinds = st.nextToken();

				if (hash.containsKey(kinds))
					hash.put(kinds, hash.get(kinds) + 1);
				else
					hash.put(kinds, 1);
			}
			int count = 1;
			Iterator<String> iter = hash.keySet().iterator();
			while (iter.hasNext()) {
				String key = iter.next();
				count = count * (hash.get(key) + 1);
			}

			sb.append(count - 1).append("\n");
		}

		System.out.print(sb.toString());
	}
}