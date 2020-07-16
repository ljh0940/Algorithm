package programmers62049;

import java.util.ArrayList;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 4;
		sol.solution(n);
	}
}

class Solution {
	public int[] solution(int n) {
		int[] answer = {};

		ArrayList<Integer> arr = new ArrayList<>();

		arr.add(0);

		for (int i = 0; i < n - 1; i++) {
			int size = arr.size();
			arr.add(0);

			for (int j = size - 1; j >= 0; j--) {
				arr.add((arr.get(j) + 1) % 2);
			}
		}

		answer = new int[arr.size()];
		for (int i = 0; i < arr.size(); i++)
			answer[i] = arr.get(i);

		return answer;
	}
}