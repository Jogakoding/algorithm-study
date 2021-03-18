package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2206 {
	private static int answer = -1;
	private static int N;
	private static int M;
	private static int[] dr = {0,1,0,-1};
	private static int[] dc = {1,0,-1,0};
	private static int[][] map;
	private static boolean[][][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		map = new int[N+2][M+2];
		visited = new boolean[N+2][M+2][2];
		
		for (int i = 0; i < N+2; i++) {
			map[i][0] = 2;
			map[i][M+1] = 2;
		}
		for (int i = 0; i < M+2; i++) {
			map[0][i] = 2;
			map[N+1][i] = 2;
		}
		
		for (int i = 1; i <= N; i++) {
			String s = br.readLine();
			for (int j = 1; j <= M; j++) {
				map[i][j] = s.charAt(j-1)=='0' ? 0:1;
			}
		}
		
		findRoute(1,1);
		System.out.println(answer);
	}

	private static void findRoute(int r, int c) {
		Queue<Integer[]> queue = new LinkedList<>();
		int count = 0;
		queue.add(new Integer[] {r,c,0});
		visited[r][c][0] = true;
		visited[r][c][1] = true;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			//System.out.println(">>>> "+size+"<<<<");
			count++;
			while(size-->0) {
				Integer[] pick = queue.poll();
				//System.out.println(Arrays.toString(pick));
				
				if(pick[0]==N && pick[1]==M) {
					answer = count;
					return;
				}
				
				for (int i = 0; i < 4; i++) {					
					int nr = pick[0] + dr[i];
					int nc = pick[1] + dc[i];
					
					if(map[nr][nc]==2 || visited[nr][nc][pick[2]]) continue;
					else if(map[nr][nc]==0) {
						visited[nr][nc][pick[2]] = true;
						queue.offer(new Integer[] {nr,nc,pick[2]});
					}else if(pick[2]==0 && !visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						queue.offer(new Integer[] {nr,nc,1});
					}
				}
			}
		}
	}

}
