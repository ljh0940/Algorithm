package boj1963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Num {
	int num;
	int count;

	Num(int num, int count) {
		this.num = num;
		this.count = count;
	}
}

class Main {
	static int sosu[] = new int[10000];
	static ArrayList<Integer> arr;
	static boolean checked[];

	static int first;
	static int last;
	static int min = Integer.MAX_VALUE;

	static boolean flag = false;

	static Queue<Num> q;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int t = Integer.parseInt(st.nextToken());
		arr = new ArrayList<>();

		sosu[0] = 1;
		sosu[1] = 1;
		for (int i = 2; i < 10000; i++) {
			delete(i);
		}

		for (int i = 1000; i < 10000; i++) {
			if (sosu[i] == 0)
				arr.add(i);
		}

		for (int k = 0; k < t; k++) {
			q = new LinkedList<>();
			checked = new boolean[arr.size()];
			st = new StringTokenizer(br.readLine());

			first = Integer.parseInt(st.nextToken());
			last = Integer.parseInt(st.nextToken());

			for (int i = 0; i < arr.size(); i++) {
				if (arr.get(i) == first) {
					checked[i] = true;
					q.add(new Num(arr.get(i), 0));
					break;
				}
			}
			bfs();
		}

	}

	static void bfs() {
		while (!q.isEmpty()) {
			Num n = q.poll();

			if (n.num == last) {
				System.out.println(n.count);
				return;
			} else {
				calc(n.num, n.count);
			}
		}
	}

	static void calc(int n, int depth) {
		int n1 = n % 10;
		int n2 = n / 10 % 10;
		int n3 = n / 100 % 10;
		int n4 = n / 1000 % 10;

		for (int i = 0; i < arr.size(); i++) {
			int count = 0;
			int temp = arr.get(i);

			if (checked[i] == true)
				continue;

			if (temp == n)
				continue;

			if (n4 == temp / 1000 % 10)
				count++;
			if (n3 == temp / 100 % 10)
				count++;
			if (n2 == temp / 10 % 10)
				count++;
			if (n1 == temp % 10)
				count++;

			if (count == 3) {
				checked[i] = true;
				q.add(new Num(temp, depth + 1));
			}

		}

	}

	static void delete(int n) {
		int temp = 2 * n;
		while (temp < 10000) {
			sosu[temp] = 1;
			temp = temp + n;
		}
	}
}