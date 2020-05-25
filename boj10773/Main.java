package boj10773;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(br.readLine());

		Stack<Integer> st = new Stack<>();
		for (int i = 0; i < k; i++) {
			int number = Integer.parseInt(br.readLine());
			if (number == 0)
				st.pop();
			else
				st.push(number);
		}

		int sum = 0;
		while (!st.isEmpty()) {
			sum = sum + st.pop();
		}

		System.out.println(sum);
	}
}