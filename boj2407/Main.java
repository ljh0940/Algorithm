package boj2407;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int r;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());

		System.out.println(calc());
	}

	static BigInteger calc() {
		BigInteger temp = BigInteger.valueOf(n);
		for (int i = n - 1; i > n - r; i--) {
			temp = temp.multiply(BigInteger.valueOf(i));
		}
		for (int j = 2; j <= r; j++) {
			temp = temp.divide(BigInteger.valueOf(j));
		}

		return temp;
	}
}