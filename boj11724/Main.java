package boj11724;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static ArrayList<Integer> arr[];
	static boolean checked[];
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		checked = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());

			arr[temp1].add(temp2);
			arr[temp2].add(temp1);
		}

		for (int i = 1; i <= n; i++) {
			if (dfs(i) == true)
				count++;
		}

		System.out.println(count);

	}

	static boolean dfs(int index) {
		if (checked[index] == true)
			return false;

		checked[index] = true;

		for (int i = 0; i < arr[index].size(); i++) {
			dfs(arr[index].get(i));
		}

		return true;

	}
}