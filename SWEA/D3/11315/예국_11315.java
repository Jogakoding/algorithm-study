package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_11315 {

	private static int[][] board;
	private static int N;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for (int testCase = 1; testCase <= T; testCase++) {
			N = Integer.parseInt(br.readLine());
			board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String row = br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = String.valueOf(row.charAt(j)).equals(".")?0:1;
				}	
			}
			
			sb.append("#").append(testCase).append(" ").append(check()).append("\n");	
		}
		System.out.println(sb);

	}

	private static String check() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(board[i][j]==1) {
					if(checkRow(i,j) || checkCol(i,j) || checkDiagnal(i,j))
						return "YES";
				}
			}
		}
		
		return "NO";	
	}

	private static boolean checkDiagnal(int i, int j) {
		if(i+4<N && j-4>=0) {
			for (int k = 1; k < 5; k++) {
				if(board[i+k][j-k]==0)
					return false;
			}
		}else if(i+4<N && j+4<N) {
			for (int k = 1; k < 5; k++) {
				if(board[i+k][j+k]==0)
					return false;
			}
		}else	return false;
		
		return true;
	}

	private static boolean checkCol(int i, int j) {
		if(i+4>=N)	return false;
		
		for (int i2 = 1; i2 < 5; i2++) {
			if(board[i+i2][j]==0)
				return false;
		}
		return true;
	}

	private static boolean checkRow(int i, int j) {
		if(j+4>=N)	return false;
		
		for (int j2 = 1; j2 < 5; j2++) {
			if(board[i][j+j2]==0)
				return false;
		}
		return true;
	}

}
