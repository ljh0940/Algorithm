package boj2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();
		int arr[] = new int[10];

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		int temp = a * b * c;

		int count = 10;
		while (temp > 0) {
			arr[temp % count]++;
			temp = temp / 10;
		}

		for (int i = 0; i < 10; i++) {
			sb.append(arr[i]).append("\n");
		}
		System.out.print(sb);
	}
}