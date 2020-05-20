package boj1058;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Main {
	static int n;
	static int count = 0;
	static int max = 0;

	static int arr[][];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		n = Integer.parseInt(br.readLine());

		arr = new int[n][n];
		checked = new boolean[n];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < n; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			count = 0;
			Arrays.fill(checked, false);
			solve(i);
			if (count > max)
				max = count;
		}

		System.out.println(max);
	}

	static void solve(int index) {
		Queue<Integer> q = new LinkedList<>();
		q.add(index);
		checked[index] = true;

		boolean flag = true;

		while (!q.isEmpty()) {
			index = q.poll();
			for (int i = 0; i < n; i++) {
				if (arr[index][i] == 'N')
					continue;

				if (flag == true) {
					count++;
					checked[i] = true;
					q.add(i);
				} else {
					if (checked[i] == true)
						continue;
					count++;
					checked[i] = true;
				}

			}
			flag = false;
		}
	}
}