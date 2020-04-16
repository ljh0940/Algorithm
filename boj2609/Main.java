package boj2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		System.out.println(calc1(n, m));
		System.out.println(calc2(n, m));
	}

	static int calc1(int n, int m) {
		Stack<Integer> nn = new Stack<>();
		Stack<Integer> mm = new Stack<>();

		for (int i = 1; i <= n; i++) {
			if (n % i == 0)
				nn.push(i);
		}

		for (int i = 1; i <= m; i++) {
			if (m % i == 0)
				mm.push(i);
		}

		n = nn.pop();
		m = mm.pop();

		while (n != m) {
			if (n > m) {
				n = nn.pop();
			} else if (n < m) {
				m = mm.pop();
			}
		}

		return n;
	}

	static int calc2(int n, int m) {
		int nn = n;
		int mm = m;

		while (nn != mm) {
			if (nn > mm) {
				mm = mm + m;
			} else if (nn < mm) {
				nn = nn + n;
			}
		}

		return nn;
	}
}