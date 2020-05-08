package kakao2018blind;

class Main9 {
	public static void main(String[] args) {
		Solution9 sol = new Solution9();
		int n = 3;
		int t = 16;
		int m = 2;
		int p = 2;

		sol.solution(n, t, m, p);
	}
}

class Solution9 {
	public String solution(int n, int t, int m, int p) {
		StringBuilder answer = new StringBuilder();
		StringBuilder number = new StringBuilder();

		for (int i = 0; i < t * m; i++) {
			if (i == 0)
				number.append(0);
			else
				number.append(calcN(n, i));
		}

		int index = p - 1;
		while (t > 0) {
			answer.append(number.charAt(index));
			index = index + m;
			t--;
		}

		return answer.toString();
	}

	String calcN(int n, int num) {
		StringBuilder sb = new StringBuilder();

		while (num > 0) {
			int mod = num % n;
			String modStr = Integer.toString(mod);
			if (mod == 10)
				modStr = "A";
			if (mod == 11)
				modStr = "B";
			if (mod == 12)
				modStr = "C";
			if (mod == 13)
				modStr = "D";
			if (mod == 14)
				modStr = "E";
			if (mod == 15)
				modStr = "F";

			sb.append(modStr);
			num = num / n;
		}

		sb.reverse();
		return sb.toString();
	}
}