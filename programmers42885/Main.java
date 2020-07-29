package programmers42885;

import java.util.Arrays;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int people[] = { 70, 50, 80, 50 };
		int limit = 100;
		sol.solution(people, limit);
	}
}

class Solution {
	public int solution(int[] people, int limit) {
		int answer = 0;

		Arrays.sort(people);

		int temp = 0;
		for (int i = people.length - 1; i >= 0; i--) {
			if (i < temp)
				break;
			answer++;

			if (i == temp)
				break;

			if (people[i] + people[temp] <= limit) {
				temp++;
			}
		}

		return answer;
	}
}