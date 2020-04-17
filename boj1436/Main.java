package boj1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int num = 666;


		int count = 1;

		while (count != n) {
			int temp = num;
			while (check(++temp) == false) {
				;
			}
			count++;
			num = temp;
		}

		System.out.println(num);
	}

	static boolean check(int n) {
		String str = Integer.toString(n);
		int length = str.length();

		for (int i = 0; i <= length - 3; i++) {
			if (str.substring(i, i + 3).equals("666") == true)
				return true;
		}

		return false;

	}
}