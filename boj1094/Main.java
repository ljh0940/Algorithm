package boj1094;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int x = Integer.parseInt(br.readLine());

		String binaryX = Integer.toBinaryString(x);

		int count = 0;
		for (int i = 0; i < binaryX.length(); i++) {
			if (binaryX.charAt(i) == '1')
				count++;
		}

		System.out.println(count);
	}
}