package boj1389;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int user;
	static int min = Integer.MAX_VALUE;

	static ArrayList<Integer> arr[];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		checked = new boolean[n + 1];

		for (int i = 1; i <= n; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());

			arr[temp1].add(temp2);
			arr[temp2].add(temp1);
		}

		for (int i = 1; i <= n; i++) {
			int kevinNum = 0;
			for (int j = 1; j <= n; j++) {
				if (i == j)
					continue;
				Arrays.fill(checked, false);
				kevinNum = kevinNum + bfs(i, j);
			}
			if (kevinNum < min) {
				min = kevinNum;
				user = i;
			}
		}

		System.out.println(user);

	}

	static int bfs(int index, int goal) {
		Queue<Integer> q = new LinkedList<Integer>();
		checked[index] = true;
		q.add(index);

		int count = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			for (int k = 0; k < size; k++) {
				index = q.poll();
				for (int i = 0; i < arr[index].size(); i++) {
					int next = arr[index].get(i);

					if (checked[next] == true)
						continue;

					if (goal == next)
						return count;

					checked[next] = true;
					q.add(next);
				}
			}
		}

		return count;
	}
}