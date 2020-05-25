package boj1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String string = br.readLine();

		Solution sol = new Solution();
		System.out.println(sol.solution(string));
	}
}

class Solution {
	ArrayList<String> arr;

	int solution(String string) {
		arr = new ArrayList<>();

		int start = 0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (i == 0 && c == '-') {
				arr.add("-");
				start++;
				continue;
			}
			if (string.charAt(i) == '+') {
				arr.add(string.substring(start, i));
				arr.add("+");
				start = i + 1;
				continue;
			}
			if (string.charAt(i) == '-') {
				arr.add(string.substring(start, i));
				arr.add("-");
				start = i + 1;
				continue;
			}
		}

		arr.add(string.substring(start, string.length()));

		int sum = 0;
		if (arr.get(0) == "-") {
			sum = -Integer.parseInt(arr.get(1));
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i) == "-") {
					while (i + 2 < arr.size()) {
						sum = sum - Integer.parseInt(arr.get(i + 1));
						i = i + 2;
					}
				} else if (arr.get(i) == "+") {
					sum = sum + Integer.parseInt(arr.get(i + 1));
				}
			}
		} else {
			sum = Integer.parseInt(arr.get(0));
			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i) == "-") {
					while (i < arr.size()) {
						sum = sum - Integer.parseInt(arr.get(i + 1));
						i = i + 2;
					}
				} else if (arr.get(i) == "+") {
					sum = sum + Integer.parseInt(arr.get(i + 1));
				}
			}
		}

		return sum;
	}
}