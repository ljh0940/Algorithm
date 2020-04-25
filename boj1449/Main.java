package boj1449;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int l;
	static int count = 0;
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < n; i++) {
			if (arr[i] == 0)
				continue;

			count++;
			float start = (float) (arr[i] - 0.5);
			float end = start + l;
			for (int j = i + 1; j < n; j++) {
				if (arr[j] <= end) {
					arr[j] = 0;
				} else {
					break;
				}
			}
		}

		System.out.println(count);
	}

}