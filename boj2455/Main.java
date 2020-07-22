package boj2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;

		int max = 0;
		int people = 0;
		int count = 0;
		do {
			st = new StringTokenizer(br.readLine());
			int out = Integer.parseInt(st.nextToken());
			int in = Integer.parseInt(st.nextToken());

			if (count != 3)
				people = people + in - out;

			if (people > max)
				max = people;

			count++;
		} while (count != 4);

		System.out.println(max);
	}
}