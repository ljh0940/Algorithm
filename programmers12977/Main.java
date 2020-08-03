package programmers12977;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int nums[] = { 1, 2, 7, 6, 4 };
		sol.solution(nums);
	}
}

class Solution {
	int primeNumbers[];
	boolean checked[];
	int answer = 0;

	public int solution(int[] nums) {

		primeNumbers = new int[2998];

		primeNumbers[0] = 1;
		primeNumbers[1] = 1;

		for (int i = 2; i <= Math.sqrt(2998); i++)
			eratostenes(i);

		checked = new boolean[nums.length];

		combination(0, 3, 0, 0, nums);

		return answer;
	}

	void eratostenes(int n) {
		int num = 2 * n;

		while (num < 2998) {
			primeNumbers[num] = 1;
			num = num + n;
		}
	}

	void combination(int index, int depth, int count, int sum, int nums[]) {
		if (depth == count) {
			if (primeNumbers[sum] == 0)
				answer++;
			return;
		}

		for (int i = index; i < nums.length; i++) {
			if (checked[i])
				continue;

			checked[i] = true;
			combination(i, depth, count + 1, sum + nums[i], nums);
			checked[i] = false;
		}
	}
}