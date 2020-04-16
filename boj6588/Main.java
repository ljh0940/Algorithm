package boj6588;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	static int n;
	static int arr[] = new int[2];

	static int numArray[] = new int[1000001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringBuilder sb = new StringBuilder();

		for (int i = 2; i <= numArray.length; i++) {
			delete(i);
		}

		while (true) {
			n = Integer.parseInt(br.readLine());

			if (n == 0) {
				System.out.print(sb);
				return;
			}

			solve();

			sb.append(n).append(" = ").append(arr[0]).append(" + ").append(arr[1]).append("\n");
		}

	}

	static void solve() {
		for (int i = n - 2; i >= n / 2; i--) {
			int temp = n - i;
			if (temp == 1)
				continue;

			if (numArray[i] == 1)
				continue;

			if (numArray[temp] == 1)
				continue;

			arr[0] = Math.min(i, temp);
			arr[1] = Math.max(i, temp);
			break;
		}
	}

	static void delete(int num) {
		int temp = num * 2;
		while (temp < numArray.length) {
			if (numArray[temp] == 1) {
				temp = temp + num;
				continue;
			}
			numArray[temp] = 1;
			temp = temp + num;
		}
	}
}