package programmers12951;

class Main {
	public static void main(String[] args) {
		Solution sol = new Solution();
		String s = "aA  A";
		System.out.println(sol.solution(s));
	}
}

class Solution {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();

		boolean spaceFlag = true;
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (spaceFlag && c >= 'a' && c <= 'z') {
				c = (char) (c - 32);
				spaceFlag = false;
			} else if (!spaceFlag && c >= 'A' && c <= 'Z')
				c = (char) (c + 32);
			
			spaceFlag = false;
			if (c == ' ') {
				spaceFlag = true;
			}

			sb.append(c);
		}

		return sb.toString();
	}
}