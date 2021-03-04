package com.ssafy.swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution_9778 {
	private static int[] cards;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		for (int testCase = 1; testCase <= TC; testCase++) {
			int N = Integer.parseInt(br.readLine());
			int sum = 0;
			String answer = "STOP";
			cards  = new int[12];
			
			for (int i = 0; i < N; i++) {
				int num = Integer.parseInt(br.readLine());
				cards[num]++;
				sum += num;
			}
			
			int possible = 21 - sum;
			
			int ok = 0;
			int no = 0;
			
			for (int i = 2; i < 12; i++) {
				if(i<=possible)
					ok += 4 - cards[i];
				else
					no += 4 - cards[i];
			}
			
			if(ok>no) {
				answer = "GAZUA";
			}
			
			sb.append("#").append(testCase).append(" ").append(answer).append("\n");
		}
		System.out.println(sb);
	}

}
