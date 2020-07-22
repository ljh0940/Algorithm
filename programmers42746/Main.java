package programmers42746;

import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int numbers[] = { 131, 1311 };
		sol.solution(numbers);
	}
}

class Solution {
	PriorityQueue<String> numberPq;

	public String solution(int[] numbers) {
		String answer = "";

		numberPq = new PriorityQueue<>(new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				StringBuilder sb1 = new StringBuilder();
				StringBuilder sb2 = new StringBuilder();
				sb1.append(o1).append(o2);
				sb2.append(o2).append(o1);

				if (Integer.parseInt(sb1.toString()) < Integer.parseInt(sb2.toString()))
					return 1;
				else
					return -1;
			}
		});

		for (int number : numbers) {
			numberPq.offer(Integer.toString(number));
		}

		StringBuilder sb = new StringBuilder();
		boolean flag = true;
		while (!numberPq.isEmpty()) {
			String number = numberPq.poll();
			if (flag && number.equals("0"))
				continue;
			else {
				sb.append(number);
				flag = false;
			}
		}

		answer = sb.length() == 0 ? "0" : sb.toString();

		return answer;
	}
}