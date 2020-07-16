package programmers12987;

import java.util.Arrays;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int A[] = { 5, 1, 3, 7 };
		int B[] = { 2, 2, 6, 8 };
		sol.solution(A, B);
	}
}

class Solution {
	public int solution(int[] A, int[] B) {
		int answer = 0;

		Arrays.sort(A);
		Arrays.sort(B);

		int point = 0;
		for (int i = 0; i < A.length; i++) {
			if (point == B.length)
				break;
			
			for (int j = point; j < B.length; j++) {
				if (A[i] < B[j]) {
					answer++;
					point = j + 1;
					break;
				}
			}
		}

		return answer;
	}
}