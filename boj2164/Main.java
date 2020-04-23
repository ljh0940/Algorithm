package boj2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class Main {
	static LinkedList<Integer> arr = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(1);
			return;
		}

		if (n < 4) {
			System.out.println(2);
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (i % 2 == 0)
				arr.add(i);
		}

		System.out.println(calc(n));

	}

	static int calc(int n) {

		if (n % 2 == 0) {
			while (arr.size() >= 2) {
				arr.removeFirst();
				arr.addLast(arr.get(0));
				arr.removeFirst();
			}
		} else {
			while (arr.size() > 2) {
				arr.addLast(arr.get(0));
				arr.removeFirst();
				arr.removeFirst();
			}
		}
		return arr.get(0);

	}
}