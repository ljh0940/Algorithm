package boj9466;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int now;
	static int count = 0;
	static boolean flag = false;

	static int temp = 0;

	static int arr[];
	static int checked[];
	static boolean selected[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());

			arr = new int[n + 1];
			checked = new int[n + 1];
			selected = new boolean[n + 1];
			st = new StringTokenizer(br.readLine());

			for (int i = 1; i <= n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			count = 0;

			for (int i = 1; i <= n; i++) {
				now = i;
				flag = false;
				dfs(arr[i]);
				temp = 0;
			}

			System.out.println(n - count);

		}

	}

	static void dfs(int index) {
		if (selected[index] == true)
			return;

		checked[index]++;

		if (index == now) {
			selected[index] = true;
			count++;
			temp = index;
			checked[index]--;
			return;
		}

		if (checked[index] > 1) {
			selected[index] = true;
			count++;
			temp = index;
			checked[index]--;
			return;
		}

		dfs(arr[index]);

		if (temp != 0) {
			if (index != temp) {
				count++;
			} else {
				temp = 0;
			}
		}
		selected[index] = true;
		checked[index]--;
	}
}