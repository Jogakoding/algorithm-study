package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class SWEA_2819_격자판의숫자이어붙이기 {
	static int n;
	static int dy[] = { 1, 0, -1, 0 };
	static int dx[] = { 0, 1, 0, -1 };
	static String arr[][];
	static HashSet<String> hash;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		for (int t = 1; t <= n; t++) {

			hash = new HashSet<String>();
			arr = new String[4][4];
			for (int i = 0; i < 4; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 4; j++) {
					arr[i][j] = st.nextToken();
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					dfs(i, j, 0, "");
				}
			}
			System.out.println("#" + t + " " + hash.size());
		}
	}

	private static void dfs(int y, int x, int cnt, String number) {
		if (cnt == 7) {
			hash.add(number);
			//System.out.println(number);
			return;
		}
		
		number+=arr[y][x];
		for (int dir = 0; dir < 4; dir++) {
			int nx=x+dx[dir];
			int ny=y+dy[dir];
			
			if(nx>=0&&ny>=0&&nx<4&&ny<4) {
				dfs(ny,nx,cnt+1,number);
			}
		}

	}
}
