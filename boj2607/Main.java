package boj2607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		int count = 0;
		String first = br.readLine();
		int arr[] = new int[26];
		int arr2[] = new int[26];
		boolean flag = false;

		for (int i = 0; i < first.length(); i++) {
			char c = first.charAt(i);
			arr[c - 'A']++;
		}

		for (int k = 0; k < n - 1; k++) {
			String str = br.readLine();

			if (Math.abs(first.length() - str.length()) >= 2)
				continue;

			int difference = 0;
			copy(arr, arr2);
			flag = false;
			for (int i = 0; i < str.length(); i++) {
				char c = str.charAt(i);
				arr2[c - 'A']--;
			}

			int temp = 0;
			for (int j = 0; j < 26; j++) {
				if (Math.abs(arr2[j]) >= 2) {
					flag = true;
					break;
				}
				difference = difference + arr2[j];
				temp = temp + Math.abs(arr2[j]);
				if (temp >= 3) {
					flag = true;
					break;
				}
				if (difference == 0)
					flag = false;
			}

			if (flag == false) {
				count++;
			}
		}

		System.out.println(count);
	}

	static void copy(int ori[], int copy[]) {
		for (int i = 0; i < ori.length; i++) {
			copy[i] = ori[i];
		}
	}
}