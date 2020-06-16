package boj2458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n;

	static boolean checked[];

	static ArrayList<Integer> tallArr[];
	static ArrayList<Integer> smallArr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		tallArr = new ArrayList[n + 1];
		smallArr = new ArrayList[n + 1];
		checked = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			tallArr[i] = new ArrayList<>();
			smallArr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int small = Integer.parseInt(st.nextToken());
			int tall = Integer.parseInt(st.nextToken());

			tallArr[small].add(tall);
			smallArr[tall].add(small);
		}

		int count = 0;
		for (int i = 1; i <= n; i++) {
			int smaller = smallDfs(i);
			Arrays.fill(checked, false);
			int taller = tallDfs(i);
			Arrays.fill(checked, false);

			if (smaller + taller == n - 1)
				count++;
		}

		System.out.println(count);

	}

	static int smallDfs(int index) {
		int count = 0;
		checked[index] = true;

		for (int i = 0; i < smallArr[index].size(); i++) {
			int next = smallArr[index].get(i);

			if (checked[next] == true)
				continue;

			count = count + smallDfs(next) + 1;
		}

		return count;
	}

	static int tallDfs(int index) {
		int count = 0;
		checked[index] = true;

		for (int i = 0; i < tallArr[index].size(); i++) {
			int next = tallArr[index].get(i);

			if (checked[next] == true)
				continue;

			count = count + tallDfs(next) + 1;
		}

		return count;
	}
}