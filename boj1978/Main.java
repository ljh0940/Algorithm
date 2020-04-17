package boj1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {

	static int arr[] = new int[1001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int count = 0;

		arr[1] = 1;

		for (int i = 2; i <= Math.sqrt(1000); i++) {
			delete(i);
		}

		int temp = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {

			temp = Integer.parseInt(st.nextToken());
			if (arr[temp] == 0)
				count++;
		}

		System.out.println(count);
	}

	static void delete(int n) {
		int temp = n * 2;

		while (temp < 1001) {
			arr[temp] = 1;
			temp = temp + n;
		}
	}

}