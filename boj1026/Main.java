package boj1026;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());

		ArrayList<Integer> array[] = new ArrayList[2];

		for (int k = 0; k < 2; k++) {
			st = new StringTokenizer(br.readLine());
			array[k] = new ArrayList<>();
			for (int i = 0; i < n; i++) {
				array[k].add(Integer.parseInt(st.nextToken()));
			}
		}

		array[0].sort(null);
		array[1].sort(Collections.reverseOrder());

		int sum = 0;
		for (int i = 0; i < n; i++) {
			sum = sum + array[0].get(i) * array[1].get(i);
		}

		System.out.println(sum);
	}
}