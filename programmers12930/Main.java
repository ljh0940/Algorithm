package programmers12930;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "A  B ";
		sol.solution(s);
	}
}

class Solution {
	public String solution(String s) {
		String answer = "";

		String words[] = s.split(" ", -1);

		StringBuilder sb = new StringBuilder();
		for (String word : words) {
			for (int i = 0; i < word.length(); i++) {
				char alpha = word.charAt(i);
				boolean isUpper = true;
				if (alpha >= 'a' && alpha <= 'z')
					isUpper = false;

				if (i % 2 == 0 && !isUpper)
					sb.append((char) (alpha - 32));
				else if (i % 2 != 0 && isUpper)
					sb.append((char) (alpha + 32));
				else
					sb.append(alpha);
			}
			sb.append(" ");
		}

		answer = sb.toString().substring(0, s.length());

		return answer;
	}
}