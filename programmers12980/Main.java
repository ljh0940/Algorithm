package programmers12980;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 5000;
		sol.solution(n);
	}
}

class Solution {
	public int solution(int n) {
		int ans = 0;

		while (n > 0) {
			ans++;
			String binaryN = Integer.toBinaryString(n);
			n = n - (int) Math.pow(2, binaryN.length() - 1);
		}
		return ans;
	}
}