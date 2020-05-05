package kakao2018blind;

import java.util.Arrays;

class Main3 {
	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		int m = 6;
		int n = 6;
		String[] board = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };
		sol.solution(m, n, board);
	}

}

class Solution3 {
	int count = 0;
	boolean checked[][];
	char newBoard[][];

	public int solution(int m, int n, String[] board) {
		int answer = 0;

		newBoard = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				newBoard[i][j] = board[i].charAt(j);
			}
		}
		solve(m, n);

		answer = count;

		return answer;
	}

	void solve(int n, int m) {
		checked = new boolean[n][m];
		while (true) {
			for (int i = 0; i < n; i++) {
				Arrays.fill(checked[i], false);
			}
			if (check() == false)
				break;

			remove();
			move();
		}
	}

	void move() {
		for (int j = 0; j < newBoard[0].length; j++) {
			for (int i = newBoard.length - 1; i > 0; i--) {
				int temp = 0;
				while (newBoard[i - temp][j] == 'X') {
					newBoard[i - temp][j] = newBoard[i - 1 - temp][j];
					newBoard[i - 1 - temp][j] = 'X';
					temp++;

					if (i - temp - 1 < 0) {
						boolean flag = false;
						for (int k = i; k > 0; k--) {
							if (newBoard[k][j] != 'X') {
								flag = true;
								temp = 0;
								break;
							}
						}
						if (flag == false)
							break;
					}

				}
			}
		}
	}

	void remove() {
		for (int i = 0; i < checked.length; i++) {
			for (int j = 0; j < checked[i].length; j++) {
				if (checked[i][j] == true) {
					newBoard[i][j] = 'X';
					count++;
				}
			}
		}
	}

	boolean check() {
		boolean flag = false;
		for (int i = 0; i < newBoard.length - 1; i++) {
			for (int j = 0; j < newBoard[i].length - 1; j++) {
				char pivot = newBoard[i][j];
				if (pivot == 'X')
					continue;

				if (pivot != newBoard[i][j + 1])
					continue;
				if (pivot != newBoard[i + 1][j])
					continue;
				if (pivot != newBoard[i + 1][j + 1])
					continue;

				checked[i][j] = true;
				checked[i + 1][j] = true;
				checked[i][j + 1] = true;
				checked[i + 1][j + 1] = true;
				flag = true;
			}
		}

		return flag;
	}

}