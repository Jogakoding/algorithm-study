package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_2805 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= T; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 0;
			int[][] board = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String row =br.readLine();
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(String.valueOf(row.charAt(j)));
					if(i==N/2)	answer += board[i][j];
				}
			}
			System.out.println(answer);
			
			for (int j= 1; j < N/2+1; j++) {
				answer += board[N/2-j][N/2];
				answer += board[N/2+j][N/2];
				for (int i = 0,cnt=(N-2*j)/2; cnt>0;cnt--) {
					answer+= board[N/2-j][N/2-(++i)];
					answer+= board[N/2-j][N/2+i];
					answer+= board[N/2+j][N/2-i];
					answer+= board[N/2+j][N/2+i];
				}
			}
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
