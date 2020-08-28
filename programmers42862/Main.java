package programmers42862;

import java.util.ArrayList;
import java.util.HashSet;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 5;
		int lost[] = { 2, 4 };
		int reserve[] = { 1, 3, 5 };
		sol.solution(n, lost, reserve);
	}
}

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		ArrayList<Integer> arr = new ArrayList<>();
		HashSet<Integer> hash = new HashSet<>();
		for (int student : reserve)
			hash.add(student);

		for (int student : lost) {
			if (hash.contains(student)) {
				hash.remove(student);
			} else {
				arr.add(student);
			}
		}

		arr.sort(null);

		answer = n - arr.size();

		for (int i = 0; i < arr.size(); i++) {
			int now = arr.get(i);
			int front = now - 1;
			int back = now + 1;

			if (front > 0 && hash.contains(front)) {
				hash.remove(front);
				answer++;
				continue;
			}

			if (back <= n && hash.contains(back)) {
				hash.remove(back);
				answer++;
			}
		}

		return answer;
	}
}