package programmers60058;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String p = ")(";
		sol.solution(p);
	}
}

class Solution {
	public String solution(String p) {
		String answer = "";

		if (isCorrect(p))
			answer = p;
		else
			answer = solve(p);

		return answer;
	}

	String solve(String w) {
		if (w.equals(""))
			return "";

		int index = getBalanceIndex(w);
		String u = w.substring(0, index);
		String v = "";
		if (index != w.length())
			v = w.substring(index, w.length());

		if (isCorrect(u)) {
			return u + solve(v);
		} else {
			String newString = "(" + solve(v) + ")";
			return newString + process(u);
		}
	}

	String process(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			if (i == 0 || i == s.length() - 1)
				continue;

			char c = s.charAt(i);
			if (c == '(')
				sb.append(")");
			else
				sb.append("(");
		}

		return sb.toString();
	}

	int getBalanceIndex(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(')
				count++;
			else
				count--;

			if (count == 0)
				return i + 1;
		}

		return s.length() - 1;
	}

	boolean isCorrect(String s) {
		int count = 0;

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(') {
				count++;
			} else {
				count--;

				if (count < 0)
					return false;
			}
		}

		if (count != 0)
			return false;
		else
			return true;
	}
}