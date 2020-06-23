package boj10159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int n;
	static ArrayList<Integer> heavyArray[];
	static ArrayList<Integer> lightArray[];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		heavyArray = new ArrayList[n + 1];
		lightArray = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			heavyArray[i] = new ArrayList<>();
			lightArray[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int heavy = Integer.parseInt(st.nextToken());
			int light = Integer.parseInt(st.nextToken());

			heavyArray[light].add(heavy);
			lightArray[heavy].add(light);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			checked = new boolean[n + 1];
			int heavy = heavyDfs(i);
			checked = new boolean[n + 1];
			int light = lightDfs(i);
			sb.append(n - 1 - heavy - light).append("\n");
		}

		System.out.print(sb.toString());

	}

	static int heavyDfs(int index) {
		int count = 0;
		for (int i = 0; i < heavyArray[index].size(); i++) {
			int next = heavyArray[index].get(i);

			if (checked[next] == true)
				continue;

			checked[next] = true;
			count = count + heavyDfs(next) + 1;
		}

		return count;
	}

	static int lightDfs(int index) {
		int count = 0;

		for (int i = 0; i < lightArray[index].size(); i++) {
			int next = lightArray[index].get(i);

			if (checked[next] == true)
				continue;

			checked[next] = true;
			count = count + lightDfs(next) + 1;
		}

		return count;
	}
}