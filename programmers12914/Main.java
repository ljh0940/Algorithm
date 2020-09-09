package programmers12914;


class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 6;
		sol.solution(n);
	}
}

class Solution {
	public long solution(int n) {
		long answer = 0;
		
		if(n==1)
			return 1;

		int dp[] = new int[n+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;

		for (int i = 2; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
		}
		
		answer = dp[n];

		return answer;
	}
}