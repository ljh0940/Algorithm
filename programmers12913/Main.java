package programmers12913;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int land[][] = { { 1, 2, 3, 5 }, { 5, 6, 7, 8 }, { 4, 3, 2, 1 } };
		sol.solution(land);
	}
}

class Solution {
	int solution(int[][] land) {
		int answer = 0;

		int dp[][] = new int[land.length][4];

		for (int i = 0; i < 4; i++) {
			dp[0][i] = land[0][i];
		}

		for (int i = 1; i < land.length; i++) {
			dp[i][0] = Math.max(dp[i - 1][1], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][0];
			dp[i][1] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][2], dp[i - 1][3])) + land[i][1];
			dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][3])) + land[i][2];
			dp[i][3] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2])) + land[i][3];
		}

		for (int number : dp[land.length - 1]) {
			if (answer < number)
				answer = number;
		}

		return answer;
	}
}