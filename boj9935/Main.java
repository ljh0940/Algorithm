package boj9935;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class Main {

	static Stack<Character> st1 = new Stack<>();
	static Stack<Character> st2 = new Stack<>();

	static String str;
	static String bomb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		str = br.readLine();
		bomb = br.readLine();

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			st1.push(c);
			if (c == bomb.charAt(bomb.length() - 1)) {
				check();
			}
		}

		StringBuilder sb = new StringBuilder();
		if (st1.size() == 0)
			System.out.println("FRULA");
		else {
			while (!st1.isEmpty()) {
				sb.append(st1.pop());
			}
			System.out.println(sb.reverse());
		}
	}

	static boolean check() {
		if (st1.size() < bomb.length())
			return false;

		for (int i = bomb.length() - 1; i >= 0; i--) {
			char c = st1.pop();
			st2.push(c);
			if (c != bomb.charAt(i)) {
				while (!st2.isEmpty())
					st1.push(st2.pop());
				return false;
			}
		}

		st2.clear();

		return true;
	}

}
