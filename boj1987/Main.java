package boj1987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 처음 시도한 방법
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int max;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static char map[][];
	static boolean checked[][];
	static ArrayList<Character> al;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		checked = new boolean[n][m];
		al = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		solve(0, 0, 0);

		System.out.println(max);
	}

	static void solve(int xx, int yy, int sum) {
		checked[xx][yy] = true;

		sum++;
		al.add(map[xx][yy]);

		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (checked[nx][ny] == true)
				continue;

			boolean flag = false;

			for (int j = 0; j < al.size(); j++) {
				if (al.get(j) == map[nx][ny]) {
					flag = true;
					break;
				}
			}

			if (flag == true)
				continue;

			solve(nx, ny, sum);
			checked[nx][ny] = false;
			al.remove(al.size() - 1);
		}

		max = Math.max(max, sum);
	}
}
 */

/* 두 번째 시도한 방법
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int max;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static char map[][];
	static boolean checked[][];
	static HashMap<Character, Integer> hash;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new char[n][m];
		checked = new boolean[n][m];
		hash = new HashMap<>();

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		solve(0, 0, 0);

		System.out.println(max);
	}

	static void solve(int xx, int yy, int sum) {
		checked[xx][yy] = true;

		sum++;
		hash.put(map[xx][yy], 1);

		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (checked[nx][ny] == true)
				continue;

			if (hash.containsKey(map[nx][ny]) == true)
				continue;

			solve(nx, ny, sum);
			checked[nx][ny] = false;
			hash.remove(map[nx][ny]);
		}

		max = Math.max(max, sum);
	}
}
 */

// 사람들 방법
class Main {
	static int n;
	static int m;
	static int max;

	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	static int map[][];
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][m];
		checked = new boolean[26];

		for (int i = 0; i < n; i++) {
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j) - 'A';
			}
		}

		solve(0, 0, 0);

		System.out.println(max);
	}

	static void solve(int xx, int yy, int sum) {
		checked[map[xx][yy]] = true;

		sum++;

		for (int i = 0; i < 4; i++) {
			int nx = xx + dx[i];
			int ny = yy + dy[i];

			if (nx < 0 || nx >= n || ny < 0 || ny >= m)
				continue;
			if (checked[map[nx][ny]] == true)
				continue;

			solve(nx, ny, sum);
			checked[map[nx][ny]] = false;
		}

		max = Math.max(max, sum);
	}
}