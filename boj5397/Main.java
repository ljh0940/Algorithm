package boj5397;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();

		for (int k = 0; k < t; k++) {
			LinkedList<Character> list = new LinkedList<>();
			int pointer = 0;
			int length = 0;

			String command = br.readLine();

			for (int i = 0; i < command.length(); i++) {
				char typing = command.charAt(i);

				if (typing == '<') {
					if (pointer > 0)
						pointer--;
				} else if (typing == '>') {
					if (pointer < length)
						pointer++;
				} else if (typing == '-') {
					if (pointer > 0) {
						list.remove(pointer - 1);
						pointer--;
						length--;
					}
				} else {
					list.add(pointer, typing);
					pointer++;
					length++;
				}
			}

			Iterator<Character> iter = list.iterator();
			while (iter.hasNext()) {
				bw.write(iter.next());
			}
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}
}