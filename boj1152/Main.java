package boj1152;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().trim().split(" ");
		int count = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(""))
				continue;
			count++;
		}

		System.out.println(count);
	}
}