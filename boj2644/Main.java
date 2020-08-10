package boj2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n;

	static ArrayList<Integer> arr[];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		checked = new boolean[n + 1];

		for (int i = 1; i <= n; i++)
			arr[i] = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		int target = Integer.parseInt(st.nextToken());
		int goal = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int m = Integer.parseInt(st.nextToken());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start].add(end);
			arr[end].add(start);
		}

		System.out.println(bfs(target, goal));
	}

	static int bfs(int target, int goal) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(target);
		checked[target] = true;

		int count = 0;

		while (!q.isEmpty()) {
			int size = q.size();
			count++;

			for (int k = 0; k < size; k++) {
				int index = q.poll();

				for (int i = 0; i < arr[index].size(); i++) {
					int next = arr[index].get(i);

					if (checked[next])
						continue;

					if (next == goal) {
						return count;
					}

					checked[next] = true;
					q.offer(next);
				}
			}
		}

		return -1;
	}
}