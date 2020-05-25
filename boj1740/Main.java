package boj1740;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int count = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long n = Long.parseLong(br.readLine());
		long number = 0;

		String binary = Long.toBinaryString(n);
		for (int i = 0; i < binary.length(); i++) {
			if (binary.charAt(i) == '1') {
				number = number + pow(3, binary.length() - i - 1);
			}
		}

		System.out.println(number);
	}

	static long pow(int number, int exp) {
		long result = 1;
		while (exp > 0) {
			result = result * number;
			exp--;
		}

		return result;
	}
}