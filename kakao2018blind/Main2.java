package kakao2018blind;

class Main2 {
	public static void main(String[] args) {
		Solution2 sol = new Solution2();
		String dartResult = "1T2D3D#";
		sol.solution(dartResult);
	}

}

class Solution2 {
	int round[] = new int[3];

	public int solution(String dartResult) {
		int answer = 0;

		int roundNum = 0;
		for (int i = 0; i < dartResult.length() - 1; i = i + 2) {
			int score = dartResult.charAt(i) - '0';
			if (score == 1 && dartResult.charAt(i + 1) == '0') {
				score = 10;
				i++;
			}
			int bonus = dartResult.charAt(i + 1) == 'S' ? 1 : dartResult.charAt(i + 1) == 'D' ? 2 : 3;
			char option = 'X';
			if (i + 2 < dartResult.length()) {
				if (dartResult.charAt(i + 2) == '#' || dartResult.charAt(i + 2) == '*')
					option = dartResult.charAt(i + 2);
			}

			round[roundNum] = (int) Math.pow(score, bonus);

			if (option == '*') {
				if (roundNum != 0) {
					round[roundNum - 1] = round[roundNum - 1] * 2;
				}
				round[roundNum] = round[roundNum] * 2;
				i++;
			} else if (option == '#') {
				round[roundNum] = -round[roundNum];
				i++;
			}
			roundNum++;
		}

		for (int i = 0; i < 3; i++) {
			answer = answer + round[i];
		}

		return answer;
	}
}