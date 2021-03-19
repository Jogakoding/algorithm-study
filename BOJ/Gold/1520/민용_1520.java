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
				map[i][j]=-1;
			}
		}
		dfs();
		System.out.println(map[n - 1][m - 1]);
	}

	static class pos {
		int y;
		int x;

		public pos(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
	}

	private static void dfs() {
		Stack<pos> stack = new Stack<pos>();
		stack.push(new pos(n-1, m-1));

		while (!stack.isEmpty()) {
			pos p = stack.pop();
			int y = p.y;
			int x = p.x;

			for (int dir = 0; dir < 4; dir++) {
				int ny = y + dy[dir];
				int nx = x + dx[dir];

				if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				if (ny == 0 && nx == 0) {
					map[ny][nx] += 1;
					continue;
				}

				if (arr[y][x] < arr[ny][nx]) {
					stack.push(new pos(ny, nx));
				}

				map[ny][nx] += 1;
			}
		}
	}
}
//	private static void bfs() {
//		Queue<pos> q = new LinkedList<pos>();
//		q.offer(new pos(0, 0));
//
//		while (!q.isEmpty()) {
//			pos p = q.poll();
//			int y = p.y;
//			int x = p.x;
//
//			for (int dir = 0; dir < 4; dir++) {
//				int ny = y + dy[dir];
//				int nx = x + dx[dir];
//
//				if (ny < 0 || nx < 0 || ny >= n || nx >= m) {
//					continue;
//				}
//				if (ny == n - 1 && nx == m - 1) {
//					map[ny][nx] += 1;
//					continue;
//				}
//
//				if (arr[y][x] > arr[ny][nx]) {
//					q.offer(new pos(ny, nx));
//				}
//
//				map[ny][nx] += 1;
//
//			}
//		}
//	}

//}
