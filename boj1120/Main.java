package boj1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String strings[] = br.readLine().split(" ");

		int min = Integer.MAX_VALUE;
		String first = strings[0];
		String second = strings[1];

		int gapSize = second.length() - first.length();

		for (int i = 0; i <= gapSize; i++) {
			int gap = calcGap(second.substring(i, i + first.length()), first);
			if (gap < min)
				min = gap;
		}

		System.out.println(min);
	}

	static int calcGap(String first, String second) {
		int count = 0;

		for (int i = 0; i < first.length(); i++) {
			if (first.charAt(i) != second.charAt(i))
				count++;
		}

		return count;
	}
}