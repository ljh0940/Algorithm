package boj1461;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Main {
	static int n;
	static int m;
	static int count = 0;
	static int min = 0;
	static int max = 0;

	static ArrayList<Integer> left;
	static ArrayList<Integer> right;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		left = new ArrayList<>();
		right = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			if (temp > 0) {
				right.add(temp);
				if (temp > max)
					max = temp;
			} else {
				left.add(-temp);
				if (-temp > min)
					min = -temp;
			}
		}

		right.sort(null);
		left.sort(null);

		if (min > max) {
			calc(right, false);
			calc(left, true);
		} else {
			calc(left, false);
			calc(right, true);
		}

		System.out.println(count);
	}

	static void calc(ArrayList<Integer> arr, boolean flag) {
		int mod = arr.size() % m;
		int index = mod - 1;

		if (arr.size() < m) {
			if (mod != 0) {
				if (flag == true && arr.size() - 1 == index) {
					count = count + arr.get(index);
					return;
				} else
					count = count + 2 * arr.get(index);
			}
		} else {
			if (mod != 0) {
				count = count + 2 * arr.get(index);
			}
		}

		index = index + m;
		while (arr.size() > index) {
			if (flag == true && arr.size() - 1 == index) {
				count = count + arr.get(index);
				break;
			}
			count = count + 2 * arr.get(index);
			index = index + m;
		}
	}

}