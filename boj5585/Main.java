package boj5585;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	static int coinCount = 0;
	static int change = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int money = Integer.parseInt(br.readLine());

		change = 1000 - money;

		calcChange(500);
		calcChange(100);
		calcChange(50);
		calcChange(10);
		calcChange(5);
		calcChange(1);

		System.out.println(coinCount);
	}

	static void calcChange(int coin) {
		coinCount = coinCount + change / coin;
		change = change % coin;
	}

}