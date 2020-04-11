package boj14891;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Main {
	static LinkedList<Character> gear[];
	static boolean flag[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		gear = new LinkedList[4];

		for (int i = 0; i < 4; i++) {
			gear[i] = new LinkedList<Character>();
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++)
				gear[i].add(str.charAt(j));
		}

		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int gearNum = Integer.parseInt(st.nextToken());
			int order = Integer.parseInt(st.nextToken());

			flag = new boolean[4];
			rotate(gearNum - 1, order);
			flag[gearNum - 1] = true;

			for (int j = 0; j < 4; j++) {
				if (flag[j] == false)
					continue;
				int temp = Math.abs(gearNum - 1) % 2;
				gearRotate(j, j % 2 == temp ? order : order * -1);
			}
		}

		int sum = 0;

		for (int i = 0; i < 4; i++) {
			if (gear[i].get(0) == '1')
				sum = sum + (int) Math.pow(2, i);
		}

		System.out.println(sum);
	}

	static void gearRotate(int gearNum, int order) {
		if (order == -1) {
			char temp = gear[gearNum].get(0);
			gear[gearNum].removeFirst();
			gear[gearNum].add(temp);
		} else {
			char temp = gear[gearNum].get(7);
			gear[gearNum].removeLast();
			gear[gearNum].addFirst(temp);
		}
	}

	static void rotate(int gearNum, int order) {
		if (gearNum + 1 < 4) {
			if (gear[gearNum].get(2) != gear[gearNum + 1].get(6)) {
				if (flag[gearNum + 1] != true) {
					flag[gearNum] = true;
					flag[gearNum + 1] = true;
					rotate(gearNum + 1, order * -1);
				}
			}
		}
		if (gearNum - 1 >= 0) {
			if (gear[gearNum - 1].get(2) != gear[gearNum].get(6)) {
				if (flag[gearNum - 1] != true) {
					flag[gearNum - 1] = true;
					flag[gearNum] = true;
					rotate(gearNum - 1, order * -1);
				}
			}
		}
	}
}