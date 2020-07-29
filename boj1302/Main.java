package boj1302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

class Book {
	String title;
	int orderNumber;

	Book(String title, int orderNumber) {
		this.title = title;
		this.orderNumber = orderNumber;
	}
}

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		HashMap<String, Integer> hashmap = new HashMap<>();
		for (int i = 0; i < n; i++) {
			String book = br.readLine();
			if (hashmap.containsKey(book))
				hashmap.put(book, hashmap.get(book) + 1);
			else
				hashmap.put(book, 1);
		}

		ArrayList<Book> arr = new ArrayList<>();

		Iterator<String> iter = hashmap.keySet().iterator();
		while (iter.hasNext()) {
			String title = iter.next();
			int orderNumber = hashmap.get(title);
			arr.add(new Book(title, orderNumber));
		}

		Comparator<Book> com = new Comparator<Book>() {

			@Override
			public int compare(Book o1, Book o2) {
				if (o1.orderNumber < o2.orderNumber)
					return 1;
				else if (o1.orderNumber == o2.orderNumber) {
					return o1.title.compareTo(o2.title);
				}
				return -1;
			}
		};

		arr.sort(com);

		System.out.println(arr.get(0).title);
	}
}