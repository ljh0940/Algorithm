package boj3190;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Pos {
	int x;
	int y;

	Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

class Snake {
	Pos head;
	LinkedList<Pos> tail = new LinkedList<>();
	int order = 1; // 동

	Snake(Pos head) {
		this.head = head;
	}
}

class Main {
	static int n;
	static int map[][];
	static HashMap<Integer, Character> change;

	static int dx[] = { 1, 0, -1, 0 }; // 남 동 북 서
	static int dy[] = { 0, 1, 0, -1 };

	static Snake snake;

	static int count;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		map = new int[n][n];
		change = new HashMap<>();

		map[0][0] = 1;
		snake = new Snake(new Pos(0, 0));
		snake.tail.add(new Pos(snake.head.x, snake.head.y));

		int k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			map[x - 1][y - 1] = 2;
		}

		k = Integer.parseInt(br.readLine());

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			char order = st.nextToken().charAt(0);

			change.put(time, order);
		}

		solve();

		System.out.println(count);
	}

	static void solve() {
		while (true) {
			count++;

			if (change.containsKey(count - 1) == true) { // X초가 끝나고 방향이 바뀜
				snake.order = turn(change.get(count - 1), snake.order);
			}

			snake.head.x += dx[snake.order];
			snake.head.y += dy[snake.order];

			if (snake.head.x < 0 || snake.head.x >= n || snake.head.y < 0 || snake.head.y >= n) {
				break;
			}

			if (map[snake.head.x][snake.head.y] == 0) {
				map[snake.head.x][snake.head.y] = 1;
				map[snake.tail.get(0).x][snake.tail.get(0).y] = 0;
				snake.tail.add(new Pos(snake.head.x, snake.head.y));
				snake.tail.removeFirst();
				continue;
			}

			if (map[snake.head.x][snake.head.y] == 1) {
				break;
			}

			if (map[snake.head.x][snake.head.y] == 2) {
				map[snake.head.x][snake.head.y] = 1;
				snake.tail.add(new Pos(snake.head.x, snake.head.y));
			}
		}

	}

	static int turn(char order, int index) {
		// 0 1 2 3 남 동 북 서
		if (index == 0) { // 남
			if (order == 'L')
				return 1;
			if (order == 'D')
				return 3;
		}

		else if (index == 1) { // 동
			if (order == 'L')
				return 2;
			if (order == 'D')
				return 0;
		}

		else if (index == 2) { // 북
			if (order == 'L')
				return 3;
			if (order == 'D')
				return 1;
		}

		else if (index == 3) { // 서
			if (order == 'L')
				return 0;
			if (order == 'D')
				return 2;
		}

		return 1;

	}

}