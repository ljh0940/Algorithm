package boj13458;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int room[] = new int[n];
		int main = 0;
		int sub = 0;
		long count = 0;

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			room[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		main = Integer.parseInt(st.nextToken());
		sub = Integer.parseInt(st.nextToken());

		for (int i = 0; i < n; i++) {
			room[i] = room[i] - main;
			count++;
			if (room[i] <= 0)
				continue;

			if (room[i] % sub == 0)
				count = count + room[i] / sub;
			else
				count = count + room[i] / sub + 1;
		}

		System.out.println(count);

	}
}