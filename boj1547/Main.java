package boj1547;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		int cups[] = new int[3];
		for (int i = 0; i < cups.length; i++) {
			cups[i] = i + 1;
		}

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());

			int first = Integer.parseInt(st.nextToken()) - 1;
			int second = Integer.parseInt(st.nextToken()) - 1;

			if (first == second)
				continue;

			swap(cups, first, second);
		}

		for (int i = 0; i < 3; i++) {
			if (cups[i] == 1) {
				System.out.println(i + 1);
				return;
			}
		}
	}

	static void swap(int cups[], int first, int second) {
		int temp = cups[first];
		cups[first] = cups[second];
		cups[second] = temp;
	}
}