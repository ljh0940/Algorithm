package kakao2018blind;

import java.util.Stack;

class Main12 {
	public static void main(String[] args) {
		Solution12 sol = new Solution12();
		String p = "()))((()";
		sol.solution(p);
	}

}

class Solution12 {
	public String solution(String p) {
		String answer = "";

		if (p.equals(""))
			return "";

		if (check(p) == true)
			answer = p;
		else
			answer = solve(p, p.charAt(0), 0);

		return answer;
	}

	String solve(String p, char c, int startIndex) {
		int endIndex = 0;
		int count = 0;
		StringBuilder sb = new StringBuilder();

		if (p.equals(""))
			return "";

		for (int i = startIndex; i < p.length(); i++) {
			if (c == p.charAt(i)) {
				count++;
			} else {
				count--;
				if (count == 0) {
					endIndex = i + 1;
					break;
				}
			}
		}

		String u = p.substring(startIndex, endIndex);
		String v = p.substring(endIndex, p.length());
		if (check(u) == true) {
			if (v.equals("")) {
				sb.append(u);
			} else
				sb.append(u).append(solve(v, v.charAt(0), 0));
		} else {
			u = u.substring(1, u.length() - 1);
			sb.append("(");
			if (v.equals("") == false)
				sb.append(solve(v, v.charAt(0), 0));
			sb.append(")");

			for (int i = 0; i < u.length(); i++) {
				if (u.charAt(i) == '(')
					sb.append(")");
				else
					sb.append("(");
			}
		}

		return sb.toString();

	}

	boolean check(String p) {
		Stack<Character> checkStack = new Stack<>();

		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);

			if (c == '(') {
				checkStack.push('(');
			} else {
				if (checkStack.isEmpty() == true) {
					return false;
				}
				checkStack.pop();
			}
		}

		if (checkStack.isEmpty() == true)
			return true;
		else
			return false;
	}
}
