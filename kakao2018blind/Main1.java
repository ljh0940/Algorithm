package kakao2018blind;

class Main1 {
	public static void main(String[] args) {
		Solution sol = new Solution();
		int n = 5;
		int arr1[] = { 9, 20, 28, 18, 11 };
		int arr2[] = { 30, 1, 21, 17, 28 };
		sol.solution(n, arr1, arr2);
	}

}

class Solution {
	public String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];
		int map1[][] = new int[n][n];
		int map2[][] = new int[n][n];

		toBinary(n, arr1, map1);
		toBinary(n, arr2, map2);

		makeMap(map1, map2, answer);

		return answer;
	}

	void makeMap(int map1[][], int map2[][], String answer[]) {
		for (int i = 0; i < map1.length; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < map1[i].length; j++) {
				sb.append(map1[i][j] + map2[i][j] >= 1 ? "#" : " ");
			}
			answer[i] = sb.toString();
		}
	}

	void toBinary(int n, int arr[], int map[][]) {
		for (int i = 0; i < n; i++) {
			int temp = arr[i];
			int index = n - 1;
			while (temp > 0) {
				map[i][index] = temp % 2;
				temp = temp / 2;
				index--;
			}
			while (index >= 0) {
				map[i][index] = 0;
				index--;
			}
		}

	}
}