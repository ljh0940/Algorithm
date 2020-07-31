package boj2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;

	static ArrayList<Integer> arr[];
	static int array[];
	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new ArrayList[n + 1];
		array = new int[n + 1];
		StringBuilder sb = new StringBuilder();

		for (int i = 1; i <= n; i++)
			arr[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			arr[start].add(end);
			array[end]++;
		}

		for (int i = 1; i <= n; i++) {
			if (array[i] == 0) {
				q.offer(i);
				sb.append(i).append(" ");
			}
		}

		while (!q.isEmpty()) {
			int index = q.poll();

			for (int i = 0; i < arr[index].size(); i++) {
				int next = arr[index].get(i);
				array[next]--;

				if (array[next] == 0) {
					sb.append(next).append(" ");
					q.offer(next);
				}
			}
		}

		System.out.print(sb.toString());
	}
}