package boj17406;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Rotation {
	int r;
	int c;
	int s;

	Rotation(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

class Main {
	static int n;
	static int m;
	static int k;

	static int dx[] = { 0, 1, 0, -1, 1, 0, -1, 0 };
	static int dy[] = { 1, 0, -1, 0, 0, 1, 0, -1 };

	static int min = Integer.MAX_VALUE;

	static int matrix[][];

	static ArrayList<Rotation> arr;
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		matrix = new int[n][m];
		arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			arr.add(new Rotation(r - 1, c - 1, s));
		}
		checked = new boolean[arr.size()];

		combination(arr.size(), 0);

		System.out.println(min);
	}

	static void combination(int depth, int count) {
		if (depth == count) {
			count();
			return;
		}

		for (int i = 0; i < arr.size(); i++) {
			if (checked[i] == true)
				continue;

			checked[i] = true;

			rotationMatrix(arr.get(i));
			combination(depth, count + 1);
			reverseRotationMatrix(arr.get(i));

			checked[i] = false;
		}
	}

	static void reverseRotationMatrix(Rotation rotation) {
		int r = rotation.r;
		int c = rotation.c;
		int s = rotation.s;

		for (int i = 1; i <= s; i++) {
			int k = 4;
			int nx = r - i;
			int ny = c - i;

			int temp = matrix[nx][ny];
			int count = 0;
			while (true) {
				if (count == i * 2) {
					k++;
					count = 0;
					if (k == 8)
						break;
					continue;
				}
				int temp2 = matrix[nx + dx[k]][ny + dy[k]];

				matrix[nx + dx[k]][ny + dy[k]] = temp;
				temp = temp2;
				nx = nx + dx[k];
				ny = ny + dy[k];
				count++;
			}
		}
	}

	static void rotationMatrix(Rotation rotation) {
		int r = rotation.r;
		int c = rotation.c;
		int s = rotation.s;

		for (int i = 1; i <= s; i++) {
			int k = 0;
			int nx = r - i;
			int ny = c - i;

			int temp = matrix[nx][ny];
			int count = 0;
			while (true) {
				if (count == i * 2) {
					k++;
					count = 0;
					if (k == 4)
						break;
					continue;
				}
				int temp2 = matrix[nx + dx[k]][ny + dy[k]];

				matrix[nx + dx[k]][ny + dy[k]] = temp;
				temp = temp2;
				nx = nx + dx[k];
				ny = ny + dy[k];
				count++;
			}
		}
	}

	static void count() {
		for (int i = 0; i < n; i++) {
			int count = 0;
			for (int j = 0; j < m; j++) {
				count = count + matrix[i][j];
			}

			if (count < min)
				min = count;
		}
	}
}