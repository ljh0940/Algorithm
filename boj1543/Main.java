package boj1543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String document = br.readLine();
		String word = br.readLine();

		Solution sol = new Solution();
		System.out.println(sol.solution(document, word));
	}
}

class Solution {
	int solution(String document, String word) {
		int count = 0;

		boolean flag = true;
		for (int i = 0; i <= document.length() - word.length(); i++) {
			flag = true;
			for (int j = 0; j < word.length(); j++) {
				if (document.charAt(i + j) != word.charAt(j)) {
					flag = false;
					break;
				}
			}

			if (flag == true) {
				count++;
				i = i + word.length() - 1;
			}
		}

		return count;
	}
}