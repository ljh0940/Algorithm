package boj6118;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static ArrayList<Integer> arr[];
	static ArrayList<Integer> arr2;
	static boolean checked[];
	static int n;
	static int maxCount = 0;
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		checked = new boolean[n + 1];
		arr = new ArrayList[n + 1];
		arr2 = new ArrayList<Integer>();

		for (int i = 1; i < arr.length; i++) {
			arr[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int temp1 = Integer.parseInt(st.nextToken());
			int temp2 = Integer.parseInt(st.nextToken());

			arr[temp1].add(temp2);
			arr[temp2].add(temp1);
		}

		bfs();

		arr2.sort(null);

		System.out.println(arr2.get(0) + " " + (count - 1) + " " + arr2.size());
	}

	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(1);
		checked[1] = true;
		while (!q.isEmpty()) {
			int size = q.size();
			count++;
			for (int k = 0; k < size; k++) {
				int index = q.poll();
				boolean flag = true;

				for (int i = 0; i < arr[index].size(); i++) {
					int next = arr[index].get(i);

					if (checked[next] == true)
						continue;

					flag = false;
					checked[next] = true;
					q.add(next);
				}

				if (flag == true) {
					if (count > maxCount) {
						maxCount = count;
						arr2.clear();
					}
					arr2.add(index);
				}
			}
		}
	}
}