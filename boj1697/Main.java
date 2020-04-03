package boj1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Number {
	int num;
	int count;

	Number(int num, int count) {
		this.num = num;
		this.count = count;
	}
}

public class Main {

	static int n, m;
	static int min = Integer.MAX_VALUE;
	static boolean checked[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		checked = new boolean[1000001];

		if (n == m) {
			System.out.println(0);
			return;
		}

		bfs();
		System.out.println(min);
	}

	static void bfs() {
		Queue<Number> q = new LinkedList<Number>();
		q.add(new Number(n, 0));
		checked[n] = true;

		while (!q.isEmpty()) {
			Number temp = q.remove();
			int num = temp.num;
			for (int i = 0; i < 3; i++) {
				int count = temp.count;
				if (i == 0) {
					num = temp.num - 1;
				} else if (i == 1) {
					num = temp.num + 1;
				} else if (i == 2) {
					num = temp.num * 2;
				}
				count++;

				if (num < 0 || num >= 1000001)
					continue;

				if (checked[num] == true)
					continue;

				checked[num] = true;
				if (num == m) {
					min = count;
					return;
				} else {
					q.add(new Number(num, count));
				}
			}
		}

	}

}