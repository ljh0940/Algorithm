package boj2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//class Main {
//	static int n;
//	static int m;
//	static int count = 0;
//
//	static int arr[];
//
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//
//		n = Integer.parseInt(st.nextToken());
//		m = Integer.parseInt(st.nextToken());
//
//		arr = new int[n];
//
//		st = new StringTokenizer(br.readLine());
//		for (int i = 0; i < n; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//
//		for (int i = 0; i < n; i++) {
//			int num = 0;
//			for (int j = 0; i + j < n; j++) {
//				num = num + arr[i + j];
//				if (num == m) {
//					count++;
//					break;
//				}
//				if (num > m)
//					break;
//			}
//		}
//
//		System.out.println(count);
//	}
//}

class Main {
	static int n;
	static int m;
	static int count = 0;

	static int arr[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int end = 0;
		int sum = 0;

		for (int start = 0; start < n; start++) {
			sum = sum + arr[start];

			if (sum == m) {
				count++;
				sum = sum - arr[end];
				end++;
			}

			if (sum > m) {
				while (sum > m) {
					sum = sum - arr[end];
					end++;
				}

				if (sum == m) {
					count++;
					sum = sum - arr[end];
					end++;
				}
			}
		}

		System.out.println(count);
	}
}