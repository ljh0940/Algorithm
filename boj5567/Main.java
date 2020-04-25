package boj5567;

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

	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		arr = new ArrayList[n + 1];
		checked = new boolean[n + 1];

		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());

			arr[temp1].add(temp2);
			arr[temp2].add(temp1);
		}

		bfs();

		int count = 0;

		for (int i = 2; i <= n; i++) {
			if (checked[i] == true)
				count++;
		}

		System.out.println(count);

	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		checked[1] = true;

		int count = 0;
		while (!q.isEmpty()) {
			if (count == 2)
				break;

			int size = q.size();
			count++;
			for (int k = 0; k < size; k++) {
				int index = q.poll();
				for (int i = 0; i < arr[index].size(); i++) {
					int next = arr[index].get(i);
					if (checked[next] == true)
						continue;

					checked[next] = true;
					q.add(next);
				}
			}
		}

	}
}