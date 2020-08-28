package programmers12927;

import java.util.Collections;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int works[] = { 4, 3, 3 };
		int n = 4;
		sol.solution(n, works);
	}
}

class Solution {
	public long solution(int n, int[] works) {
		long answer = 0;

		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

		for (int work : works) {
			pq.offer(work);
		}

		for (int i = 0; i < n; i++) {
			if (pq.isEmpty())
				return 0;

			int newWork = pq.poll() - 1;
			if (newWork != 0)
				pq.offer(newWork);
		}

		while (!pq.isEmpty()) {
			int fatigue = pq.poll();
			answer += fatigue * fatigue;
		}

		return answer;
	}
}