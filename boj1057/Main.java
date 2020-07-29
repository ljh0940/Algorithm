package boj1057;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int first = Integer.parseInt(st.nextToken());
		int second = Integer.parseInt(st.nextToken());

		if (first > second) {
			int temp = first;
			first = second;
			second = temp;
		}

		int count = 1;
		while ((first % 2 == 0) || (second - first) != 1) {
			first = (first + 1) / 2;
			second = (second + 1) / 2;
			count++;
		}

		System.out.println(count);
	}
}