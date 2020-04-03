package boj15686;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;
	int color;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}

	Pos(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}
}

public class Main {
	static int n;
	static int m;
	static int min = Integer.MAX_VALUE;

	static int map[][];

	static boolean checked[];

	static ArrayList<Pos> chicken;
	static ArrayList<Pos> house;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		chicken = new ArrayList<>();
		house = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());

				if (map[i][j] == 1)
					house.add(new Pos(i, j));

				if (map[i][j] == 2)
					chicken.add(new Pos(i, j));
			}
		}

		checked = new boolean[chicken.size()];

		for (int i = 0; i < chicken.size(); i++) {
			checked[i] = true;
			check(i, 0);
			checked[i] = false;
		}

		System.out.println(min);
	}

	static void check(int index, int count) {
		int sum = 0;

		if (count >= m) {
			return;
		}

		if (count == m - 1) {

			for (int i = 0; i < house.size(); i++) {
				Pos p = house.get(i);
				int x1 = p.x;
				int y1 = p.y;

				int minValue = Integer.MAX_VALUE;

				for (int j = 0; j < chicken.size(); j++) {
					if (checked[j] == false)
						continue;
					p = chicken.get(j);
					int x2 = p.x;
					int y2 = p.y;

					minValue = Math.min(minValue, Math.abs(x1 - x2) + Math.abs(y1 - y2));
				}

				sum = sum + minValue;
			}

			min = Math.min(min, sum);
		}

		for (int i = index; i < chicken.size(); i++) {
			if (checked[i] == true)
				continue;

			checked[i] = true;

			check(i, count + 1);

			checked[i] = false;
		}

	}
}