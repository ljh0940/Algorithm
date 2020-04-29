package boj17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int sum = 0;
	static int min = Integer.MAX_VALUE;

	static ArrayList<Integer> arr[];
	static int population[];
	static boolean checked[];
	static boolean selected[];

	static Queue<Integer> q = new LinkedList<Integer>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n + 1];
		population = new int[n + 1];
		checked = new boolean[n + 1];
		selected = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			arr[i] = new ArrayList<>();
		}

		st = new StringTokenizer(br.readLine());

		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
			sum = sum + population[i];
		}

		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			if (k == 0)
				continue;

			for (int j = 0; j < k; j++) {
				int temp = Integer.parseInt(st.nextToken());
				arr[i].add(temp);
			}
		}

		for (int i = 1; i <= n / 2; i++) {
			combinaion(1, 0, i);
		}

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

	static void combinaion(int index, int depth, int goal) {
		if (depth == goal) {
			Arrays.fill(checked, false);
			bfs(index);
			return;
		}

		for (int i = index; i <= n; i++) {
			if (selected[i] == true)
				continue;
			selected[i] = true;
			combinaion(i, depth + 1, goal);
			selected[i] = false;
		}
	}

	static boolean isOkay() {
		for (int i = 1; i <= n; i++) {
			if (checked[i] == false)
				return false;
		}
		return true;
	}

	static void bfs(int index) {
		q.add(index);
		checked[index] = true;

		int count = population[index];
		while (!q.isEmpty()) {
			int newIndex = q.poll();

			Iterator<Integer> iter = arr[newIndex].iterator();
			while (iter.hasNext()) {
				int next = iter.next();

				if (checked[next] == true)
					continue;

				if (selected[next] == false)
					continue;

				count = count + population[next];
				checked[next] = true;
				q.add(next);
			}
		}

		for (int i = 1; i <= n; i++) {
			if (selected[i] == false) {
				index = i;
				break;
			}
		}

		q.add(index);
		checked[index] = true;

		while (!q.isEmpty()) {
			int newIndex = q.poll();

			Iterator<Integer> iter = arr[newIndex].iterator();
			while (iter.hasNext()) {
				int next = iter.next();

				if (checked[next] == true)
					continue;

				if (selected[next] == true)
					continue;

				checked[next] = true;
				q.add(next);
			}
		}

		if (isOkay() == false) {
			return;
		} else {
			int temp = Math.abs(sum - 2 * count);
			if (temp < min)
				min = temp;
		}
	}
}