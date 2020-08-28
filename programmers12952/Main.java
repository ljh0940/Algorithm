package programmers12952;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 4;
		sol.solution(n);
	}
}

class Solution {
	boolean map[][];
	int answer;

	int dx[] = { 1, 0, -1, 0, -1, -1, 1, 1 };
	int dy[] = { 0, 1, 0, -1, -1, 1, -1, 1 };

	public int solution(int n) {
		map = new boolean[n][n];

		combination(n, 0, n);

		return answer;
	}

	void combination(int depth, int now, int n) {
		if (depth == now) {
			answer++;

			return;
		}

		for (int i = 0; i < n; i++) {
			map[now][i] = true;
			if (check(now, i, n)) {
				combination(depth, now + 1, n);
			}

			map[now][i] = false;
		}
	}

	boolean check(int x, int y, int n) {
		for (int i = 0; i < 8; i++) {
			int nx = x;
			int ny = y;

			while (true) {
				nx = nx + dx[i];
				ny = ny + dy[i];

				if (nx < 0 || nx >= n || ny < 0 || ny >= n)
					break;

				if (map[nx][ny])
					return false;
			}
		}

		return true;
	}
}