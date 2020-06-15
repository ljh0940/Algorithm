package boj17281;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Player {
	int index;
	int order;
	ArrayList<Integer> result;

	Player(int index) {
		this.index = index;
		result = new ArrayList<>();
	}
}

class Main {
	static int n;
	static int max = 0;
	static ArrayList<Player> players;
	static ArrayList<Player> player;

	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());

		checked = new boolean[9];
		player = new ArrayList<>();
		players = new ArrayList<>();
		for (int i = 0; i < 9; i++)
			player.add(new Player(i));

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				int result = Integer.parseInt(st.nextToken());
				result = result == 0 ? 5 : result;
				player.get(j).result.add(result);
			}
		}

		permutation(0);

		System.out.println(max);
	}

	static void permutation(int depth) {
		if (depth == 9) {
			int score = calc();
			if (score > max)
				max = score;

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (checked[i] == true)
				continue;

			if (i == 0 && depth != 3)
				continue;

			checked[i] = true;
			players.add(player.get(i));
			permutation(depth + 1);
			checked[i] = false;
			players.remove(players.size() - 1);
		}
	}

	static int calc() {
		int score = 0;
		int now = 0;
		int outCount = 0;
		int inning = 0;

		boolean base[] = new boolean[3];
		while (true) {
			if (inning == n)
				break;

			now = now % 9;
			int result = players.get(now).result.get(inning);
			now++;
			if (result == 5) {
				outCount++;
				if (outCount == 3) {
					outCount = 0;
					inning++;
					base = new boolean[3];
					continue;
				}
			} else if (result == 4) {
				score++;
				for (int i = 0; i < 3; i++) {
					if (base[i] == true) {
						score++;
						base[i] = false;
					}
				}
			} else {
				for (int i = 2; i >= 0; i--) {
					if (base[i] == true) {
						int next = i + result;
						if (next > 2) {
							score++;
						} else {
							base[next] = true;
						}
						base[i] = false;
					}
				}
				base[result - 1] = true;
			}
		}

		return score;
	}
}