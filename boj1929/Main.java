package boj1929;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int arr[];
	static int min;
	static int max;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String str[] = br.readLine().split(" ");
		min = Integer.parseInt(str[0]);
		max = Integer.parseInt(str[1]);

		arr = new int[max + 1];
		arr[1] = 1;

		for (int i = 2; i < max / 2; i++) {
			delete(i);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = min; i <= max; i++) {
			if (arr[i] == 0) {
				sb.append(i).append("\n");
			}
		}

		System.out.print(sb);
	}

	static void delete(int n) {
		int temp = 2 * n;

		while (temp <= max) {
			arr[temp] = 1;
			temp = temp + n;
		}
	}
}