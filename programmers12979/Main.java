package programmers12979;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 16;
		int stations[] = { 9 };
		int w = 2;
		sol.solution(n, stations, w);
	}
}

class Solution {
	public int solution(int n, int[] stations, int w) {
		int answer = 0;

		int point = 2 * w + 1;

		int start = 1;
		int end = stations[0] - w;

		int length = calc(start, end);
		answer = answer + length / point;
		if (length != 0 && length % point != 0)
			answer++;

		for (int i = 0; i < stations.length - 1; i++) {
			start = stations[i] + w + 1;

			end = stations[i + 1] - w;
			length = calc(start, end);
			answer = answer + length / point;
			if (length != 0 && length % point != 0)
				answer++;
		}

		if (end < n) {
			start = end + 2 * w;
			length = calc(start, n);
			answer = answer + length / point;
			if (length != 0 && length % point != 0)
				answer++;
		}

		return answer;
	}

	int calc(int start, int end) {
		return end - start > 0 ? end - start : 0;
	}
}