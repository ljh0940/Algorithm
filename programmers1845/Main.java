package programmers1845;

import java.util.HashSet;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int nums[] = { 3, 3, 3, 2, 2, 4 };
		sol.solution(nums);
	}
}

class Solution {
	public int solution(int[] nums) {
		int answer = 0;

		HashSet<Integer> hashset = new HashSet<>();

		for (int num : nums) {
			hashset.add(num);
		}

		answer = hashset.size() > nums.length / 2 ? nums.length / 2 : hashset.size();

		return answer;
	}
}