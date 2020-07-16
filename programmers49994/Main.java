package programmers49994;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String dirs = "ULURRDLLU";
		sol.solution(dirs);
	}
}

class Solution {
	int dx[] = { 1, 0, -1, 0 };
	int dy[] = { 0, 1, 0, -1 };
	int map[][][] = new int[11][11][4];

	int x = 5;
	int y = 5;
	int count = 0;

	public int solution(String dirs) {
		int answer = 0;

		for (int i = 0; i < dirs.length(); i++) {
			char charOrder = dirs.charAt(i);
			int intOrder = 0;
			if (charOrder == 'D')
				intOrder = 0;
			else if (charOrder == 'R')
				intOrder = 1;
			else if (charOrder == 'U')
				intOrder = 2;
			else
				intOrder = 3;

			move(intOrder);
		}

		answer = count;

		return answer;
	}

	void move(int order) {
		int nx = x + dx[order];
		int ny = y + dy[order];

		if (nx < 0 || nx >= 11 || ny < 0 || ny >= 11)
			return;

		if (map[x][y][order] == 0 && map[nx][ny][(order + 2) % 4] == 0) {
			map[x][y][order]++;
			count++;
		}

		x = nx;
		y = ny;
	}
}