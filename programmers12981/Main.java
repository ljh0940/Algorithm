package programmers12981;

import java.util.HashSet;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 2;
		String words[] = { "hello", "one", "even", "never", "now", "world", "draw" };
		sol.solution(n, words);
	}
}

class Solution {
	public int[] solution(int n, String[] words) {
		int[] answer = new int[2];

		HashSet<String> hashset = new HashSet<>();

		char end = '1';
		int number = 0;
		hashset.add(words[0]);

		for (int i = 0; i < words.length; i++) {
			number = i / n + 1;
			char start = words[i].charAt(0);

			if (i == 0) {
				end = words[i].charAt(words[i].length() - 1);
				continue;
			}

			if (hashset.contains(words[i]) || end != start) {
				answer[0] = i % n + 1;
				answer[1] = number;

				return answer;
			}

			end = words[i].charAt(words[i].length() - 1);
			hashset.add(words[i]);

		}

		return answer;
	}
}