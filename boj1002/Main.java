package boj1002;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());

		for (int k = 0; k < t; k++) {
			st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());

			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			// ��ġ�ϴ� ��� - ������ ���� ���
			if (x1 == x2 && y1 == y2 && r1 == r2) {
				System.out.println(-1);
				continue;
			}

			// ���� ���ο� �ְ� �� ��ħ
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) < abs(r1 - r2)) {
				System.out.println(0);
				continue;
			}

			// �� ����
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) == abs(r1 - r2)) {
				System.out.println(1);
				continue;
			}

			// �� ����
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) == abs(r1 + r2)) {
				System.out.println(1);
				continue;
			}

			// ���� �ۿ� �ִ� ���
			else if (Math.sqrt((pow(x1 - x2) + pow(y1 - y2))) > r1 + r2) {
				System.out.println(0);
				continue;
			}

			else {
				System.out.println(2);
				continue;
			}

		}
	}

	static int abs(int n) {
		if (n > 0)
			return n;
		else
			return -n;
	}

	static int pow(int n) {
		return n * n;
	}
}