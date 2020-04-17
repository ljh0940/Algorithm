package boj14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int map[][];
	static boolean checked[];

	static int min = Integer.MAX_VALUE;
	static int n;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		map = new int[n][n];
		checked = new boolean[n];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		teamSel(0, 0);

		System.out.println(min);

	}

	static void teamSel(int index, int count) {
		if (count == n / 2) {
			calc();
			return;
		}

		for (int i = index; i < n; i++) {
			if (checked[i] == true)
				continue;

			checked[i] = true;
			teamSel(i, count + 1);
			checked[i] = false;
		}
	}

	static void calc() {
		int team1 = 0;
		int team2 = 0;
		for (int i = 0; i < n - 1; i++) {
			if (checked[i] == true) {
				for (int j = i + 1; j < n; j++) {
					if (checked[j] == true) {
						team1 = team1 + map[i][j] + map[j][i];
					}
				}
			} else {
				for (int j = i + 1; j < n; j++) {
					if (checked[j] == false) {
						team2 = team2 + map[i][j] + map[j][i];
					}
				}
			}
		}

		int temp = Math.abs(team1 - team2);

		if (temp < min)
			min = temp;
	}

}