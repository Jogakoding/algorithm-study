import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int answer = 0;
	private static int[][] map;
	private static int[][] visited;
	private static int M;
	private static int N;
	private static int[][] d = {{0,1},{0,-1},{1,0},{-1,0}};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M+2][N+2];
		visited = new int[M+2][N+2];
		
		for (int i = 0; i < M+2; i++) {
			map[i][0] = Integer.MAX_VALUE;
			map[i][N+1] = Integer.MAX_VALUE;
		}
		for (int i = 0; i < N+2; i++) {
			map[0][i] = Integer.MAX_VALUE;
			map[M+1][i] = Integer.MAX_VALUE;
		}
		
		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visited[i][j] = -1;
			}
		}
		
		System.out.println(findRoute(1,1));
		
	}
	
	private static int findRoute(int row, int col) {
		if(row==M && col==N) {
			return 1;
		}
		
		int current = map[row][col];
		int answer = 0;
		
		if(visited[row][col]==-1) {
			visited[row][col] = 0;
			for (int i = 0; i < 4; i++) {
				int nr = row + d[i][0];
				int nc = col + d[i][1];
				
				if(map[nr][nc]== -1) continue;
				if(map[nr][nc] < current) {
					visited[row][col] += findRoute(nr,nc);
					
				}
				
			}
		}
		
		return visited[row][col];
	}
}
