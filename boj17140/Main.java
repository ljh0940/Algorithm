package boj17140;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.StringTokenizer;

class Temp {
	int key;
	int count;

	Temp(int key, int count) {
		this.key = key;
		this.count = count;
	}
}

class Main {
	static int map[][];
	static int r;
	static int c;
	static int k;

	static HashMap<Integer, Integer> hash;
	static ArrayList<Temp> temp[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int count = 0;

		map = new int[3][3];
		hash = new HashMap<>();

		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			if (map.length > r - 1 && map[0].length > c - 1) {
				if ((map[r - 1][c - 1] == k))
					break;
			}
			count++;
			if (count > 100) {
				System.out.println(-1);
				return;
			}
			if (map.length >= map[0].length) {
				calcR();
			} else {
				calcC();
			}

		}

		System.out.println(count);
	}

	static void calcR() {
		int maxArray = 0;
		temp = new ArrayList[map.length];

		for (int i = 0; i < map.length; i++) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			temp[i] = new ArrayList<>();
			for (int j = 0; j < map[i].length; j++) {
				if (map[i][j] == 0)
					continue;
				if (hash.containsKey(map[i][j]) == true) {
					hash.replace(map[i][j], hash.get(map[i][j]) + 1);
				} else {
					max = Math.max(max, map[i][j]);
					min = Math.min(min, map[i][j]);
					hash.put(map[i][j], 1);
				}
			}

			for (int j = min; j <= max; j++) {
				if (hash.containsKey(j) == true) {
					temp[i].add(new Temp(j, hash.get(j)));
					if (temp[i].size() == 50)
						break;
				}
			}

			hash.clear();
			maxArray = Math.max(maxArray, temp[i].size());

			Comparator<Temp> com = new Comparator<Temp>() {

				@Override
				public int compare(Temp o1, Temp o2) {
					if (o1.count > o2.count) {
						if (o1.key > o2.key)
							return 1;
						return -1;
					} else if (o1.count == o2.count) {
						if (o1.key > o2.key)
							return 1;
						return -1;
					} else {
						return -1;
					}
				};
			};

			temp[i].sort(com);
		}

		map = new int[temp.length][maxArray * 2];
		for (int i = 0; i < map.length; i++) {
			int temp2 = 0;
			for (int j = 0; j < temp[i].size() * 2; j = j + 2) {
				map[i][j] = temp[i].get(temp2).key;
				map[i][j + 1] = temp[i].get(temp2).count;
				temp2++;
			}
		}

	}

	static void calcC() {
		int maxArray = 0;
		temp = new ArrayList[map[0].length];

		for (int i = 0; i < map[0].length; i++) {
			int min = Integer.MAX_VALUE;
			int max = 0;
			temp[i] = new ArrayList<>();
			for (int j = 0; j < map.length; j++) {
				if (map[j][i] == 0)
					continue;
				if (hash.containsKey(map[j][i]) == true) {
					hash.replace(map[j][i], hash.get(map[j][i]) + 1);
				} else {
					max = Math.max(max, map[j][i]);
					min = Math.min(min, map[j][i]);
					hash.put(map[j][i], 1);
				}
			}

			for (int j = min; j <= max; j++) {
				if (hash.containsKey(j) == true) {
					temp[i].add(new Temp(j, hash.get(j)));
					if (temp[i].size() == 50)
						break;
				}
			}
			hash.clear();
			maxArray = Math.max(maxArray, temp[i].size());

			Comparator<Temp> com = new Comparator<Temp>() {

				@Override
				public int compare(Temp o1, Temp o2) {
					if (o1.count > o2.count) {
						if (o1.key > o2.key)
							return 1;
						return -1;
					} else if (o1.count == o2.count) {
						if (o1.key > o2.key)
							return 1;
						return -1;
					} else {
						return -1;
					}
				};
			};

			temp[i].sort(com);
		}

		map = new int[maxArray * 2][temp.length];
		for (int i = 0; i < map[0].length; i++) {
			int temp2 = 0;
			for (int j = 0; j < temp[i].size() * 2; j = j + 2) {
				map[j][i] = temp[i].get(temp2).key;
				map[j + 1][i] = temp[i].get(temp2).count;
				temp2++;
			}
		}
	}
}