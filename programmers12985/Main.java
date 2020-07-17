package programmers12985;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 8;
		int a = 2;
		int b = 3;
		sol.solution(n, a, b);
	}
}

class Solution {
	public int solution(int n, int a, int b) {
		int answer = 1;

		if (a > b) {
			int temp = b;
			b = a;
			a = temp;
		}

		while (b % 2 == 1 || b - a != 1) {
			answer++;
			b = (b + 1) / 2;
			a = (a + 1) / 2;
		}

		return answer;
	}
}