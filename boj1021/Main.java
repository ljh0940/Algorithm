package boj1021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static boolean queue[];
	static int point = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		queue = new boolean[n];

		int count = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int target = Integer.parseInt(st.nextToken()) - 1;

			int leftCount = left(target);
			int rightCount = right(target);

			if (leftCount <= rightCount) {
				count = count + leftCount;
			} else {
				count = count + rightCount;
			}
			queue[target] = true;
			while (i != m - 1 && queue[target] == true) {
				target++;
				if (target == queue.length) {
					target = 0;
				}
				point = target;
			}
		}

		System.out.println(count);
	}

	static int left(int target) {
		int leftCount = 0;

		for (int i = point - 1; i >= 0; i--) {
			if (i == target)
				return leftCount + 1;
			if (queue[i] == false)
				leftCount++;
		}

		leftCount++;
		for (int i = queue.length - 1; i >= target; i--) {
			if (i == target)
				return leftCount;
			if (queue[i] == false)
				leftCount++;
		}

		return leftCount;
	}

	static int right(int target) {
		int rightCount = 0;

		for (int i = point; i < queue.length; i++) {
			if (i == target)
				return rightCount;
			if (queue[i] == false)
				rightCount++;
		}

		for (int i = 0; i < target; i++) {
			if (i == target)
				return rightCount;

			if (queue[i] == false)
				rightCount++;
		}

		return rightCount;
	}
}