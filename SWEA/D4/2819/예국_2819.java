package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringJoiner;
import java.util.StringTokenizer;

public class Solution_2819 {

	private static HashSet answer;
	private static String[][] board;
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {1,0,-1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringJoiner sj = new StringJoiner("\n");
		
		int T = Integer.parseInt(br.readLine());
		
		
		for (int tc = 1; tc <= T; tc++) {
			board = new String[4][4];
			answer = new HashSet<>();
			
			for (int i = 0; i < 4; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < 4; j++) {
					board[i][j] = String.valueOf(st.nextToken());
				}
			}
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					find(i,j,0,"");
				}
			}
			
			String line = "#"+tc+" "+answer.size();
			sj.add(line);
		}
		System.out.println(sj.toString());
	}

	private static void find(int x, int y, int k, String string) {
		if(k==7) {
			answer.add(string);
			return;
		}
		
		int nx, ny;
		
		for (int i = 0; i < 4; i++) {
			nx = x+dx[i];
			ny = y+dy[i];
			if(nx<0 || nx >=4 || ny<0 || ny >= 4)	continue;
			find(nx,ny,k+1,string+board[nx][ny]);
		}
		
	}

}
