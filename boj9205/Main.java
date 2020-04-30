package boj9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int length;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Pos(int x, int y, int length) {
		this.x = x;
		this.y = y;
		this.length = length;
	}
}

class Main {
	static ArrayList<Pos> store;
	static boolean checked[];

	static Pos me = null;
	static Pos goal = null;

	static Queue<Pos> q = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		for (int k = 0; k < t; k++) {
			int n = Integer.parseInt(br.readLine());

			int x = 0;
			int y = 0;

			store = new ArrayList<>();
			checked = new boolean[n];
			q.clear();

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());

			me = new Pos(x, y);
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				store.add(new Pos(x, y, calc(me.x, me.y, x, y)));
			}

			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			goal = new Pos(x, y, calc(me.x, me.y, x, y));
			
			if(isOk(me.x, me.y, goal.x, goal.y) == true) {
				System.out.println("happy");
				continue;
			}

			Comparator<Pos> com = new Comparator<Pos>() {

				@Override
				public int compare(Pos o1, Pos o2) {
					if (o1.length > o2.length)
						return 1;
					else
						return -1;
				}
			};

			store.sort(com);

			System.out.println(bfs() ? "happy" : "sad");
		}
	}

	static boolean bfs() {
		q.add(me);

		while (!q.isEmpty()) {
			Pos p = q.poll();

			int size = store.size();

			for (int i = 0; i < size; i++) {
				Pos next = store.get(i);

				if (isOk(p.x, p.y, goal.x, goal.y) == true)
					return true;

				if (checked[i] == true)
					continue;

				if (isOk(p.x, p.y, next.x, next.y) == false)
					continue;

				checked[i] = true;
				q.add(next);
			}
		}

		return false;
	}

	static int calc(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}

	static boolean isOk(int x1, int y1, int x2, int y2) {
		int temp = Math.abs(x1 - x2) + Math.abs(y1 - y2);
		if (temp <= 1000 && temp >= 0)
			return true;
		else
			return false;
	}
}