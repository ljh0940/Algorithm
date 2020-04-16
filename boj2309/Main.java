package boj2309;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	static int arr[];
	static boolean check[];
	static boolean flag = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		arr = new int[9];
		check = new boolean[9];

		for (int i = 0; i < 9; i++)
			arr[i] = Integer.parseInt(br.readLine());

		Arrays.sort(arr);

		dfs(0, 0);
	}

	static void dfs(int index, int depth) {
		if (flag == false)
			return;

		if (depth == 7) {
			int sum = 0;
			for (int i = 0; i < 9; i++) {
				if (check[i] == true)
					sum = sum + arr[i];

				if (sum > 100)
					return;
			}

			if (sum == 100) {
				for (int i = 0; i < 9; i++) {
					if (check[i] == true)
						System.out.println(arr[i]);
				}
				flag = false;

			}

		}

		for (int i = index; i < 9; i++) {
			if (check[i] == true)
				continue;

			check[i] = true;
			dfs(i, depth + 1);
			check[i] = false;
		}
	}
}