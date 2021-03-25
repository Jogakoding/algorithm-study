package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1520_내리막길 {
	static int arr[][], map[][];
	static int n, m, answer;

	static int dy[] = { 0, 1, 0, -1 };
	static int dx[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] str = br.readLine().split(" ");
		n = Integer.parseInt(str[0]);
		m = Integer.parseInt(str[1]);

		arr = new int[n][m];
		map = new int[n][m];
		for (int i = 0; i < n; i++) {
			String[] temp = br.readLine().split(" ");
			for (int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(temp[j]);
				map[i][j] = -1;
			}
		}
		System.out.println(dfs(n - 1, m - 1));
	}

	private static int dfs(int y, int x) {
		if (y == 0 && x == 0) {
			return 1;
		}

		// 방문하지 않음
		if (map[y][x] == -1) {
			map[y][x] = 0;
			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (nx >= 0 && ny >= 0 && ny < n && nx < m) {
					if (arr[ny][nx] > arr[y][x]) {
						map[y][x] += dfs(ny, nx);
					}
				}
			}
		}
		return map[y][x];

	}
}
