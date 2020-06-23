package boj16637;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

class Number {
	char oper;
	int number;
	int order;

	Number(char oper, int number) {
		this.oper = oper;
		this.number = number;
	}
}

class Main {
	static int max = Integer.MIN_VALUE;
	static ArrayList<Number> arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		arr = new ArrayList<>();

		String str = br.readLine();
		for (int i = 0; i < str.length(); i = i + 2) {
			int num = str.charAt(i) - '0';
			if (i == 0) {
				arr.add(new Number('+', num));
				continue;
			}
			char oper = str.charAt(i - 1);

			arr.add(new Number(oper, num));
		}

		calc2();

		combination(0, 0, arr.size() / 2);

		System.out.println(max);

	}

	static void combination(int index, int depth, int count) {
		if (depth == count) {

			return;
		}

		for (int i = index; i < arr.size() - 1; i++) {
			Number num = arr.get(i);
			Number nextNum = arr.get(i + 1);
			if (num.order != 0)
				continue;

			nextNum.order = 1;
			int temp = num.number;
			num.number = calc1(temp, nextNum);
			calc2();
			combination(i + 2, depth, count + 1);
			num.number = temp;
			nextNum.order = 0;
		}
	}

	static int calc1(int sum, Number num) {
		if (num.oper == '+') {
			sum = sum + num.number;
		} else if (num.oper == '-') {
			sum = sum - num.number;
		} else {
			sum = sum * num.number;
		}

		return sum;
	}

	static void calc2() {
		int sum = 0;
		for (Number num : arr) {
			if (num.order == 1)
				continue;
			sum = calc1(sum, num);
		}

		if (sum > max)
			max = sum;
	}
}