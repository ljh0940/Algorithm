package boj1138;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());

		int arr[] = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			int value = Integer.parseInt(st.nextToken());
			int count = 0;
			for (int j = 1; j <= n; j++) {
				if (arr[j] != 0)
					continue;
				if (count == value) {
					arr[j] = i;
					break;
				}

				count++;
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(arr[i]).append(" ");
		}

		System.out.println(sb.toString());
	}
}