package boj2617;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Ball {
	int number;
	int bigCount;
	int smallCount;

	Ball(int number) {
		this.number = number;
	}
}

class Main {
	static ArrayList<Integer> bigArr[];
	static ArrayList<Integer> smallArr[];
	static ArrayList<Ball> ballArr;

	static int n;
	static int m;

	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		bigArr = new ArrayList[n + 1];
		smallArr = new ArrayList[n + 1];
		ballArr = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			bigArr[i] = new ArrayList<>();
			smallArr[i] = new ArrayList<>();
			ballArr.add(new Ball(i));
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken());
			int second = Integer.parseInt(st.nextToken());

			smallArr[first].add(second);
			bigArr[second].add(first);
		}
		checked = new boolean[n + 1];

		for (int i = 1; i <= n; i++) {
			Arrays.fill(checked, false);
			ballArr.get(i - 1).bigCount = bigDfs(i, 0);
		}

		for (int i = 1; i <= n; i++) {
			Arrays.fill(checked, false);
			ballArr.get(i - 1).smallCount = smallDfs(i, 0);
		}

		int count = 0;
		for (int i = 0; i < n; i++) {
			Ball ball = ballArr.get(i);
			if (ball.bigCount >= (n + 1) / 2) {
				count++;
				continue;
			}
			if (ball.smallCount >= (n + 1) / 2) {
				count++;
				continue;
			}
		}

		System.out.println(count);
	}

	static int bigDfs(int index, int count) {
		checked[index] = true;
		for (int i = 0; i < bigArr[index].size(); i++) {
			int next = bigArr[index].get(i);

			if (checked[next] == true)
				continue;

			count = bigDfs(next, count + 1);
		}

		return count;
	}

	static int smallDfs(int index, int count) {
		checked[index] = true;
		for (int i = 0; i < smallArr[index].size(); i++) {
			int next = smallArr[index].get(i);

			if (checked[next] == true)
				continue;

			count = smallDfs(next, count + 1);
		}

		return count;
	}
}