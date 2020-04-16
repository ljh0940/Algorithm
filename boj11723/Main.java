package boj11723;

// 비트마스킹
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int num = 0;
		int bit = 0;

		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			String command = str[0];
			if (str.length == 2)
				num = Integer.parseInt(str[1]) - 1;

			if (command.equals("add")) {
				bit = bit | 1 << num;
			} else if (command.equals("remove")) {
				bit = bit & ~(1 << num);
			} else if (command.equals("check")) {
				if (bit == ((1 << num) | bit)) {
					bw.write(1 + "\n");
				} else {
					bw.write(0 + "\n");
				}
			} else if (command.equals("toggle")) {
				bit = bit ^ (1 << num);
			} else if (command.equals("all")) {
				bit = bit | ((1 << 21) - 1);
			} else if (command.equals("empty")) {
				bit = 0;
			}
		}

		bw.close();

	}
}

/* 내가 푼 방식
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		HashSet<Integer> hash = new HashSet<>();
		int num = 0;
		boolean toggle = false;

		for (int i = 0; i < n; i++) {
			String str[] = br.readLine().split(" ");
			String command = str[0];
			if (str.length == 2)
				num = Integer.parseInt(str[1]);

			if (command.equals("add")) {
				if (toggle == false) {
					if (hash.contains(num) == false)
						hash.add(num);
				}
			} else if (command.equals("remove")) {
				if (toggle == false) {
					if (hash.contains(num) == true)
						hash.remove(num);
				} else {
					if (hash.contains(num) == false)
						hash.add(num);
				}
			} else if (command.equals("check")) {
				if (toggle == false) {
					if (hash.contains(num) == true)
						bw.append(1 + "\n");
					else
						bw.append(0 + "\n");
				} else {
					if (hash.contains(num) == true)
						bw.append(0 + "\n");
					else
						bw.append(1 + "\n");
				}
			} else if (command.equals("toggle")) {
				if (hash.contains(num) == false)
					hash.add(num);
				else
					hash.remove(num);
			} else if (command.equals("all")) {
				toggle = true;
				hash.clear();
			} else if (command.equals("empty")) {
				toggle = false;
				hash.clear();
			}
		}

		bw.close();

	}
}
*/