package boj10972;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int index = findIndex();

		if (index == -1) {
			System.out.println(index);
			return;
		}

		for (int i = n - 1; i >= index; i--) {
			if (arr[i] > arr[index - 1]) {
				int temp = arr[i];
				arr[i] = arr[index - 1];
				arr[index - 1] = temp;
				swap(index);
				break;
			}
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < arr.length; i++)
			sb.append(arr[i]).append(" ");

		System.out.print(sb.toString());
	}

	static void swap(int index) {
		for (int i = 0; i < (n - index) / 2; i++) {
			int temp = arr[index + i];
			arr[index + i] = arr[n - 1 - i];
			arr[n - 1 - i] = temp;
		}
	}

	static int findIndex() {
		for (int i = n - 1; i > 0; i--) {
			if (arr[i - 1] < arr[i])
				return i;
		}

		return -1;
	}
}