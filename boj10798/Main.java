package boj10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str;
		StringBuilder sb = new StringBuilder();
		char arr[][] = new char[5][15];

		for (int i = 0; i < 5; i++) {
			str = br.readLine();
			int size = str.length();
			for (int j = 0; j < size; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 5; j++) {
				if (arr[j][i] != '\0') {
					sb.append(arr[j][i]);
				}
			}
		}

		System.out.println(sb);
	}
}