package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 나의 설계.
 * 0행에서 오른쪽방향을 0으로 놓고, 벽이나 채워진 숫자칸을 만나면 다음 방향으로 보내는 것으로..
 * 
 * 
 * */

public class SWEA_1954 {
	static int dir = 0;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 

		int TC = Integer.parseInt(br.readLine());

		for (int T = 1; T <= TC; T++) {
			dir=0;
			int n =Integer.parseInt(br.readLine());
			int[][] arr = new int[n][n];
			int y = 0, x = 0;
			
			for (int i = 1; i <= n * n; i++) {
				arr[y][x] = i;
				int ny = y + dy[dir];
				int nx = x + dx[dir];
				if (ny >= 0 && nx >= 0 && ny < n && nx < n && arr[ny][nx] == 0) {
					y = ny;
					x = nx;
					continue;
				} else {

					dir = (dir + 1) % 4;
					y = y + dy[dir];
					x = x + dx[dir];
				}
			}
			
			System.out.println("#"+T);
			for(int p=0;p<n;p++) {
				for(int k=0;k<n;k++) {
				System.out.print(arr[p][k]+" ");
				}
				System.out.println();
			}
		}
	}
}
