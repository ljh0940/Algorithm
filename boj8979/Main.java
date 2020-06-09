package boj8979;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Nation implements Comparable<Nation> {
	int index;
	int gold;
	int silver;
	int bronze;
	int rank;

	Nation(int index, int gold, int silver, int bronze) {
		this.index = index;
		this.gold = gold;
		this.silver = silver;
		this.bronze = bronze;
	}

	@Override
	public int compareTo(Nation o) {
		if (this.gold < o.gold)
			return 1;
		else if (this.gold == o.gold) {
			if (this.silver < o.silver)
				return 1;
			else if (this.silver == o.silver) {
				if (this.bronze < o.bronze)
					return 1;
				else if (this.bronze == o.bronze)
					return 0;
				else
					return -1;
			} else
				return -1;
		} else
			return -1;
	}

	public boolean equals(Nation o1, Nation o2) {
		if (o1.gold != o2.gold)
			return false;

		if (o1.silver != o2.silver)
			return false;

		if (o1.bronze != o2.bronze)
			return false;

		return true;
	}

}

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Nation> arr = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int index = Integer.parseInt(st.nextToken());
			int gold = Integer.parseInt(st.nextToken());
			int silver = Integer.parseInt(st.nextToken());
			int bronze = Integer.parseInt(st.nextToken());

			arr.add(new Nation(index, gold, silver, bronze));
		}

		Collections.sort(arr);

		if (k == 1) {
			System.out.println(arr.get(0).index);
			return;
		}

		Nation temp = arr.get(0);
		temp.rank = 1;
		for (int i = 1; i < arr.size(); i++) {
			Nation nation = arr.get(i);
			if (temp.equals(temp, nation))
				nation.rank = temp.rank;
			else
				nation.rank = i + 1;

			if (k == nation.index) {
				System.out.println(nation.rank);
				return;
			} else {
				temp = nation;
			}
		}
	}
}