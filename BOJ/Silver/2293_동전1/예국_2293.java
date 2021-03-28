package com.ssafy.boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2293 {
	private static int answer = 0;
	private static int[] coin;
	private static int N,K;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		coin = new int[N];
		
		for (int i = 0; i < N; i++) {
			coin[i] = Integer.parseInt(br.readLine());
		}
		
		Arrays.sort(coin);
		//getCombi(N-1,K);
		
		int[] dp = new int[K+1];
		dp[0] = 1;
		for (int cIdx = 0; cIdx < N; cIdx++) {
			for (int i = coin[cIdx]; i <= K; i++) {
				dp[i] += dp[i-coin[cIdx]];
			}
		}
		
		System.out.println(dp[K]);
	}
	
//	private static void getCombi(int idx, int remain) {
//		System.out.println(idx+" "+remain);
//		if(idx==-1) {
//			if(remain==0)
//				answer++;
//			return;
//		}
//		
//		
//		int max = remain/coin[idx];
//		for (; max>=0; max--) {
//			getCombi(idx-1,remain-max*coin[idx]);
//		}
//	}

}
