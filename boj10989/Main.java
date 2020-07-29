package boj10989;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int array[] = new int[n];

		for (int i = 0; i < n; i++)
			array[i] = Integer.parseInt(br.readLine());

		Arrays.sort(array);

		StringBuilder sb = new StringBuilder();
		for (int i : array)
			sb.append(i).append("\n");

		System.out.print(sb.toString());
	}
}