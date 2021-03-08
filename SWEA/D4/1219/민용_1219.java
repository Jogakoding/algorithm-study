package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SWEA_1219_길찾기 {
	static int[][] arr;
	static int n, answer;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		for (int t = 1; t <= 10; t++) {
			String[] str = br.readLine().split(" ");
			n = Integer.parseInt(str[1]);
			arr = new int[n][2];
			String[] tmp = br.readLine().split(" ");
			for (int i = 0; i < n * 2; i += 2) {
				int start = Integer.parseInt(tmp[i]);
				int dest = Integer.parseInt(tmp[i + 1]);
				if (arr[start][0] == 0) {
					arr[start][0] = dest;
				} else {
					arr[start][1] = dest;
				}
			}
			answer = 0;
			dfs(0);
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int num) {
		if (num == 99) {
			answer = 1;
			return;
		}

		for (int i = 0; i < 2; i++) {
			if (arr[num][i] != 0) {
				dfs(arr[num][i]);
			}
		}
	}
}
