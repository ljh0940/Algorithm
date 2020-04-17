package boj1977;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());

		int sum = 0;

		int temp = (int) Math.sqrt(m - 1) + 1;
		int min = (int) Math.pow(temp, 2);

		boolean flag = false;
		while (Math.pow(temp, 2) >= m && Math.pow(temp, 2) <= n) {
			flag = true;
			sum = sum + (int) Math.pow(temp, 2);
			temp++;
		}

		if (flag == false)
			System.out.println(-1);
		else {
			System.out.println(sum);
			System.out.println(min);
		}

	}
}