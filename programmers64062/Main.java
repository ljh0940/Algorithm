package programmers64062;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int stones[] = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		int k = 3;
		System.out.println(sol.solution(stones, k));
	}
}

class Solution {
	public int solution(int[] stones, int k) {
		int answer = 0;

		long left = 1;
		long right = 2000000000;

		while (left <= right) {
			long mid = (left + right) / 2;

			if (check(stones, k, mid)) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		answer = left == 0 ? 1 : (int) left - 1;

		return answer;
	}

	boolean check(int[] stones, int k, long mid) {
		int count = 0;
		for (int i = 0; i < stones.length; i++) {
			if (stones[i] - mid < 0)
				count++;
			else
				count = 0;

			if (count == k)
				return false;
		}

		return true;
	}
}