package boj17472;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Island {
	int number;
	int arr[];

	Island(int number, int n) {
		this.number = number;
		this.arr = new int[n];
		Arrays.fill(arr, Integer.MAX_VALUE);
	}
}

class Bridge {
	int bridge;
	int length;

	Bridge(int bridge, int length) {
		this.bridge = bridge;
		this.length = length;
	}
}

class Main {
	static int n;
	static int m;
	static int islandNumber = 1;
	static int min = Integer.MAX_VALUE;

	static int dx[] = { 1, 0, -1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	static int map[][];
	static boolean checked[][];
	static boolean checked2[];

	static HashSet<Integer> arr2[];

	static ArrayList<Island> arr = new ArrayList<>();
	static PriorityQueue<Bridge> pq;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		checked = new boolean[n][m];
		arr = new ArrayList<>();
		arr.add(null);

		pq = new PriorityQueue<>(new Comparator<Bridge>() {
			@Override
			public int compare(Bridge o1, Bridge o2) {
				if (o1.length > o2.length)
					return 1;
				else
					return -1;
			}
		});

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (checked[i][j] == false && map[i][j] == 1) {
					numberingIsland(i, j);
					islandNumber++;
				}
			}
		}

		checked2 = new boolean[islandNumber];
		arr2 = new HashSet[islandNumber];
		for (int i = 1; i < islandNumber; i++) {
			arr.add(new Island(i + 1, 7));
			arr2[i] = new HashSet<Integer>();
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (isEdge(i, j) == true)
					makebridge(i, j);
			}
		}

		checked2[1] = true;
		dfs(1, 0, 1);

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);

	}

	static void dfs(int index, int count, int depth) {
		if (depth == islandNumber - 1) {
			if (min > count)
				min = count;
			return;
		}

		Iterator<Integer> iter = arr2[index].iterator();
		while (iter.hasNext()) {
			int next = iter.next();

			if (checked2[next] == true)
				continue;

			pq.add(new Bridge(next, arr.get(index).arr[next]));
		}

		Bridge b;
		while (true) {
			if (pq.isEmpty())
				return;

			b = pq.poll();
			if (checked2[b.bridge] == false)
				break;
		}
		checked2[b.bridge] = true;
		dfs(b.bridge, count + b.length, depth + 1);
	}

	static void makebridge(int x, int y) {
		int start = map[x][y];

		for (int i = 0; i < 4; i++) {
			int count = 0;
			int nx = x;
			int ny = y;
			while (true) {
				nx = nx + dx[i];
				ny = ny + dy[i];
				count++;

				if (nx < 0 || nx >= n || ny < 0 || ny >= m)
					break;

				if (map[nx][ny] == start)
					break;

				if (map[nx][ny] != 0) {
					if (count > 2) {
						int temp = arr.get(start).arr[map[nx][ny]];
						if (temp > count - 1) {
							arr.get(start).arr[map[nx][ny]] = count - 1;
							arr2[start].add(map[nx][ny]);
						}
					}
					break;
				}
			}
		}
	}

	static boolean isEdge(int x, int y) {
		if (checked[x][y] == false)
			return false;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (map[nx][ny] == 0)
				return true;
		}

		return false;
	}

	static void numberingIsland(int x, int y) {
		checked[x][y] = true;
		map[x][y] = islandNumber;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;

			if (checked[nx][ny] == true)
				continue;

			if (map[nx][ny] == 0)
				continue;

			numberingIsland(nx, ny);
		}
	}
}