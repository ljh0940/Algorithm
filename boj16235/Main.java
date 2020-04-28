package boj16235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Tree {
	int x;
	int y;
	int age;
	boolean alive;

	Tree(int x, int y, int age) {
		this.x = x;
		this.y = y;
		this.age = age;
		this.alive = true;
	}
}

class Main {
	static int map[][];
	static int S2D2[][];

	static int n;
	static int m;
	static int k;

	static int dx[] = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 0:ºÏ¼­ 1:ºÏ 2:ºÏµ¿ 3:µ¿ 4:³²µ¿ 5:³² 6:³²¼­ 7:¼­
	static int dy[] = { -1, 0, 1, 1, 1, 0, -1, -1 };

//	static LinkedList<Tree> trees;
	static Deque<Tree> trees;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		S2D2 = new int[n][n];
		trees = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = 5;
				S2D2[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x = 0;
		int y = 0;
		int age = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken()) - 1;
			y = Integer.parseInt(st.nextToken()) - 1;
			age = Integer.parseInt(st.nextToken());
			trees.add(new Tree(x, y, age));
		}

		for (int i = 0; i < k; i++) {
			spring();
			summer();
			if (trees.size() == 0)
				break;
			fall();
			winter();
		}

		System.out.println(trees.size());

	}

	static void spring() {
		Iterator<Tree> iter = trees.iterator();
		while (iter.hasNext()) {
			Tree tree = iter.next();

			if (tree.age <= map[tree.x][tree.y]) {
				map[tree.x][tree.y] = map[tree.x][tree.y] - tree.age;
				tree.age++;
			} else {
				tree.alive = false;
			}
		}
	}

	static void summer() {
		Iterator<Tree> iter = trees.iterator();

		while (iter.hasNext()) {

			Tree tree = iter.next();
			if (tree.alive == false) {
				map[tree.x][tree.y] = map[tree.x][tree.y] + (tree.age / 2);
				iter.remove();
			}
		}
	}

	static void fall() {
		Deque<Tree> temp = new LinkedList<>();
		int size = trees.size();
		for (int i = 0; i < size; i++) {
			Tree tree = trees.poll();

			if (tree.age % 5 == 0) {
				// 0:ºÏ¼­ 1:ºÏ 2:ºÏµ¿ 3:µ¿ 4:³²µ¿ 5:³² 6:³²¼­ 7:¼­
				for (int j = 0; j < 8; j++) {
					int nx = tree.x + dx[j];
					int ny = tree.y + dy[j];

					if (nx < 0 || nx >= n || ny < 0 || ny >= n)
						continue;

					temp.addFirst(new Tree(nx, ny, 1));
				}
			}

			temp.add(tree);
		}

		trees = temp;
	}

	static void winter() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				map[i][j] = map[i][j] + S2D2[i][j];
			}
		}
	}
}